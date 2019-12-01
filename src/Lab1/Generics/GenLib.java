package Lab1.Generics;
import java.util.Arrays;

public class GenLib<T> {
    public static<T> void SwapGroups(T[] arr, int firstStart, int firstEnd, int secondStart, int secondEnd){
        int firstPart = firstEnd-firstStart+1;
        int midPart = secondStart-firstEnd-1;
        int endPart = secondEnd-secondStart+1;

        Object[] first = new Object[firstPart];
        Object[] second = new Object[midPart];
        Object[] end = new Object[endPart];

        System.arraycopy(arr,firstStart,first,0,firstPart);
        System.arraycopy(arr,firstEnd+1,second,0,midPart);
        System.arraycopy(arr,secondStart,end,0,endPart);

        System.arraycopy(end, 0,arr,firstStart,endPart);
        System.arraycopy(second,0,arr,firstStart+endPart,midPart);
        System.arraycopy(first,0,arr,firstStart+endPart+midPart,firstPart);
    }

    public static<T> void SwapNeighbors(T[]arr){
        T temp;
        for(int i=0;i<((arr.length/2)*2);i+=2){
            temp = arr[i];
            arr[i]=arr[i+1];
            arr[i+1]=temp;
        }
    }

    public static<T> T[] insert(T[] from, int fromPos, T[] to, int toPos,int num){
        T[] temp = Arrays.copyOf(to,to.length+num);
        System.arraycopy(from, fromPos,temp,toPos,num);
        System.arraycopy(to,toPos,temp,toPos+num,to.length-toPos);
        return temp;
    }
    public static<T> T[] replaceWithOtherArray(T[] from, int fromPos, T[] to, int toPos,int num){
        System.arraycopy(from,fromPos,to,toPos,num);
        return to;
    }

    public void print(T[]arr){
        for (int i = 0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
        System.out.println();
    }

    public static void main(String[] args){
        GenLib utills = new GenLib();
        String[] arr1 = {"p","q","a","y","v","z","b","s","x","y"};
        String[] arr2 = {"m","k","l","f","c","y","n","a","j","o"};
        Double[] arr3 = {5.6,9.6,3.4,7.1,1.8,5.9,3.8,2.7,4.8};
        Double[] arr4 = {7.09,6.8,4.6,3.7,2.7,8.9,4.9,2.7,6.6};
        System.out.println("Swap Groups");
        SwapGroups(arr1, 2, 5, 7, 9);
        utills.print(arr1);
        System.out.println("Swap Neighbors");
        SwapNeighbors(arr1);
        utills.print(arr1);
        System.out.println("Insert elements");
        arr1 = insert(arr2, 3, arr1, 4, 3);
        utills.print(arr1);
        System.out.println("Replace with another array");
        arr1 = replaceWithOtherArray(arr2, 1, arr1, 5, 4);
        utills.print(arr1);
        System.out.println("Swap Groups");
        SwapGroups(arr3, 2, 5, 7, 8);
        utills.print(arr3);
        System.out.println("Swap Neighbors");
        SwapNeighbors(arr3);
        utills.print(arr3);
        System.out.println("Insert elements");
        arr3 = insert(arr4, 3, arr3, 4, 3);
        utills.print(arr3);
        System.out.println("Replace with another array");
        arr3 = replaceWithOtherArray(arr4, 1, arr3, 5, 4);
        utills.print(arr3);
    }
}
