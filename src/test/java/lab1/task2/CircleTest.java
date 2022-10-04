package lab1.task2;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CircleTest {
    Circle c= new Circle(new Point(0,0),5);

    @Test
    void perimeter() {
        assertTrue(Util.eq(c.perimeter(),10*Math.PI));
    }

    @Test
    void area() {
        assertTrue(Util.eq(c.area(),25*Math.PI));
    }
}