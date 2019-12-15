package Lab4.CallFuncForClass;

import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) {
        try{
            Method method = Class.forName("Lab4.CallFuncForClass.ClassThree").getMethod("print");
            method.invoke(null);
        }catch(Exception ex){
            System.out.println("Error");
        }
    }
}
