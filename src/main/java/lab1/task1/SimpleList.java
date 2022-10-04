package lab1.task1;



public interface SimpleList<T>  {
    int size();
    T get(int id);
    T set(int id,T value);
    boolean add(T value);
    T remove(int index);
    boolean contains(T value);
    void clear();
}
