package Lab3.UserData;

import java.util.*;

public class UserData {

    Map<String, String>  data = new TreeMap<>();

    public void addUser(String name, String password){data.put(name,password);}

    public Map<String,String> getData(){return data;}

    public static void main(String[] args) {
        UserData data = new UserData();
        data.addUser("Yasenka","288Parol288");
        data.addUser("Penitraitor2000","12345qwe");
        data.addUser("KRACAB4UK_420","qwerty");
        data.addUser("ILikeSguschenka","Qhuei56");
        data.addUser("SpelaYa_Sosisochka","123");
        Map<String,String> m = data.getData();
        for(Map.Entry<String,String> entry : m.entrySet()){
            if( entry.getValue().length()>6){
                System.out.println(entry.getKey()+" "+entry.getValue());
            }
        }
    }
}
