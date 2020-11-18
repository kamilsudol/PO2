package Armia;
import java.util.*;

public class Czolg{
    private ArrayList<Rozkaz> lista;
    public Czolg(){
        lista = new ArrayList<Rozkaz>();
    }

    public void wydajRozkaz(Rozkaz rozkaz){
        lista.add(rozkaz);
    }

    public String toString(){
        String res = new String("");
        for(int i = 0; i < lista.size(); i++){
            res += lista.get(i).toString() + "\n";
        }
        return res;
    }

    public String ostatniRozkaz(){
        return new String("Ostatni rozkaz do mnie: " + lista.get(lista.size()-1).toString());
    }
}