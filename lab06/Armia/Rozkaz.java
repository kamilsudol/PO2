package Armia;

public class Rozkaz{
    private String rozkaz;
    public Rozkaz(String rozkaz){
        this.rozkaz = new String(rozkaz);
    }

    public String toString(){
        return rozkaz;
    }
}