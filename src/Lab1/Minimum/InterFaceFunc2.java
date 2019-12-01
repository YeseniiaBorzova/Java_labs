package Lab1.Minimum;

public interface InterFaceFunc2 {
    double func(double x);
    static double findMin(double from, double to, double step, InterFaceFunc2 f){
        double min = f.func(from);
        for (double i =from+step;i<=to;i+=step){
            double temp = f.func(i);
            if(temp<=min)
                min=temp;
        }
        return min;
    }
}
