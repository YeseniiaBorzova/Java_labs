package Lab1.Minimum;
import java.util.Scanner;

public class main {
    public static double func(double x){return x*x+x-3;}

    public static void main(String [] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter min: ");
        double from = scan.nextDouble();
        System.out.println("Enter max: ");
        double to = scan.nextDouble();
        System.out.println("Enter step: ");
        double step = scan.nextDouble();
        if(from>to) {
            System.out.println("Wrong input!");
             from = scan.nextDouble();
             to = scan.nextDouble();
        }
        /*Abstract function*/
        MyFuncAbstr abstr = new MyFuncAbstr();
        System.out.println("Abstract: "+abstr.findMin(from,to,step));

        /*Interface*/
        FuncInterface inter = new FuncInterface();
        System.out.println("Interface: "+inter.findMin(from,to,step));

        /*Anonymous class*/
        InterFaceFunc anonclass = new InterFaceFunc() {
            public double func(double x){return x*x+x-3;}

            public double findMin(double from, double to, double step){
                double min = func(from);
                    for (double i =from+step;i<=to;i+=step){
                        double temp = func(i);
                        if(temp<=min)
                            min=temp;
                    }
                    return min;
                }
            };
        System.out.println("Anonymous function: "+anonclass.findMin(from,to,step));

        /*Lambda-expression*/
        System.out.println("Lambda-expression: "+InterFaceFunc2.findMin(from,to,step,x->x*x+x-3));

        /*Reference to function*/
        System.out.println("Reference to function: "+InterFaceFunc2.findMin(from,to,step,main::func));




}
}
