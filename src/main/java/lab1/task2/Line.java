package lab1.task2;
//  y =ax+b
public class Line implements Figure{
    double a,b;

    public Line(double a, double b) {
        this.a = a;
        this.b = b;
    }

    public Line(Point p1,Point p2){
        // TODO
    }

    public double getA() {
        return a;
    }

    public double getB() {
        return b;
    }

    public double y(double x){
        return a*x+b;
    }

    @Override
    public double perimeter() {
        return 0;
    }

    @Override
    public double area() {
        return 0;
    }
}
