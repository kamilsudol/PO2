import java.io.IOException;

public class MyIOException extends IOException{
    public void what(){
        System.out.println("Zla liczba argumentow wywolania! Prosze podac nazwe pliku wczytywanego i wynikowego!");
    }
}