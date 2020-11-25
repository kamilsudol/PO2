public class ProduktSzablon implements Produkt{
    public String nazwa;
    public int cena_zak;
    public int cena_sprz;

    public String getNazwa(){
        return nazwa;
    }

    public int getCenaZak(){
        return cena_zak;
    }

    public int getCenaSprz(){
        return cena_sprz;
    }

    public void kolejnyDzien(){ }

    public boolean sprawdzDatePrzydatnosci(){
        return false;
    }
}
