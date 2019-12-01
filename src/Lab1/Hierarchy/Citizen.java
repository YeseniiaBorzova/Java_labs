package Lab1.Hierarchy;

class Citizen extends Human{
    private String citizenShip;
    private String city;
    Citizen(String gender, String firstName, String lastName, String citizenShip, String city){
        super(gender, firstName, lastName);
        this.citizenShip=citizenShip;
        this.city=city;
    }
    @Override
    public String toString(){
        return super.toString()+", Citizenship: "+citizenShip+", City: "+city;
    }
}
