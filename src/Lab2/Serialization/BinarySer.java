package Lab2.Serialization;
import Lab2.Archive.*;
import  java.io.*;


public class BinarySer {
    public static void main(String[] args) {
        StudGroup gr = new StudGroup();
        gr.addStud(new Student("Jane Kelly", 21,"Designer"));
        gr.addStud(new Student("Nick Jonson", 19,"Programmer"));
        gr.addStud(new Student("George Miller", 22,"Team lead"));
        gr.addStud(new Student("Shon Kane",18,"Network engeneer"));
        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream("src\\Lab2\\Serialization\\Stud.dat"))) {
            out.writeObject(gr);
        }
        catch (IOException e) {
            e.printStackTrace();
        };
    }
}
