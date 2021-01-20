public class Student {
    private String imie;
    private String nazwisko;
    private int wiek;

    public Student(){
        imie = "";
        nazwisko = "";
        wiek = 0;
    }

    public Student(String im, String nazw, int w){
        imie = im;
        nazwisko = nazw;
        wiek = w;
    }

    public String getImie(){return imie;}
    public String getNazwisko(){return nazwisko;}
    public int getWiek() { return wiek; }

    public void setImie(String imie){this.imie = imie;}
    public void setNazwisko(String nazwisko){this.nazwisko = nazwisko;}
    public void setWiek(int wiek){this.wiek = wiek;}

    public String toString(){
        return getImie()+" "+getNazwisko()+" "+getWiek();
    }
}
