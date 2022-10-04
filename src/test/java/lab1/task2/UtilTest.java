package lab1.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class UtilTest {

    @Test
    void length() {
        double r=Util.length(new Point(1,1),new Point(2,2));
        assertEquals(r,1.4142135623730951);
        r=Util.length(new Point(1,1),new Point(4,5));
        assertEquals(r,5);
    }

    @Test
    void corner() {
        double r=Util.corner(new Point(1,1),new Point(1,2),new Point(2,1));
        assertTrue(Util.eq(r, Math.PI / 2));
        r=Util.corner(new Point(1,1),new Point(0,0),new Point(2,2));
        assertTrue(Util.eq(r, Math.PI));
    }

    @Test
    void intersection() {
    }
}