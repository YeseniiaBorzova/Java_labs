package Lab1.Minimum;

abstract class AbstrFunc {

    abstract double func(double x);

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
