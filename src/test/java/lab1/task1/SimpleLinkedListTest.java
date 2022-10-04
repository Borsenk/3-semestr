package lab1.task1;

import org.junit.jupiter.api.Test;


class SimpleLinkedListTest {
    @Test
    void size() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testSize();
    }

    @Test
    void addGet() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testAddGet();

    }

    @Test
    void set() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testSet();
    }

    @Test
    void remove() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testRemove();
    }

    @Test
    void contains() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testContains();
    }

    @Test
    void exception() {
        TestListUtil lst=new TestListUtil(new SimpleLinkedList<>());
        lst.testException();
    }


}