package Lab4.ClassFields;
import java.lang.reflect.Field;
import java.util.Scanner;

public class ClassFields {
    public static void main(String[] args) {
        try{
            System.out.println("Enter path to field: ");
            Class<?> c = Class.forName(new Scanner(System.in).nextLine());
            Field [] fields = c.getDeclaredFields();
            for(Field field : fields){
                System.out.println(field);
            }
        }catch(ClassNotFoundException ex){
            System.out.println("Class not found!");
        }
    }
}
