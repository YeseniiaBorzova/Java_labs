package Lab3.DiffWords;

import java.util.*;

public class DiffWords {
    Set<String> sentence = new TreeSet<>();

    DiffWords(String s){strToset(s);}

    public void strToset(String str){
        StringTokenizer st = new StringTokenizer(str);
        while(st.hasMoreTokens()){
            sentence.add(st.nextToken());
        }
    }

    public Set getSet(){return sentence;}

    public static void main(String[] args) {
        DiffWords sentence = new DiffWords("I am Yasya Yasya loves sguschenka sguschenka is very good");
        System.out.println(sentence.getSet());
    }

}
