package lab1.task2;

public class Quadrilateral extends Polygon {

    public Quadrilateral(Point a, Point b, Point c, Point d) {
        super(a,b,c,d);
    }

    public Point A() {
        return vertex[0];
    }

    public Point B() {
        return vertex[1];
    }

    public Point C() {
        return vertex[2];
    }

    public Point D() {
        return vertex[3];
    }

    public Edge AB(){
        return edges[0];
    }
    public Edge BA(){
        return edges[0];
    }

    public Edge BC(){
        return edges[1];
    }
    public Edge CB(){
        return edges[1];
    }

    public Edge CD(){
        return edges[2];
    }
    public Edge DC(){
        return edges[2];
    }

    public Edge AD(){
        return edges[3];
    }
    public Edge DA(){
        return edges[3];
    }


    public double cornerA(){
        return corners[0];
    }

    public double cornerB(){
        return corners[1];
    }

    public double cornerC(){
        return corners[2];
    }

    public double cornerD(){
        return corners[3];
    }

    // ромб
    public boolean isRhombus(){
        return Util.eq(AB().length(),BC().length()) &&
                Util.eq(AB().length(),CD().length()) &&
                Util.eq(AB().length(),AD().length());
    }
    // квадрат
    public boolean isSquare(){
        return isRhombus()&& Util.eq(cornerA(),Math.PI/2);
    }
    // паралелограмм
    public boolean isParallelogram(){
        return Util.eq(cornerA(),cornerC()) && Util.eq(cornerB(),cornerD());
    }
    // прямоугольник
    public boolean isRectangle(){
        return isParallelogram() && Util.eq(cornerA(),Math.PI/2);
    }
    // трапеция
    public boolean isTrapezoid(){
        return Util.eq(cornerA()+cornerB(),Math.PI) || Util.eq(cornerA()+cornerC(),Math.PI);
    }

    public boolean isKite(){
        return Util.eq(AB().length(),BC().length()) &&
                Util.eq(AD().length(),CD().length()) ||
                Util.eq(AB().length(),AD().length()) &&
                Util.eq(BC().length(),CD().length()) ;
    }

}
