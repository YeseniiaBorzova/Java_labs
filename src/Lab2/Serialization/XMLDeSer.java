package Lab2.Serialization;

import java.beans.XMLDecoder;
import java.io.*;
import Lab2.Archive.*;

public class XMLDeSer {
    public static void main(String[] args) {
        try (XMLDecoder xmlDecoder = new XMLDecoder(new FileInputStream("src\\Lab2\\Serialization\\StudGroup.xml"))) {
            StudGroup gr = (StudGroup) xmlDecoder.readObject();
            for (int i = 0; i < gr.getLength(); i++) {
                System.out.println(gr.getStud(i));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

