public class Point extends Shape{
    private double x;
    private double y;

    Point(double a, double b){
        this.x = a;
        this.y = b;
    }

    public String getName(){
        return "Point";
    }

    public String toString(){
        return "["+x+", "+y+"]";
    }

    public double area() {
        return 0;
    }
    
    public double volume() {
        return 0;
    }
}
