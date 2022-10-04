package lab1.task2;

public class Edge implements Figure{
    private final Point a,b;

    public Edge(Point a, Point b) {
        this.a = a;
        this.b = b;
    }

    public Point A() {
        return a;
    }

    public Point B() {
        return b;
    }

    //длина отрезка
    public double length(){
        return Util.length(a,b);
    }

    @Override
    public double perimeter() {
        return length();
    }

    @Override
    public double area() {
        return 0;
    }
}
