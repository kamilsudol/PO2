import java.io.*;
import java.util.*;

public class lab09 {
    static public void main(String[] args){
        try{
            DaneWejsciowe wspolrzedne = new DaneWejsciowe();
            File f1 = new File(args[0]);
            Scanner reader = new Scanner(f1);
            while (reader.hasNextLine()) {
                String command = reader.nextLine();
                wspolrzedne.pobierzDane(command);
            }
            Podworko p = new Podworko(wspolrzedne);
            p.zlicz();
        }catch(FileNotFoundException e){
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
