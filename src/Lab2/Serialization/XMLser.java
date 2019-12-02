package Lab2.Serialization;

import java.beans.XMLEncoder;
import Lab2.Archive.*;
import java.io.*;

public class XMLser {
    public static void main(String[] args) {
        StudGroup gr = new StudGroup();
        gr.addStud(new Student("Jane Kelly", 21,"Designer"));
        gr.addStud(new Student("Nick Jonson", 19,"Programmer"));
        gr.addStud(new Student("George Miller", 22,"Team lead"));
        gr.addStud(new Student("Shon Kane",18,"Network engeneer"));
        for(int i =0;i<gr.getLength();i++){
            System.out.println(gr.getStud(i).toString());
        }
        try (XMLEncoder xmlEncoder = new XMLEncoder(new FileOutputStream("src\\Lab2\\Serialization\\StudGroup.xml"))) {
            xmlEncoder.writeObject(gr);
            xmlEncoder.flush();
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
