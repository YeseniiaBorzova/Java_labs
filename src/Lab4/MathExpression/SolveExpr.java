package Lab4.MathExpression;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineFactory;
import javax.script.ScriptEngineManager;
import java.sql.SQLOutput;
import java.util.Scanner;

public class SolveExpr {
    public static Number f(String function){
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine engine = factory.getEngineByName("JavaScript");

        Object result = null;
        try{
            result = engine.eval(function);
        }catch(Exception ex){
            System.out.println("Not a function");
        }
        System.out.println(function);
        return (Number) result;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter expression to solve: ");
        String func = scanner.nextLine();
        System.out.println(" = "+ f(func));
    }
}
