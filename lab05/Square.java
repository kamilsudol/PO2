public class Square extends Point{

    protected double side;

    Square(double side, double x, double y){
        super(x, y);
        this.side = side;
    }

    public String getName(){
        return new String("Square");
    }

    public String toString(){
        return new String("Corner = "+super.toString()+"; side = " + side);
    }

    public double area(){
        return side*side;
    }

    public double volume(){
        return 0.0;
    }
}