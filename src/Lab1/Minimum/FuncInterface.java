package Lab1.Minimum;

public class FuncInterface implements InterFaceFunc {
    public double func(double x){ return x*x+x-3; }

    public double findMin(double from, double to, double step){
        double min = func(from);
        for (double i =from+step;i<=to;i+=step){
            double temp = func(i);
            if(temp<=min)
                min=temp;
        }
        return min;
    }
}
