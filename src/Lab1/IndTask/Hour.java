package Lab1.IndTask;

import java.util.Arrays;

public class Hour extends AbsHour {
    int count;
    String[] comments;

    Hour(int count, String[] comments){
        this.count = count;
        Arrays.sort(comments);
        this.comments = comments;
    }

    public int getAmountOfPas(){return count;}
    public void setAmountOfPas(int count){this.count = count;}
    public String[] getComments(){return comments;}
    public int getNumOfComments(){return comments.length;}
    public void addComment(String comment){
        comments = Arrays.copyOf(comments, comments.length + 1);
        comments[comments.length-1] = comment;
    }
}
