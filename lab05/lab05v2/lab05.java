import java.util.*;
import java.io.*;

public class lab05 {
    public static void main(String[] args) {
        Turtle t = new Turtle();
        // while (t.end_check()) {
        //     String command = System.console().readLine();
        //     t.addCommand(command);
        //     //System.out.println(command);
           
        // }

        try {
            File file = new File("turtle.txt");
            Scanner reader = new Scanner(file);
            while (reader.hasNextLine()) {
                String command = reader.nextLine();
                t.addCommand(command);
            }
            reader.close();
        } catch (FileNotFoundException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }
}