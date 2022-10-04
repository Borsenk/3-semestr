package lab1.task1;

import java.util.Comparator;

public class QuickSort {
    public static  <T> void sort(SimpleList<T> array, Comparator<T> comp) {
        sort(array, 0, array.size() - 1, comp);
    }

    private static <T> void sort(SimpleList<T> array, int low, int high, Comparator<T> comp) {
        if (low >= high) return;
        T pivot = array.get(low + (high - low) / 2);

        int i = low, j = high;
        while (i <= j) {
            while (comp.compare(array.get(i), pivot) < 0) {
                i++;
            }
            while (comp.compare(array.get(j), pivot) > 0) {
                j--;
            }

            if (i <= j) {
                T temp = array.get(i);
                array.set(i, array.get(j));
                array.set(j, temp);
                i++;
                j--;
            }
        }

        if (low < j) sort(array, low, j, comp);
        if (high > i) sort(array, i, high, comp);
    }

}
