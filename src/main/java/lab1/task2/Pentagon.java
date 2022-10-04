package lab1.task2;

public class Pentagon extends Polygon{

    public Pentagon(Point a, Point b, Point c, Point d, Point e) {
        super(a,b,c,d,e);
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

    public Point E() {
        return vertex[4];
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

    public Edge DE(){
        return edges[3];
    }
    public Edge ED(){
        return edges[3];
    }

    public Edge AE(){
        return edges[4];
    }
    public Edge EA(){
        return edges[4];
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

    public double cornerE(){
        return corners[4];
    }


}
