package Lab1.Minimum;

public class Function {
    public static double func(double x){return x*x+x-3;}
    static double findMin(double from, double to, double step){
        double min = func(from);
        for (double i =from+step;i<=to;i+=step){
            double temp = func(i);
            if(temp<=min)
                min=temp;
        }
        return min;
    }
}