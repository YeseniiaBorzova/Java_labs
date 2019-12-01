package Lab1.Comparable;


class Circle implements Comparable<Circle>{
    private double radius;

    Circle(double radius){
        this.radius=radius;
    }
    public double getRadius(){
        return radius;
    }
    public void setRadius(double radius){
        this.radius=radius;
    }
    public int compareTo(Circle c){
        return Double.compare(getRadius(),c.getRadius());
    }
    @Override
     public String toString(){
        return "Radius: "+radius;
     }
}


