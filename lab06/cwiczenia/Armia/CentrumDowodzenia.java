package Armia;
import java.util.*;

public class CentrumDowodzenia{
    ArrayList<Czolg> czolgi;
    public CentrumDowodzenia(){
        czolgi = new ArrayList<Czolg>();
    }

    public void zarejestrujCzolg(Czolg a){
        czolgi.add(a);
    }

    public void wydajRozkaz(String numer, Rozkaz rozkaz){
        int nr = Integer.parseInt(numer) - 1;
        czolgi.get(nr).wydajRozkaz(rozkaz);
    }

    public String toString(){
        String res = new String("");
        res += "Do tej pory centrum dowodzenia wyslalo nastepujace rozkazy:\n";
        for(int i = 0; i < czolgi.size(); i++){
            res += "Czolg nr "+ (i+1) +" otrzymal rozkazy:\n";
            res += czolgi.get(i).toString();
            res += "\n";
        }
        return res;
    }

}