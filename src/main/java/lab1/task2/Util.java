package lab1.task2;

public class Util {
    public static final double EPS=0.00000000000001;

    public static double length(Point a, Point b){
        return Math.sqrt((a.x- b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
    }
    public static double corner(Point vertex,Point a,Point c){
        var ab=length(a,vertex);
        var ac=length(a,c);
        var bc=length(vertex,c);

        return Math.acos((ab*ab+bc*bc-ac*ac)/(2*ab*bc));
    }

    public static Point intersection(Edge e1,Edge e2){
        // TODO
        return null;
    }

    public static boolean eq(double e1, double e2) {
        return Math.abs(e1-e2)<EPS;
    }
}
