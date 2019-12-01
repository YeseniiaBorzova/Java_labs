package Lab1.Comparator;

import java.util.Comparator;

public class Triangle {
    int a,b,c;

    Triangle(int a, int b, int c){
        this.a=a;
        this.b=b;
        this.c=c;
    }

    public double getArea(){
        return 0.25*Math.sqrt((a+b+c)*(b+c-a)*(a+c-b)*(a+b-c));
    }
     @Override
    public  String toString(){
        return "Area: "+getArea();
     }
}
