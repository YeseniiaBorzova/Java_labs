package Lab1.Hierarchy;

class Student extends Citizen {
    private String university;
    private String group;
    private int yearOfEnrollment;
    Student(String gender, String firstName, String lastName, String citizenShip, String city,
    String university, String group, int yearOfEnrollment){
        super(gender,firstName,lastName,citizenShip,city);
        this.university=university;
        this.group=group;
        this.yearOfEnrollment=yearOfEnrollment;
    }
    @Override
    public String toString(){
        return super.toString()+", University: "+university+", Group: "+group+", Year of Enrollment: "+yearOfEnrollment;
    }
}
