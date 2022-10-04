package lab1.task2;

public class Triangle extends Polygon {

    public Triangle(Point a, Point b, Point c) {
        super(a,b,c);
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

    public Edge AC(){
        return edges[2];
    }
    public Edge CA(){
        return edges[2];
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

    public boolean isRight(){
        for(double c:corners){
            if (Util.eq(c,Math.PI/2)) return true;
        }
        return false;
    }

    public boolean isIsosceles(){
        return Util.eq(edges[0].length(),edges[1].length())||
                Util.eq(edges[0].length(),edges[2].length())||
                Util.eq(edges[1].length(),edges[2].length());
    }

    public boolean isScalene(){
        for(double c:corners){
            if (c>Math.PI/2) return true;
        }
        return false;
    }

    public boolean isEquilateral(){
        return isRegular();
    }
}
