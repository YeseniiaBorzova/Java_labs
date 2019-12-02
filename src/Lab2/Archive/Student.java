package Lab2.Archive;

import java.io.Serializable;

public class Student implements Serializable {

    private static final long serialVersionUID = 3609947432545113999L;
    private String name;
    private int age;
    private String speciality;
    public Student(String name, int age, String speciality){
        this.name= name;
        this.age = age;
        this.speciality = speciality;

    }
    public Student(){
        name = "";
        age=0;
        speciality="";
    }

    public int getAge() { return age; }

    public String getName() { return name; }

    public String getSpeciality() { return speciality; }

    public void setAge(int age) { this.age = age; }

    public void setName(String name) { this.name = name; }

    public void setSpeciality(String speciality) { this.speciality = speciality; }

    @Override
    public String toString() { return name+", "+age+", "+speciality+";"; }
}
