package Lab1.Hierarchy;

class Employee extends Citizen {
    private int salary;
    private String position;
    Employee(String gender, String firstName, String lastName, String citizenShip, String city,
             int salary, String position){
        super(gender,firstName,lastName,citizenShip,city);
        this.salary=salary;
        this.position=position;
    }
    @Override
    public String toString(){
        return super.toString()+", Salary: "+salary+", Position: "+position;
    }
}
