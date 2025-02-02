package Lab1.IndTask;

import java.util.Arrays;

public class TramStationArr extends AbsTramStation {

     String name;
     String routes;
     public int[] arrOfRouts = new int[0];
     AbsHour[] hourArr = new AbsHour[0];

     public TramStationArr(){
         this.name="None";
     }

    public TramStationArr(String name, int[] arrOfRouts){
        this.name = name;
        this.arrOfRouts = arrOfRouts;
    }
    public String getName(){return name;}
    public void setName(String name){this.name = name;}
    public int[] getNumbers(){return arrOfRouts;}
    public int getNumber(int i){return arrOfRouts[i];}
    public void setNumbers(int[] arr){ arrOfRouts = arr; }
    public int getHoursNum(){return hourArr.length;}
    public AbsHour getHour( int i){return hourArr[i];}
    public void addHour(AbsHour h){
        hourArr = Arrays.copyOf(hourArr, hourArr.length + 1);
        hourArr[hourArr.length-1] = h;
    }
    public void sortByPas(){
        java.util.Arrays.sort(hourArr, new SortByPassComp());
    }
    public void sortByComments(){
        java.util.Arrays.sort(hourArr, new SortByCommentsComp());
    }
    public int getNumOfLines(){return arrOfRouts.length;}
    public String getRouts(){return routes;}

}
