package Lab2.IndTask;

import Lab1.IndTask.*;
import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.*;
import java.util.*;

public class TextTramStation extends TramStationArr implements FileWorkInterface {

    TextTramStation(String name, int[] arrOfRoutes) {
        super(name, arrOfRoutes);
    }

    TextTramStation() {
        super();
    }

    @Override
    public void fileRead(String filename) {
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            try{
                StringTokenizer st = new StringTokenizer(s);
                setName(st.nextToken());
                s = br.readLine();
                st = new StringTokenizer(s);
                while(st.hasMoreTokens()){
                    try{
                        int temp  = Integer.parseInt(st.nextToken());
                        arrOfRouts = Arrays.copyOf(arrOfRouts, arrOfRouts.length+1);
                        arrOfRouts[arrOfRouts.length-1] = temp;
                    }
                    catch(NumberFormatException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }finally {
                br.close();
            }

        }catch( IOException ex){
            ex.printStackTrace();
        }
    }

    @Override
    public void fileWrite(String filename) {
        try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            pw.println(this.toString());
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        TextTramStation doc = new TextTramStation();
        doc.fileRead("src\\Lab2\\IndTask\\Input.txt");
        doc.fileWrite("src\\Lab2\\IndTask\\Output.txt");
    }
}

