package Lab2.Archive;

import java.io.*;
import java.util.zip.*;

public class ReadFromZip {
    public static void main(String[] args) {
        try (ZipInputStream zIn = new ZipInputStream(new FileInputStream("src\\Lab2\\Archive\\StudGroup.zip"));
             DataInputStream in = new DataInputStream(zIn)) {
            ZipEntry entry;
            while ((entry = zIn.getNextEntry()) != null) {
                System.out.println("Name: " + entry.getName());
                System.out.println("Age: " + in.readInt());
                System.out.println("Speciality: " + in.readLine());
                System.out.println();
                zIn.closeEntry();
            }
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
