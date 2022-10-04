package lab1.task1;

import org.junit.jupiter.api.Test;

import java.util.Comparator;


class MergeSortTest {

    @Test
    void sort() {
        int cnt=1000;
        var ar1=TestListUtil.initRnd(new SimpleArrayList<>(),0,cnt);
        var ar2=TestListUtil.initRnd(new SimpleLinkedList<>(),0,cnt);
        var arOk=TestListUtil.initRnd(new SimpleLibList<>(),0,cnt);
        Comparator<Integer> c=Comparator.comparingInt(o->o);
        MergeSort.sort(ar1,c);
        MergeSort.sort(ar2,c);
        arOk.sort(c);
        TestListUtil.diff(ar1,arOk);
        TestListUtil.diff(ar2,arOk);
    }

}