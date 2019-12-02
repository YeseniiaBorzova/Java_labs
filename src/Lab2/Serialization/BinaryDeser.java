package Lab2.Serialization;
import Lab2.Archive.*;
import java.io.*;

public class BinaryDeser {
    public static void main(String[] args) throws ClassNotFoundException {
        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream("src\\Lab2\\Serialization\\Stud.dat"))) {
            StudGroup gr = (StudGroup) in.readObject();
            for (int i = 0; i < gr.getLength(); i++) {
                System.out.println(gr.getStud(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

