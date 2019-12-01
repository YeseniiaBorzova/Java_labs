package Lab1.IndTask;

public abstract class AbsHour{
    public abstract int getAmountOfPas();
    public abstract void setAmountOfPas(int amount);
    public abstract String[] getComments();
    public abstract int getNumOfComments();
    public abstract void addComment(String comment);

    @Override
    public String toString(){
        String str = getAmountOfPas() + " passengers;\n Comments:\n";
        for(int i = 0; i < getNumOfComments(); i++){
            str += getComments()[i] + '\n';
        }
        return str;
    }
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof AbsHour)) {
            return false;
        }
        AbsHour h = (AbsHour) obj;
        if(getAmountOfPas() != h.getAmountOfPas()){return false;}
        if(getNumOfComments() != h.getNumOfComments()){return false;}
        for(int i = 0; i < getNumOfComments(); i++){
            if(getComments()[i]!= h.getComments()[i]){return false;}
        }
        return true;
    }
}
