import java.util.*;

public class Turtle {
    private int x;
    private int y;
    private double angle;
    private boolean end_statement;
    private boolean repeat_flag;
    private int loop_it;
    ArrayList<String> tmp;

    Turtle() {
        System.out.println("Start");
        x = 0;
        y = 0;
        angle = 0.0;
        end_statement = true;
        repeat_flag = false;
        loop_it = 0;
        tmp = new ArrayList<String>();
    }

    void execute(String commands){
        String[] comm = commands.split(" ");
        if ("HOME".equals(comm[0])) {
            if(repeat_flag){
                tmp.add(commands);
            }else{
                home();
            }
        }else if ("REPEAT".equals(comm[0])) {
            repeat_flag = true;
            loop_it = Integer.parseInt(comm[1]);
        }else if ("NEXT".equals(comm[0])) {
            repeat_flag = false;
            repeat_exe();
        }else if ("DRAW".equals(comm[0])) {
            if(repeat_flag){
                tmp.add(commands);
            }else{
                draw(Integer.parseInt(comm[1]));
            }
        }else if ("MOVE".equals(comm[0])) {
            if(repeat_flag){
                tmp.add(commands);
            }else{
                move(Integer.parseInt(comm[1]));
            }
        }else if ("LEFT".equals(comm[0])) {
            if(repeat_flag){
                tmp.add(commands);
            }else{
                left(Integer.parseInt(comm[1]));
            }
        }else if ("RIGHT".equals(comm[0])) {
            if(repeat_flag){
                tmp.add(commands);
            }else{
                right(Integer.parseInt(comm[1]));
            }
        }else if ("END".equals(comm[0])) {
            end_statement = false;
        }
    }

    void home(){
        x = 0;
        y = 0;
    }

    void draw(int param){
        System.out.println(x + " " + y);
        x += param * Math.sin(angle);
        y += param * Math.cos(angle);
        System.out.println(x + " " + y);
    }

    void move(int param){
        x += param * Math.sin(angle);
        y += param * Math.cos(angle);
    }

    void left(int param){
        angle -= Math.toRadians(param);
    }

    void right(int param){
        angle += Math.toRadians(param);
    }

    void repeat_exe(){
        for(int i = 0; i < loop_it; i++){
            for(int v=0; v < tmp.size(); v++){
                execute(tmp.get(v));
            }
        }
    }

    public boolean end_check(){
        return end_statement;
    }
}