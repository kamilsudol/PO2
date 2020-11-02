public class Cube extends Square{
    private double depth;

    Cube(double d, double a, double b){
        super(d, a, b);
        depth = d;
    }

    public String getName(){
        return "Cube";
    }

    public String toString(){
        return super.toString() + "; depth = " + depth;
    }

    public double area() {
        return 6*super.area();
    }

    public double volume() {
        return super.area()*depth;
    }
}
