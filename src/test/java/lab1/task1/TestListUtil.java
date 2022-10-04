package lab1.task1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.junit.jupiter.api.Assertions.*;

public class TestListUtil {
    private final SimpleList<Integer> lst;
    TestListUtil(SimpleList<Integer> lst ){
        this.lst=lst;
    }

    public static <T extends SimpleList<Integer>> T initRnd(T lst,int sid,int size) {
        Random rnd=new Random(sid);
        for(int i=0;i<size;i++){
          lst.add(rnd.nextInt(10));
        }
        return lst;
    }

    public void testSize() {
        for(int i=1;i<30;i++){
            lst.add(i);
            assertEquals(lst.size(),i);
        }
    }


    public void testSet() {
        testAddGet();
        for(int i=0;i<30;i++){
            lst.set(i,i+11);
            assertEquals(lst.get(i),i+11);
        }
    }

    public void testAddGet() {
        for(int i=0;i<30;i++){
            lst.add(i);
            assertEquals(lst.get(i),i);
        }
    }

    public void testRemove() {
        testAddGet();
        List<Integer> ar= new ArrayList<>();
        for(int i=0;i<30;i++) {
            ar.add(i);
        }
        int r1,r2;
        r1=lst.remove(0);
        r2=ar.remove(0);
        assertEquals(r1,r2);

        r1=lst.remove(lst.size()-1);
        r2=ar.remove(ar.size()-1);
        assertEquals(r1,r2);

        r1=lst.remove(5);
        r2=ar.remove(5);
        assertEquals(r1,r2);

        diff(lst,ar);


    }

    static void diff(SimpleList<Integer> lst, List<Integer> ar) {
        assertEquals(lst.size(),ar.size());
        for(int i=0;i<lst.size();i++){
            assertEquals(lst.get(i),ar.get(i));
        }
    }

    public void testContains() {
        testAddGet();
        for(int i=0;i<30;i++){
            assertTrue(lst.contains(i));
        }
        assertFalse(lst.contains(30));
    }

    public void testException() {
        int cnt=0;
        try {
            lst.get(-1);
        } catch (IndexOutOfBoundsException e){
            cnt++;
        }
        assertEquals(cnt,1);
        try {
            lst.get(1);
        } catch (IndexOutOfBoundsException e){
            cnt++;
        }
        assertEquals(cnt,2);
    }
}
