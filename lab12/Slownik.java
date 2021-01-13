import java.io.*;
import java.util.*;

public class Slownik {
    private ArrayList<Wpis> dictionary;

    Slownik(ArrayList<String> file_data){
        dictionary = new ArrayList<>();
        for(int i = 0; i < file_data.size(); i++){
            String[] tmp = file_data.get(i).split(" ");
            dictionary.add(new Wpis(tmp[0], tmp[1]));
        }
    }

    public int contains(String val){
        for(int i = 0; i < dictionary.size(); i++){
            if(dictionary.get(i).check(val)) return i;
        }
        return -1;
    }

    public void resolve(String val){
        int idx = contains(val);
        try{
            System.out.println(dictionary.get(idx).getStr(val));
        }catch (Exception e){
            System.out.println("Brak słowa \""+val+"\" w słowniku....");
        }
    }

    public void delete(String key){
        int idx = contains(key);
        try{
            dictionary.remove(idx);
        }catch (Exception e){
            System.out.println("Brak słowa \""+key+"\" w słowniku....");
        }
    }

    public void add(String key, String val){
        if(contains(key) == -1 || contains(key) == -1){
            dictionary.add(new Wpis(key, val));
        }else{
            System.out.println("Słowo \""+val+"\" już jest w słowniku...");
        }
    }
    public void save(String file_path){
        try {
            PrintWriter zapis = new PrintWriter(file_path);
            for(int i = 0; i < dictionary.size(); i++){
                zapis.print(dictionary.get(i));
            }
            zapis.close();
        } catch (FileNotFoundException e) {
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            System.exit(1);
        }
    }
}