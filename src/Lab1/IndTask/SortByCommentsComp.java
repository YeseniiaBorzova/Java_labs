package Lab1.IndTask;

import java.util.Comparator;

public class SortByCommentsComp implements Comparator<AbsHour> {
    @Override
    public int compare(AbsHour h1, AbsHour h2) {
        return h1.getComments()[0].compareTo(h2.getComments()[0]);
    }
}
