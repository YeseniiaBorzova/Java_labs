package Lab1.ArrayOfPoints;

import java.util.Arrays;

public class TwoDim extends AbstractArrayOfPoints {
    double[][] points;

    TwoDim(int size){
        points= new double[size][2];
    }

    public void setPoint(int i, double x, double y){
        points[i][0]=x;
        points[i][1]=y;
    }

    public double getX(int i){
        return points[i][0];
    }

    public double getY(int i){
        return points[i][1];
    }
    public int count(){
        return points.length;
    }

    public void addPoint(double x, double y){
        double[][] temp  = new double[points.length][2];
        for(int i =0;i<points.length;i++)
            temp[i]= Arrays.copyOf(points[i],2);
        points = new double[temp.length+1][2];
        for(int i = 0;i<temp.length;i++)
            points[i]=Arrays.copyOf(temp[i],2);
        points[points.length-1][0]=x;
        points[points.length-1][1]=y;
    }

    public void removeLast(){
        points=Arrays.copyOf(points,points.length-1);
    }
}
