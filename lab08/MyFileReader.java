import java.io.*;
import java.util.*;

public class MyFileReader {
    public String file_in;
    public String file_out;
    ArrayList<Integer> elements;
    double avg;
    MyFileReader(String in, String out){
        file_in = in;
        file_out = out;
        elements = new ArrayList<Integer>();
        read();
    }

    public void read(){
        try{
            File f1 = new File(file_in);
            Scanner reader = new Scanner(f1);
            while (reader.hasNextLine()) {
                String command = reader.nextLine();
                this.add(command);
            }
            reader.close();
            System.out.println("Pomyslnie otwarto plik!");
        }catch(FileNotFoundException e){
            System.out.println("Wczytywany plik o podanej nazwie nie istnieje!");
            //e.printStackTrace();
            System.exit(1);
        }
    }

    public void add(String x){
        try{
            int tmp = Integer.parseInt(x);
            elements.add(tmp);
        }catch (NumberFormatException e){
            System.out.println("Podany ciag w pliku nie jest typu Integer!");
            //e.printStackTrace();
            System.exit(1);
        }
    }

    public void average(){
        double sum = 0;
        try{
            for(int i = 0; i < elements.size(); i++){
                sum = Math.addExact((int) sum, elements.get(i));
            }
            if(elements.size() == 0){
                if(sum == 0){
                    throw new DivZeroByZeroException();
                }else{
                    throw new DivByZeroException();
                }
            }else{
                avg = sum/ elements.size();
                System.out.println("Srednia: " + avg);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Zly indeks tablicy!");
            //e.printStackTrace();
            System.exit(1);
        }catch(DivZeroByZeroException e){
            e.what();
            //e.printStackTrace();
            System.exit(1);
        }catch(DivByZeroException e){
            e.what();
            //e.printStackTrace();
            System.exit(1);
        }catch(ArithmeticException e){
            System.out.println("Przekroczono dopuszczalna wartosc int!");
            //e.printStackTrace();
            System.exit(1);
        }
    }

    public void save(){
        try{
            FileWriter f2 = new FileWriter(file_out);
            f2.write(Double.toString(avg));
            f2.close();
            System.out.println("Pomyslnie zapisano do pliku!");
        }catch(IOException e){
            System.out.println("Nieznany blad przy probie zapisu do pliku!");
            //e.printStackTrace();
            System.exit(1);
        }
    }
}
