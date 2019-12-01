package Lab1.Hierarchy;

class Human {
    private String gender;
    private String firstName;
    private String lastName;

    Human(String gender, String firstName, String lastName) {
        this.gender = gender;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + ", Gender: " + gender;
    }
}
