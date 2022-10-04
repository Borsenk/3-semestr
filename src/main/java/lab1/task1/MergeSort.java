package lab1.task1;


import java.util.Comparator;

public class MergeSort {

    private static class SAL<T> {
        SimpleList<T> lst;
        int from=0;
        int to=0;

        SAL(SimpleList<T> lst) {
            this.lst = lst;
            to=lst.size();
        }

        SAL(SimpleList<T> lst, int from, int to) {
            this.lst = lst;
            this.from = from;
            this.to = to;
        }

        public int size() {
            return to - from;
        }

        public T get(int id) {
            return lst.get(from + id);
        }

        public void add(T val) {
            lst.add(val);
            to++;
        }

        public SAL<T> subList(int from, int to) {
            return new SAL<>(lst, this.from+from, this.from+to);
        }

        @Override
        public String toString() {
            var sb = new StringBuilder("[");
            for (int i=from;i<to;i++){
                if (i!=from) sb.append(", ");
                sb.append(lst.get(i));
            }
            sb.append("]");
            return sb.toString();
        }
    }

    public static <T> void sort(SimpleList<T> list, Comparator<T> comp) {
        if (list instanceof SimpleArrayList<T>){
            sort((SimpleArrayList<T>)list,comp);
        }
        if (list instanceof SimpleLinkedList<T>){
            sort((SimpleLinkedList<T>)list,comp);
        }
    }

    public static <T> void sort(SimpleArrayList<T> list, Comparator<T> comp) {
        var res = sorted(new SAL<>(list), comp);
        var arr=((SimpleArrayList<T>) res.lst);
        list.array = arr.array;
    }

    private static <T> SAL<T> sorted(SAL<T> list, Comparator<T> comp) {
        if (list.size() < 2) {
            return list;
        }
        int mid = list.size() / 2;
        return merge(
                sorted(list.subList(0, mid), comp),
                sorted(list.subList(mid, list.size()), comp), comp);
    }

    private static <T> SAL<T> merge(SAL<T> left, SAL<T> right, Comparator<T> comp) {
        int leftIndex = 0;
        int rightIndex = 0;
        SAL<T> merged = new SAL<>(new SimpleArrayList<>());

        while (leftIndex < left.size() && rightIndex < right.size()) {
            if (comp.compare(left.get(leftIndex), right.get(rightIndex)) < 0) {
                merged.add(left.get(leftIndex++));
            } else {
                merged.add(right.get(rightIndex++));
            }
        }
        addAll(merged, left, leftIndex);
        addAll(merged, right, rightIndex);
        return merged;
    }

    private static <T> void addAll(SAL<T> out, SAL<T> in, int from) {
        for (int i = from; i < in.size(); i++) {
            out.add(in.get(i));
        }
    }

    public static <T> void sort(SimpleLinkedList<T> list, Comparator<T> comp) {
        list.first = mergeSort(list.first, comp);
        SimpleLinkedList.Node<T> tmp = list.first;
        while (tmp != null) {
            list.last = tmp;
            tmp = tmp.next;
        }
    }


    private static <T> SimpleLinkedList.Node<T> sortedMerge(SimpleLinkedList.Node<T> a, SimpleLinkedList.Node<T> b, Comparator<T> comp) {
        SimpleLinkedList.Node<T> result;
        /* Base cases */
        if (a == null)
            return b;
        if (b == null)
            return a;

        /* Pick either a or b, and recur */
        if (comp.compare(a.value, b.value) <= 0) {
            result = a;
            result.next = sortedMerge(a.next, b, comp);
        } else {
            result = b;
            result.next = sortedMerge(a, b.next, comp);
        }
        if (result.next != null) {
            result.next.prev = result;
        }
        return result;
    }

    private static <T> SimpleLinkedList.Node<T> mergeSort(SimpleLinkedList.Node<T> h, Comparator<T> comp) {
        if (h == null || h.next == null) {
            return h;
        }

        SimpleLinkedList.Node<T> middle = getMiddle(h);
        SimpleLinkedList.Node<T> nextofmiddle = middle.next;

        // set the next of middle node to null
        middle.next = null;

        // Apply mergeSort on left list
        SimpleLinkedList.Node<T> left = mergeSort(h, comp);

        // Apply mergeSort on right list
        SimpleLinkedList.Node<T> right = mergeSort(nextofmiddle, comp);

        // Merge the left and right lists
        return sortedMerge(left, right, comp);
    }

    // Utility function to get the middle of the linked list
    private static <T> SimpleLinkedList.Node<T> getMiddle(SimpleLinkedList.Node<T> head) {
        if (head == null)
            return null;

        SimpleLinkedList.Node<T> slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

}


