package Lab1.Hierarchy;

public class main {
    public static void main(String[] args){
        Human[] arr = new Human[4];
        arr[0]= new Human("Female","Ann","Brown");
        arr[1]= new Citizen("Male","John","Backswell","Australian","Sydney");
        arr[2]= new Student("Male","Norman","Reedus","American","Los Angeles","NTU KhPI","KN36b",2018);
        arr[3]= new Employee("Male","George","Miller","American","New York",150000,"Singer");
        for(int i=0;i<4;i++){
            System.out.println(arr[i].toString());
        }
    }
}
