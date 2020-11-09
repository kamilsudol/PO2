public class Square extends Point{
    private double side;

    Square(double s, double a, double b){
        super(a, b);
        side = s;
    }

    public String getName(){
        return "Square";
    }

    public String toString(){
        return "Corner = "+super.toString()+"; side = "+side;
    }

    public double area() {
        return side*side;
    }

    public double volume() {
        return 0;
    }
}
