package lab1.task1;

import java.util.ArrayList;

public class SimpleLibList<T>  extends ArrayList<T> implements SimpleList<T> {
    public SimpleLibList() {
        this(16);
    }
    public SimpleLibList(int initSize) {
        super(initSize);
    }
}
