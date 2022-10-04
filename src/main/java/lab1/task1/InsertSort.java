package lab1.task1;

import java.util.Comparator;

public class InsertSort {
    public static <T> void sort(SimpleList<T> array, Comparator<T> comp) {
        for (int left = 0; left < array.size(); left++) {
            T key = array.get(left);
            int i = left - 1;
            for (; i >= 0; i--) {
                if (comp.compare(key, array.get(i)) < 0) {
                    array.set(i + 1, array.get(i));
                } else {
                    break;
                }
            }
            array.set(i + 1, key);
        }
    }
}