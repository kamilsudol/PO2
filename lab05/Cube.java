public class Cube extends Square{
    protected double depth;

    Cube(double depth, double x, double y){
        super(depth, x, y);
        this.depth = depth;
    }

    public String getName(){
        return new String("Cube");
    }

    public String toString(){
        return new String(super.toString()+"; depth = " + depth);
    }

    public double area(){
        return 6*super.area();
    }

    public double volume(){
        return super.area()*depth;
    }
}