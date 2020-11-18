import java.util.*;

public class Turtle {
    private int x;
    private int y;
    private double angle;
    private boolean end_statement;
    private int ignore;
    List list;

    Turtle() {
        x = 0;
        y = 0;
        angle = 0.0;
        end_statement = true;
        list = new List();
        ignore = 0;
    }

    void addCommand(String c){
        list.listAdd(c);
        if ("END".equals(c)) {
            read_and_execute();
        }
    }

    public void read_and_execute(){
        Node tmp = list.getStart();
        while(tmp.getNext() != null){
            if(ignore == 0){
                execute(tmp);
            }else{
                ignore--;
            }
            tmp = tmp.getNext();
        }
        if(ignore == 0){
            execute(tmp);
        }else{
            ignore--;
        }

    }

    void execute(Node command){
        String[] comm = command.getCommand().split(" ");
        if ("HOME".equals(comm[0])) {
            home();
        }else if ("REPEAT".equals(comm[0])) {
            repeat_exe(command.getNext(), Integer.parseInt(comm[1]));
        }else if ("DRAW".equals(comm[0])) {
            draw(Integer.parseInt(comm[1]));
        }else if ("MOVE".equals(comm[0])) {
            move(Integer.parseInt(comm[1]));
        }else if ("LEFT".equals(comm[0])) {
            left(Integer.parseInt(comm[1]));
        }else if ("RIGHT".equals(comm[0])) {
            right(Integer.parseInt(comm[1]));
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

    void repeat_exe(Node command, int iter){
        for(int i = 0; i < iter; i++){
            Node tmp = command;
            ignore = 0;
            while(!tmp.getCommand().equals("NEXT")){
                execute(tmp);
                tmp = tmp.getNext();
                ignore++;
            }
        }
    }

    public boolean end_check(){
        return end_statement;
    }

    public void debug(){
        list.print();
        end_statement = false;
    }
}
