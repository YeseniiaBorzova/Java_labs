package Lab1.IndTask;

import java.util.Comparator;

public class SortByPassComp implements Comparator<AbsHour> {
    @Override
    public int compare(AbsHour h1, AbsHour h2){
        return h1.getAmountOfPas() - h2.getAmountOfPas();
    }
}
