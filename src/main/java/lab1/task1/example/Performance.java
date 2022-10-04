package lab1.task1.example;

import lab1.task1.*;

import java.time.Duration;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Random;



public class Performance {
    interface Func<T> {
        void sort(SimpleList<T> l, Comparator<T> c);
    }
    Map<String,Func<Integer>> sortFunc= new LinkedHashMap<>();

    Performance(){
        sortFunc.put("InsertSort",InsertSort::sort);
        sortFunc.put("MergeSort",MergeSort::sort);
        sortFunc.put("QuickSort",QuickSort::sort);
        sortFunc.put("RadixSort",RadixSort::sort);
        sortFunc.put("BubbleSort",BubbleSort::sort);
    }

    public static void main(String[] args) {
        Performance m=new Performance();
        m.testPerf();
    }

    private static <T extends SimpleList<Integer>> T initRandom(T lst,int size) {
        Random rnd=new Random(0);
        for(int i=0;i<size;i++){
            lst.add(rnd.nextInt(100));
        }
        return lst;
    }

    private void testPerf() {
        int cnt=1000;
        System.out.println("          \tArrayList    \tLinkedList");
        for (String name:sortFunc.keySet()){
            System.out.print(name);
            var array=initRandom(new SimpleArrayList<>(),cnt);
            var list=initRandom(new SimpleLinkedList<>(),cnt);
            long timeArray=doSort(sortFunc.get(name),array);
            long timeList=doSort(sortFunc.get(name),list);
            System.out.print("\t"+Duration.ofNanos(timeArray));
            System.out.print("\t"+Duration.ofNanos(timeList));
            System.out.println();
        }
    }

    private long doSort(Func<Integer> sort, SimpleList<Integer> list) {
        long start=System.nanoTime();
        sort.sort(list,Comparator.comparingInt(o->o));
        return System.nanoTime()-start;
    }

}
