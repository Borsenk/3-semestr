package lab1.task1;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SimpleArrayListTest {

    @Test
    void size() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testSize();
    }

    @Test
    void addGet() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testAddGet();

    }

    @Test
    void set() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testSet();
    }

    @Test
    void remove() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testRemove();
    }

    @Test
    void contains() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testContains();
    }

    @Test
    void exception() {
        TestListUtil lst=new TestListUtil(new SimpleArrayList<>(1));
        lst.testException();
    }
}
