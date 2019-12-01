package Lab1.IndTask;

public class Main {
    public static void main(String[] args) {
        int[] rout1 = {4,67,12,9,10};
        int[] rout2 = {7,47,123,5,3};
        int[] rout3 = {8,687,14,7,23};
        int[] rout4 = {73,29,91,33,17};
        TramStationArr tram1 = new TramStationArr("Armiyska",rout1);
        tram1.test();
        System.out.println(tram1.toString());
        TramStationArr tram2 = new TramStationArr("Pushkinskaya",rout2);
        TramStationArr tram3 = new TramStationArr("Pushkinskaya",rout2);
        System.out.println(tram2.equals(tram1));
        String[] comms = {"Super","Nice","Adorable"};
        tram3.addHour(new Hour(67,comms));
        TramStationList tram4 = new TramStationList("Universitet",rout3);
        TramStationList tram5 = new TramStationList("Derzhprom",rout4);
        tram4.test();
        System.out.println(tram4.equals(tram5));
    }
}
