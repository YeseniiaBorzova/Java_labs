package Lab2.IndTask;
import javax.xml.bind.*;
import Lab2.IndTask.JAXBScheme.*;
import Lab1.IndTask.*;
import Lab2.IndTask.JAXBScheme.TramStation;

import java.beans.XMLDecoder;
import java.io.*;

public class XMLTram extends TramStationArr implements FileWorkInterface{
    TramStation tram = new TramStation();
    JAXBContext jaxbContext;

    public XMLTram(){
        tram.setName(" ");
        tram.setArrOfRoutes(" ");
    }
    public XMLTram( String Name, String ArrOfRoutes){
        tram.setName(Name);
        tram.setArrOfRoutes(ArrOfRoutes);
    }

    public TramStation getTram(){return tram;}
    @Override
    public void fileRead(String filename) {
        try{
            jaxbContext = JAXBContext.newInstance("Lab2.IndTask.JAXBScheme");
            Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
            tram = (TramStation)unmarshaller.unmarshal(new FileInputStream(filename));
            setName(tram.getName());
            for(int i = 0;i<tram.getHour().size();i++){
                TramStation.Hour jaxbRec = tram.getHour().get(i);
                String[] comments = new String[1];
                comments[0] = jaxbRec.getComments();
                Hour hour = new Hour(jaxbRec.getCount(),comments);
                addHour(hour);
            }
        }catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }

    public void fileWrite(String filename){
        try{
            Marshaller marshaller = jaxbContext.createMarshaller();
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.marshal(tram,new FileWriter(filename));
        }catch(JAXBException | IOException e){
            e.printStackTrace();
        }
    }

    public void sortByCount(){
        java.util.Collections.sort(tram.getHour(), new SortByPass());
    }
    public void sortByComment(){java.util.Collections.sort(tram.getHour(), new SprtByComments());}

    public static void main(String[] args) {
        XMLTram xmltram = new XMLTram();
        xmltram.fileRead("src\\Lab2\\IndTask\\Tram.xml");
        //xmltram.tram.setName("Peremoha");
        System.out.println(xmltram.tram.getArrOfRoutes());
        xmltram.tram.setArrOfRoutes(" 24 56 78 91 2");
        xmltram.tram.getArrOfRoutes();
        xmltram.tram.getHour().get(0).setCount(45);
        xmltram.tram.getHour().get(1).setCount(90);
        xmltram.tram.getHour().get(2).setCount(3);
        xmltram.tram.getHour().get(0).setComments("YA LYBLY SASHUU");
        xmltram.tram.getHour().get(1).setComments("YA LYBLY MOLOKO");
        xmltram.tram.getHour().get(2).setComments("YA LYBLY SGUSCHENKU");
        xmltram.fileWrite("src\\Lab2\\IndTask\\JAXBTram.xml");
    }
}
