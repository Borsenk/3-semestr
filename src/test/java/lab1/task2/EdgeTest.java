package lab1.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EdgeTest {

    @Test
    void length() {
        Edge e=new Edge(new Point(1,1),new Point(2,2));
        assertEquals(e.length(),1.4142135623730951);
        e=new Edge(new Point(1,1),new Point(4,5));
        assertEquals(e.length(),5);

    }
}