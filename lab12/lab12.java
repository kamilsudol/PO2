import java.io.*;
import java.util.*;

public class lab12 {
    public static void main(String[] args){
        try{
            File f1 = new File("dic.txt");
            try {
                f1.createNewFile();
            } catch (IOException e) {
                System.out.println("Blad podczas tworzenia nowego pliku.");
            }
            Scanner reader = new Scanner(f1);
            ArrayList<String> lines = new ArrayList<>();
            while (reader.hasNextLine()) {
                lines.add(reader.nextLine());
            }
            reader.close();
            Slownik dict = new Slownik(lines);
            try{
                if(args.length < 4 && args.length > 0){
                    if(args.length == 1){
                        dict.resolve(args[0]);
                    }else if(args.length == 2){
                        if(args[0].equals("del")){
                            dict.delete(args[1]);
                        }else{
                            throw new Exception();
                        }
                    }else{
                        if(args[0].equals("add")){
                            dict.add(args[1], args[2]);
                        }else{
                            throw new Exception();
                        }
                    }
                }else{
                    throw new Exception();
                }
            }catch (Exception e){
                System.out.println("Niepoprawna liczba parametrow wywolania programu lub bledna nazwa operacji!");
            }
            dict.save("dic.txt");
        }catch(FileNotFoundException e){
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            e.printStackTrace();
            System.exit(1);
        }
    }
}
