package Lab4.IndTask;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;

public class MetaProg {
    public static double f(String function, double x){
        ScriptEngineManager factory = new ScriptEngineManager();
        ScriptEngine scriptEngine = factory.getEngineByName("JavaScript");
        scriptEngine.put("x",x);
        Object result = null;
        try{
            result = scriptEngine.eval(function+";");
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return (double) result;
    }
}
