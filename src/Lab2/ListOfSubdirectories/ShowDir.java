package Lab2.ListOfSubdirectories;
        import java.io.File;
        import java.io.FilenameFilter;
        import java.util.Scanner;

public class ShowDir {

    public static void showSubdirectories(String path, int tabs){
        File dir = new File(path);
        if(!dir.isDirectory()){
            System.out.println("Invalid folder name!");
            return;
        }
        File[] list = dir.listFiles();
        for(File file : list){
            for (int i = 0;i<tabs;i++){ System.out.print("    "); }
            System.out.println(file.getName());
            if(file.isDirectory())
                showSubdirectories(file.getPath(),tabs+1);
        }

    }
    public static void main(String[] args) {showSubdirectories("D:\\study",0); }

}

