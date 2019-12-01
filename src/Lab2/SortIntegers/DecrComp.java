package Lab2.SortIntegers;

import java.util.Comparator;

public class DecrComp implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2){ return Integer.compare(i2,i1); }
}
