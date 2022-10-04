package lab1.task1;


import java.util.Comparator;

public class BubbleSort {

    public static <T> void sort(SimpleList<T> array, Comparator<T> comp) {
        boolean isSorted = false;
        T temp;
        while (!isSorted) {
            isSorted = true;
            for (int i = 0; i < array.size() - 1; i++) {
                if (comp.compare(array.get(i) , array.get(i + 1)) >0) {
                    temp = array.get(i);
                    array.set(i,array.get(i + 1));
                    array.set(i + 1,temp);
                    isSorted = false;
                }
            }
        }
    }
}