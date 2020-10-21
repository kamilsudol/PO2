import java.util.*;

public class lab01{

    public static void draw_line(int x0, int y0, int x1, int y1){
        int step = 1000;
        double xlength = x1 - x0;
        double ylength = y1 - y0;
        double xstep = xlength/(double)step;
        double ystep = ylength/(double)step;

        double current_x = (double)x0, current_y = (double)y0;

        for(int i = 0; i < step; i++){
            System.out.println(current_x + " " + current_y);
            current_x = current_x + xstep;
            current_y = current_y + ystep;
        }
    }

    public static void draw_circle(int x, int y, int radius){
        for(int i = 0; i < 1000; i++){
            System.out.println((x + radius*Math.cos(i)) + " " + (y + radius*Math.sin(i)));
        }
    }

    public static void main(String [] args){
        draw_line(28,65,28,84);
        draw_line(28,84,34,83);
        draw_line(34,83,38,79);
        draw_line(38,79,37,76);
        draw_line(37,76,34,73);
        draw_line(28,72,37,76);
        draw_line(58,25,53,23);
        draw_line(53,23,47,23);
        draw_line(47,23,44,25);
        draw_line(74,65,63,65);
        draw_line(63,65,73,74);
        draw_line(73,74,73,79);
        draw_line(73,79,70,82);
        draw_line(70,82,66,82);
        draw_line(66,82,63,80);
        draw_circle(50,74,9);
        draw_circle(50,29,14);
        draw_circle(55,34,2);
        draw_circle(46,34,2);
    }
}