package Lab2.Archive;

import java.io.*;
import java.util.zip.*;

public class StoreToZip {
    public static void main(String[] args) {
        StudGroup gr = new StudGroup();
        gr.addStud(new Student("Jane Kelly", 21,"Designer"));
        gr.addStud(new Student("Nick Jonson", 19,"Programmer"));
        gr.addStud(new Student("George Miller", 22,"Team lead"));
        gr.addStud(new Student("Shon Kane",18,"Network engeneer"));
        for (int i =0;i<gr.getLength();i++){
            System.out.println(gr.getStud(i));
        }
        try (ZipOutputStream zOut = new ZipOutputStream(new FileOutputStream("src\\Lab2\\Archive\\StudGroup.zip"));
             DataOutputStream out = new DataOutputStream(zOut)) {
            for (Student stud : gr.getStuds()) {
                ZipEntry zipEntry = new ZipEntry(stud.getName());
                zOut.putNextEntry(zipEntry);
                out.writeInt(stud.getAge());
                out.writeChars(stud.getSpeciality());
                zOut.closeEntry();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
