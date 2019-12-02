package Lab1.IndTask;

import java.util.Arrays;

public abstract class AbsTramStation {
    public abstract String getName();
    public abstract void setName(String name);
    public abstract  int[] getNumbers();
    public abstract  int getNumber(int i);
    public abstract  void setNumbers(int[] arr);
    public abstract int getHoursNum();
    public abstract AbsHour getHour(int i);
    public abstract void addHour(AbsHour h);
    public abstract void sortByPas();
    public abstract void sortByComments();
    public abstract int getNumOfLines();

    public void checkAndAddHour(AbsHour h){
        for (int i = 0; i < getHoursNum(); i++) {
            if (getHour(i).equals(h)) {
                System.out.println("Records are equal!\n");
                return;
            }
        }
        addHour(h);
    }

    @Override
    public String toString(){
        String str = getName() + '\n';
        for(int i = 0; i < getNumOfLines();i++) {
            str += getNumber(i);
            str += ' ';
        }
        str += '\n';
        for(int i = 0; i < getHoursNum(); i++){
            str += getHour(i).toString();
        }
        return str;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AbsTramStation)) {
            return false;
        }
        AbsTramStation h = (AbsTramStation) obj;
        return getName() == h.getName();
    }

    public AbsHour[] searchByPassNum(int n){
        AbsHour[] res = new AbsHour[0];
        for(int i = 0; i < getHoursNum(); i++){
            if(getHour(i).getAmountOfPas() == n){
                res = Arrays.copyOf(res, res.length + 1);
                res[res.length - 1] = getHour(i);
            }
        }
        return res;
    }

    public void test(){
        //filling object
        String[] comms1 = {"Good","Bad","Perfect"};
        addHour(new Hour(8, comms1));
        String[] comms2 = {"Good", "Awful","Perfect"};
        addHour(new Hour(8, comms2));
        String[] comms3 = {"Good","Good", "Good","Perfect"};
        addHour(new Hour(14, comms3));
        String[] comms4 = {"Excellent","Nice","Terrible","Very Well"};
        //sorting array
        System.out.println(toString());
        sortByPas();
        System.out.println("Sorted by passengers: \n" + toString() + "\n__________________________");
        sortByComments();
        System.out.println("Sorted by comments: " + toString() + "\n__________________________");
        //addition
        Hour h =  new Hour(26,comms4);
        checkAndAddHour(h);
        System.out.println("Add new hour:\n " + toString() + "\n__________________________");
        System.out.println("Add existed hour: \n");
        checkAndAddHour(new Hour(8, comms1));
        System.out.println(toString() + "\n__________________________");
        //searching
        System.out.println("Hours with number of passengers equals 8:\n");
        AbsHour[] res = searchByPassNum(8);
        for(int i = 0;i<res.length;i++){
            System.out.println(res[i].toString()+" ");
        }

    }
}
