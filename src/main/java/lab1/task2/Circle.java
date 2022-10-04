package lab1.task2;

public class Circle implements Figure {
    Point o;
    double r;

    public Circle(Point o, double r) {
        this.o = o;
        this.r = r;
    }

    public Point O() {
        return o;
    }

    public double R() {
        return r;
    }

    @Override
    public double perimeter() {
        return Math.PI*2*r;
    }

    @Override
    public double area() {
        return Math.PI*r*r;
    }
}
