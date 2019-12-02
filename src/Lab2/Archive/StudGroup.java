package Lab2.Archive;

import java.io.Serializable;
import java.util.Arrays;

public class StudGroup implements Serializable {

    private static final long serialVersionUID = -2916005428046978389L;
    Student[] arr;

    public StudGroup(){arr = new Student[0];}

    public void addStud(Student s){
        arr = Arrays.copyOf(arr,arr.length+1);
        arr[arr.length-1] = s;
    }

    public int getLength(){return arr.length;}
    public Student getStud(int i){return arr[i];}
    public Student[] getStuds(){return arr;}
    public void setStuds(Student[] st){arr = st;}

}
