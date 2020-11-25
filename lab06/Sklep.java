import java.io.*;
import java.util.*;

public class Sklep implements InterfaceSklep{
    private boolean end_flag;
    private int dzien;
    private double stan_konta;
    private ArrayList<Produkt> lista_produktow;

    Sklep(){
        end_flag = true;
        dzien = 0;
        stan_konta = 0;
        lista_produktow = new ArrayList<Produkt>();
    }

    public void start(){
        System.out.println("Witaj w sklepie!");
        while(end_flag){
            menu();
        }
    }
    public void menu(){
        System.out.println("|MENU|");
        System.out.println("1) Dodaj towar");
        System.out.println("2) Sprzedaj towar");
        System.out.println("3) Kolejny dzień");
        System.out.println("4) Bilans");
        System.out.println("X) Koniec programu");

        String opcja = pobierzNapis();

        switch (opcja){
            case("1"):
                dodajTowar();
                break;
            case("2"):
                sprzedajTowar();
                break;
            case("3"):
                kolejnyDzien();
                break;
            case("4"):
                bilans();
                break;
            case("X"):
                koniec();
                break;
            case("x"):
                koniec();
                break;
            default:
                System.out.println("Zły znak! Spróbuj ponownie.");
        }

    }
    public void dodajTowar(){
        String opcja = prodOpcja();

        switch (opcja){
            case("1"):
                String[] a = dane();
                lista_produktow.add(new Owoc(a[0],Integer.parseInt(a[1]),Integer.parseInt(a[2])));
                break;
            case("2"):
                String[] b = dane();
                lista_produktow.add(new Warzywo(b[0],Integer.parseInt(b[1]),Integer.parseInt(b[2])));
                break;
            case("3"):
                String[] c = dane();
                lista_produktow.add(new Agd(c[0],Integer.parseInt(c[1]),Integer.parseInt(c[2])));
                break;
            default:
                System.out.println("Zły znak! Spróbuj ponownie.");
        }
    }

    public String prodOpcja(){
        System.out.println("Jaki produkt chcesz dodac?");
        System.out.println("1) dodaj owoc");
        System.out.println("2) dodaj warzywo");
        System.out.println("3) dodaj drobne agd");
        return pobierzNapis();
    }

    public String pobierzNapis(){
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        try{
            String opcja = in.readLine();
            return opcja;
        }catch(Throwable a){
            System.out.println("ERROR");
        }
        return new String("");
    }

    public String[] dane(){
        System.out.println("Podaj nazwe produktu:");
        String nazwa = pobierzNapis();
        System.out.println("Podaj cene zakupu produktu:");
        String cen_zak = pobierzNapis();
        System.out.println("Podaj cene sprzedazy produktu:");
        String cen_sprz = pobierzNapis();
        return new String[]{nazwa, cen_zak, cen_sprz};
    }

    public void sprzedajTowar(){
        System.out.println("Ktory produkt chcesz sprzedac?");
        for(int i = 0; i < lista_produktow.size(); i++){
            System.out.println((i+1) + ") " + lista_produktow.get(i).getNazwa());
        }
        System.out.println((lista_produktow.size()+1) + ") W tym momencie zaden");

        int opcja = Integer.parseInt(pobierzNapis());
        if(opcja <= lista_produktow.size() ){
            stan_konta += lista_produktow.get(opcja-1).getCenaSprz() - lista_produktow.get(opcja-1).getCenaZak();
            System.out.println("Sprzedano \""+ lista_produktow.get(opcja-1).getNazwa() +"\"!");
            lista_produktow.remove(opcja-1);
        }
    }

    public void kolejnyDzien(){
        dzien += 1;
        aktualizuj();
    }

    public void bilans(){
        System.out.println("Twoj stan konta wynosi: " + stan_konta + " zl");
    }
    public void koniec(){
        System.out.println("Do zobaczenia!");
        end_flag = false;
    }

    public void aktualizuj(){
        for(int i = 0; i < lista_produktow.size(); i++){
            lista_produktow.get(i).kolejnyDzien();
        }

        for(int i = 0; i < lista_produktow.size(); i++){
            if(lista_produktow.get(i).sprawdzDatePrzydatnosci()){
                stan_konta -= lista_produktow.get(i).getCenaZak();
            }
        }

        int iter = lista_produktow.size();
        while(iter != 0){
            for(int i = 0; i < lista_produktow.size(); i++){
                if(lista_produktow.get(i).sprawdzDatePrzydatnosci()){
                    System.out.println("Produkt \""+lista_produktow.get(i).getNazwa()+"\" stracil date przydatnosci!");
                    lista_produktow.remove(i);
                    break;
                }
            }
            iter--;
        }

    }
}
