package Lab1.ArrayOfPoints;

    import java.util.Arrays;
public class OneDim extends AbstractArrayOfPoints{
    double points[];

    OneDim(int size){
        points = new double[size*2];
    }

    public void setPoint(int i, double x, double y){
        points[i*2]=x;
        points[i*2+1]=y;
    }

    public double getX(int i){
        return points[i*2];
    }

    public double getY(int i){
        return points[i*2+1];
    }

    public int count(){
        return  points.length/2;
    }

    public void addPoint(double x, double y) {
       points = Arrays.copyOf(points,points.length+2);
       points[points.length-2]=x;
       points[points.length-1]=y;
    }

    public  void removeLast(){
        points= Arrays.copyOf(points,points.length-2);
    }
}
