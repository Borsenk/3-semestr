package lab1.task1;

import java.util.Arrays;

public class SimpleArrayList<T> implements SimpleList<T> {
    Object[] array;
    int size=0;


    public SimpleArrayList(){
        this(16);
    }

    public SimpleArrayList(int initSize){
        array=new Object[initSize];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    @SuppressWarnings("unchecked")
    public T get(int id) {
        if (id <0 || id>=size()) throw new IndexOutOfBoundsException("Id="+id+" size="+size());
        return (T) array[id];
    }

    @Override
    public T set(int id, T value) {
        T r=get(id);
        array[id]=value;
        return r;
    }

    @Override
    public boolean  add(T value) {
        checkSize();
        array[size++]=value;
        return true;
    }

    @Override
    public T remove(int id) {
        T r=get(id);
        if (id<size-1) {
            System.arraycopy(array, id+1,array,id,size-id );
        }
        size--;
        return r;
    }

    @Override
    public boolean contains(T value) {
        for (int i=0;i<size;i++){
            if (get(i)==value) return true;
        }
        return false;
    }

    private void checkSize() {
        if (size>=array.length){
            int newSize=size+size/2;
            if (newSize<2) newSize=2;
            array=Arrays.copyOf(array,newSize);
        }
    }

    @Override
    public void clear() {
        size=0;
    }

    @Override
    public String toString() {
        StringBuilder sb= new StringBuilder("[");
        for(int i=0;i<size;i++){
            if (i!=0) sb.append(", ");
            sb.append(array[i]);
        }
        sb.append("]");
        return sb.toString();
    }
}

