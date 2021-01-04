import java.io.*;
import java.util.*;

public class lab11 {
    public static void main(String[] args){
        try{
            File f1 = new File(args[0]);
            Scanner reader = new Scanner(f1);
            ArrayList<String> lines = new ArrayList<>();
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            Testuj test = new Testuj(lines);
            test.result();
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
