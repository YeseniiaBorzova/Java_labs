package Lab1.Comparator;

import java.util.Comparator;

public class SortTriangles {
    public static void main(String[] args){
        Triangle[] a = {new Triangle(3,4,5), new Triangle(6,6,6), new Triangle(2,7,5)};
        java.util.Arrays.sort(a, new CompByArea());
        System.out.println(java.util.Arrays.toString(a));
    }
}
