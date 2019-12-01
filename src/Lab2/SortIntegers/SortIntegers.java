package Lab2.SortIntegers;

import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.StringTokenizer;

public class SortIntegers {
    Integer[] arr = new Integer[0];

    void readFromFile(String filename) throws IOException,InputMismatchException{
        try{
            FileReader fr = new FileReader(filename);
            BufferedReader br = new BufferedReader(fr);
            String s = br.readLine();
            try{
                StringTokenizer st = new StringTokenizer(s);
                while(st.hasMoreTokens()){
                    try{
                        int temp  = Integer.parseInt(st.nextToken());
                        if(temp<=0){throw new NonPositiveException();}
                        arr = Arrays.copyOf(arr, arr.length+1);
                        arr[arr.length-1] = temp;
                    }catch(NonPositiveException ex){
                        System.out.println("Incorrect format of input. Some elements will be skipped!");
                    }catch(NumberFormatException ex){
                        System.out.println(ex.getMessage());
                    }
                }
            }finally {
                br.close();
            }

        }catch( IOException ex){
            ex.printStackTrace();
        }
    }
    void writeToFile(String filename){
        try{
            FileWriter fw = new FileWriter(filename);
            PrintWriter pw = new PrintWriter(fw);
            for(int i = 0;i<arr.length;i++){
                pw.print(arr[i]+" ");
            }
            pw.close();
        }catch(IOException ex){
            ex.printStackTrace();
        }
    }
    void sortByIncrSum(){ java.util.Arrays.sort(arr,new IncrDigitsSumComp());}
    void sortByDercSum(){java.util.Arrays.sort(arr,new DecrComp());}

    public static void main(String[] args) {
        try {
            SortIntegers sort = new SortIntegers();
            sort.readFromFile("src\\Lab2\\SortIntegers\\Input.txt");
            sort.sortByDercSum();
            sort.writeToFile("src\\Lab2\\SortIntegers\\DecOrder.txt");
            sort.sortByIncrSum();
            sort.writeToFile("src\\Lab2\\SortIntegers\\IncrSumOfDigits.txt");
        }catch(IOException ex){
            ex.printStackTrace();
        }catch(InputMismatchException ex){
            ex.printStackTrace();
        }

    }
}
