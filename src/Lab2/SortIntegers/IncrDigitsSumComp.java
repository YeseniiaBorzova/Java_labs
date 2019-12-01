package Lab2.SortIntegers;

import java.util.Comparator;

public class IncrDigitsSumComp implements Comparator<Integer> {
    @Override
    public int compare(Integer i1, Integer i2){
        int s1 = 0;
        while(i1!=0){
            s1+=(i1%10);
            i1/=10;
        }
        int s2 = 0;
        while(i2!=0){
            s2+=(i2%10);
            i2/=10;
        }
        return Integer.compare(s1,s2);
    }
}
