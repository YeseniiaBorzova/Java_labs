package Lab1.IndTask;

import java.util.Arrays;

public class Hour extends AbsHour {
   public int count;
   public String[] comments;
   public String comment;

   public Hour(int count, String comment){
       this.count = count;
       this.comment = comment;
   }
    public Hour(int count, String[] comments){
        this.count = count;
        Arrays.sort(comments);
        this.comments = comments;
    }

    public String getComment(){return comment; }
    public int getAmountOfPas(){return count;}
    public void setAmountOfPas(int count){this.count = count;}
    public String[] getComments(){return comments;}
    public int getNumOfComments(){return comments.length;}
    public void addComment(String comment){
        comments = Arrays.copyOf(comments, comments.length + 1);
        comments[comments.length-1] = comment;
    }
}
