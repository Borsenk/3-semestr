package lab1.task1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;

class BubbleSortTest {

    @Test
    void sort() {
        int cnt=100;
        var ar1=TestListUtil.initRnd(new SimpleArrayList<>(),0,cnt);
        var ar2=TestListUtil.initRnd(new SimpleLinkedList<>(),0,cnt);
        var arOk=TestListUtil.initRnd(new SimpleLibList<>(),0,cnt);
        Comparator<Integer> c=Comparator.comparingInt(o->o);
        BubbleSort.sort(ar1,c);
        BubbleSort.sort(ar2,c);
        arOk.sort(c);
        TestListUtil.diff(ar1,arOk);
        TestListUtil.diff(ar2,arOk);
    }
}
