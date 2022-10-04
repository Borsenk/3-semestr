package lab1.task1;


public class SimpleLinkedList<T> implements SimpleList<T> {

    Node<T> first=null;
    Node<T> last=null;
    private int size=0;

    @Override
    public int size() {
        return size;
    }

    @Override
    public T get(int id) {
        return getNode(id).value;
    }

    @Override
    public T set(int id, T value) {
        Node<T> el=getNode(id);
        T old=el.value;
        el.value=value;
        return old;
    }

    @Override
    public boolean add(T value) {
        Node<T> el=new Node<>(last, value, null);
        if (first==null){
            first= el;
        }
        if (last!=null){
            last.next=el;
        }
        last=el;
        size++;
        return true;
    }

    @Override
    public T remove(int id) {
        Node<T> el=getNode(id);
        T old=el.value;
        if (el.prev!=null){
            el.prev.next=el.next;
        } else {
            first=el.next;
        }
        if (el.next!=null){
            el.next.prev=el.prev;
        } else {
            last=el.prev;
        }
        size--;
        return old;
    }

    @Override
    public boolean contains(T value) {
        Node<T> cur=first;
        while (cur!=null) {
            if (cur.value==value) return true;
            cur=cur.next;
        }
        return false;
    }

    @Override
    public void clear() {
        first=null;
        last=null;
    }

    Node<T> getNode(int id){
        Node<T> cur=first;
        for (int i=0;cur!=null;i++,cur=cur.next){
            if (i==id) return cur;
        }
        throw new IndexOutOfBoundsException();
    }

    static class Node<T> {
        T value;
        Node<T> next;
        Node<T> prev;

        Node(Node<T> prev, T element, Node<T> next) {
            this.value = element;
            this.next = next;
            this.prev = prev;
        }
    }
    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("[");
        Node<T> cur=first;
        while (cur!=null) {
            if (cur!=first) sb.append(", ");
            sb.append(cur.value);
            cur=cur.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
