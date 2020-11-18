public class Point extends Shape{
    protected double x;
    protected double y;

    Point(double x, double y){
        this.x = x;
        this.y = y;
    }

    public String getName(){
        return new String("Point");
    }

    public String toString(){
        return new String("["+x+", "+y+"]");
    }

    public double area(){
        return 0.0;
    }

    public double volume(){
        return 0.0;
    }
}