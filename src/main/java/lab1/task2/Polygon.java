package lab1.task2;

public class Polygon implements Figure{
    protected final Point[] vertex;
    protected final Edge[] edges;
    protected final double[] corners;

    public Polygon(Point ...p)  {
        if (p.length<3) throw new RuntimeException("Count vertex < 3");
        vertex =p;
        edges=new Edge[p.length];
        for(int i=0;i<p.length;i++){
            edges[i]=new Edge(p[i],p[id(i+1)]);
        }
        corners= new double[p.length];
        for(int i=0;i<p.length;i++){
            corners[i]=Util.corner(p[i],p[id(i+1)],p[id(i-1)]);
        }
    }

    public int id(int id){
        int size=vertex.length;
        return (id+size)%size;
    }

    public int count(){
        return vertex.length;
    }

    public Point[] getVertex() {
        return vertex;
    }

    public Edge[] getEdges() {
        return edges;
    }

    public double[] getCorners() {
        return corners;
    }

    public boolean isRegular(){
        for(int i=0;i<edges.length;i++){
            Edge e1=edges[i];
            Edge e2=edges[id(i+1)];
            if (!Util.eq(e1.length(),e2.length())) return false;
        }
        for(int i=0;i<corners.length;i++){
            double e1=corners[i];
            double e2=corners[id(i+1)];
            if (!Util.eq(e1,e2)) return false;
        }
        return true;
    }

    @Override
    public double perimeter() {
        double per=0;
        for(Edge e:edges){
            per+=e.length();
        }
        return per;
    }

    protected double area(Point a,Point b,Point c){
        var tr=new Triangle(a,b,c);
        return 0.5*tr.AB().length()*tr.AC().length()*Math.sin(tr.cornerA());
    }

    @Override
    public double area() {
        // для выпуклых TODO если нет
        double area=0;
        for (int id=1;id<vertex.length-1;id++){
            area+=area(vertex[0],vertex[id],vertex[id+1]);
        }
        return area;
    }

    public boolean isConvex(){
        int flag=0;
        for (int id=0;id<vertex.length;id++){
            Point p1=vertex[id];
            Point p2=vertex[id(id+1)];
            Point p3=vertex[id(id+2)];

            double z = (p2.x-p1.x)*(p3.y-p2.y)-(p2.y-p1.y)*(p3.x-p2.x);

            if (z < 0)
                flag |= 1;
            else if (z > 0)
                flag |= 2;
            if (flag == 3)
                return false;

        }
        return true;
    }

}
