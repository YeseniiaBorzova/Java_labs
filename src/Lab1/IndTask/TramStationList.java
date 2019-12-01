package Lab1.IndTask;

import java.util.*;

public class TramStationList extends AbsTramStation {
    String name;
    int[] arrOfRouts;
    List<AbsHour> hourList = new ArrayList<AbsHour>();

    TramStationList(String name, int[] arrOfRouts){
        this.name = name;
        this.arrOfRouts=arrOfRouts;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int[] getNumbers(){return arrOfRouts;}
    public int getNumber(int i){return arrOfRouts[i];}
    public void setNumbers(int[] arr){ arrOfRouts = arr; }
    public int getHoursNum(){return hourList.size();}
    public AbsHour getHour( int i ){return hourList.get(i);}
    public void addHour(AbsHour h){
        hourList.add(h);
    }
    public void sortByPas(){
        Collections.sort(hourList, new SortByPassComp());
    }
    public void sortByComments(){
        Collections.sort(hourList, new SortByCommentsComp());
    }
    public int getNumOfLines(){return arrOfRouts.length;}
}
