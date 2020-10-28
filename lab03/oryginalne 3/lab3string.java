public class lab3string {

    /**
     * Prosta metoda zwracajaca dlugosc lancucha znakow
     * @param s zadany lancuch
     * @return dlugosc
     */

    static int dlugosc(String s){
        return s.length();
    }

    /**
     * Metoda obliczajaca, ile razy w lancuchu znajduje sie zadany znak
     * @param s podany lancuch
     * @param znak szukany znak
     * @return ilosc
     */

    static int ile_razy_literka_wystepuje(String s, char znak){
        int count = 0;
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == znak) count++;
        }
        return count;
    }

    /**
     * Metoda sprawdzajaca, czy podane lancuchy sa takie same
     * @param s1
     * @param s2
     * @return
     */

    static boolean czy_takie_same(String s1, String s2){
        if(s1.length() != s2.length()){
            return false;
        }else{
            int check = 0;
            for(int i = 0; i < s1.length(); i++){
                if(s1.charAt(i) == s2.charAt(i)){
                    check++;
                }else{
                    break;
                }
            }
            return check == s1.length();
        }
    }

    /**
     * Metoda zwracajaca podany lancuch "od tylu"
     * @param s
     * @return
     */

    static String wspak(String s){
        String wyraz_wspak = new String("");
        for(int i = s.length() - 1; i >= 0; i--){
            wyraz_wspak = wyraz_wspak + s.charAt(i);
        }
        return wyraz_wspak;
    }

    /**
     * Metoda sprawdzajaca, czy podany lancuch jest palindromem. Wykorzystuje wcześniej zdefiniowane metody wspak() oraz czy_takie_same()
     * @param s lancuch
     * @return
     */

    static boolean czy_plaindrom(String s){
        String w = wspak(s);
        return czy_takie_same(s, w);
    }

    /**
     * Metoda sprawdzajaca, czy kolejne znaki lancucha zachowuja szyk alfabetyczny
     * @param s
     * @return
     */

    static boolean czy_abecadlowe(String s){
        int check = 0;
        for(int i = 1; i < s.length(); i++){
            if((int)s.charAt(i-1) < (int)s.charAt(i)){
                check++;
            }else{
                break;
            }
        }
        return check == (s.length() - 1); // -1 ze wzgledu na zawezenie zakresu w petli
    }

    /**
     * Szyfr cezara o przesunieciu 13.
     * @param s
     * @return
     */

    static String rot13(String s){
        String rot = new String("");
        for(int i = 0; i < s.length(); i++){
            if((int)s.charAt(i) > 64 && (int)s.charAt(i) < 91){
                if((int)s.charAt(i) + 13 > 90){
                    rot += (char)((int)s.charAt(i) - 13);
                }else{
                    rot += (char)((int)s.charAt(i) + 13);
                }
            }else if((int)s.charAt(i) > 96 && (int)s.charAt(i) < 123){
                if((int)s.charAt(i) + 13 > 122){
                    rot += (char)((int)s.charAt(i) - 13);
                }else{
                    rot += (char)((int)s.charAt(i) + 13);
                }
            }else{
                rot += s.charAt(i);
            }
        }
        return rot;
    }
}
