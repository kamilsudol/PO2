import java.io.*;
import java.util.*;

public class Serial implements Serializable {
    private ArrayList<String> file_content;

    Serial(){
        file_content = new ArrayList<>();
    }

    private void fill(String file){
        try{
            File content = new File(file);
            Scanner reader = new Scanner(content);
            while(reader.hasNextLine()){
                file_content.add(reader.nextLine());
            }
            reader.close();
        }catch(FileNotFoundException e){
            System.out.println("Plik o podanej nazwie nie istnieje!");
        }
    }

    public void serialize(String f1, String f2){
        fill(f1);
        try{
            File out = new File(f2);
            try {
                out.createNewFile();
            } catch (IOException e) {
                System.out.println("Blad podczas tworzenia nowego pliku.");
            }
            ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream(out));
            o.writeObject(this);
            o.close();
        }catch (IOException e){
            System.out.println("Blad!");
        }
    }

    public Serial deserialize(String f1){
        try {
            ObjectInputStream i=new ObjectInputStream(new FileInputStream(f1) );
            Serial tmp = (Serial) i.readObject();
            i.close();
            return tmp;
        }catch (IOException e){
            System.out.println("Blad!");
        }catch (ClassNotFoundException e){
            System.out.println("Blad przy deserializacji!");
        }
        return new Serial();
    }

    private void sort(){
        Collections.sort(file_content, new TextComparator());
    }

    private void save(String file){
        try {
            File out = new File(file);
            try {
                out.createNewFile();
            } catch (IOException e) {
                System.out.println("Blad podczas tworzenia nowego pliku.");
            }
            PrintWriter zapis = new PrintWriter(out);
            for(int i = 0; i < file_content.size(); i++){
                zapis.print(file_content.get(i) + "\n");
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            System.exit(1);
        }
    }

    public void compute(String file){
        sort();
        save(file);
    }
}
