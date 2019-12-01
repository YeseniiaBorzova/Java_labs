package Lab1.Comparable;

        import java.util.Arrays;
public class SortCircles{

    public static void main(String[] args){
        Circle[] a = { new Circle(1.2), new Circle(2.9), new Circle(5.6), new Circle(4.3)};
        Arrays.sort(a);
        System.out.println(java.util.Arrays.toString(a));
    }
}