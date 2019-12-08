package Lab3.Enum;

public class Main {
    public static void main(String[] args) {
        Month m = Month.MAY;
        System.out.println("Selected month "+m.toString());
        System.out.println("Previous month "+m.getPrev().toString());
        System.out.println("Next month "+m.getNext().toString());
        System.out.println("All months ");
        m.printAll();
    }
}
