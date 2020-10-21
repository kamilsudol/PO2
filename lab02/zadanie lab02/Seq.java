import java.util.*;

class Seq{
    int[] t;
    Vector<Integer> cleared; //wektor 'czystej' sekwencji

    Seq(int[] tab){
        t = tab;
        cleared = new Vector<Integer>();
    }

    void compare(Seq K){ //wykonanie calej operacji
        K.clear();
        this.clear();
        this.cmp(K);
    }

    void clear(){ //metoda czyszczaca ciag
        Boolean flag = false; //flaga pomocnicza
        for(int i = 0; i < t.length; i++){
            if(t[i] == 1){ //dodaj jedynke, ale zacznij pomijac zera
                cleared.add(t[i]);
                flag = true;
            }else if(t[i] == 0 && flag == false){ //dodaj zero, gdy nie wystapila jeszcze zadna jedynka
                cleared.add(t[i]);
            }
        }
    }

    void cmp(Seq K){
        Vector<Integer> res1 = new Vector<Integer>(); //rezultat dla porownania wyczyszczonych ciagow
        Vector<Integer> res2 = new Vector<Integer>(); //rezultat dla porownania pierwszego wyczyszczonego ciagu z drugim oryginalnym ciagiem
        Vector<Integer> res3 = new Vector<Integer>(); //rezultat dla porownania drugiego wyczyszczonego ciagu z pierwszym oryginalnym ciagiem

        //porownywanie wyczyszczonych ciagow
        int a = cleared.size(), b = K.cleared.size(); //rozmiary pomocnicze
        if(a > b){
            for(int i = b - 1; i >= 0; i--){
                if(cleared.elementAt(a-b+i)==K.cleared.elementAt(i)){ //uwzglednienie przesuniecia w indeksach
                    res1.add(K.cleared.elementAt(i));
                }else{
                    break;
                }
            }

        }else if(a == b){
            for(int i = a - 1; i >= 0; i--){
                if(cleared.elementAt(i)==K.cleared.elementAt(i)){
                    res1.add(K.cleared.elementAt(i));
                }else{
                    break;
                }
            }
        }else{
            for(int i = a - 1; i >= 0; i--){
                if(cleared.elementAt(i)==K.cleared.elementAt(b-a+i)){ //uwzglednienie przesuniecia w indeksach
                    res1.add(cleared.elementAt(i));
                }else{
                    break;
                }
            }
        }

        //porownywanie czystych z oryginalami
        int c = t.length, d = K.t.length; //rozmiary pomocnicze

        for(int i = a - 1; i >= 0; i--){
            if(cleared.elementAt(i)==K.t[d-a+i]){ //uwzglednienie przesuniecia w indeksach
                res2.add(cleared.elementAt(i));
            }else{
                break;
            }
        }

        for(int i = b - 1; i >= 0; i--){
            if(K.cleared.elementAt(i)==t[c-b+i]){ //uwzglednienie przesuniecia w indeksach
                res3.add(K.cleared.elementAt(i));
            }else{
                break;
            }
        }
        
        //procedura roztrzygniecia najlepszego rezultatu
        if(res1.size() >= res2.size()){
            if(res1.size() >= res3.size()){
                System.out.println(res1.size());
                print_seq(res1);

            }else if(res3.size() >= res2.size()){
                System.out.println(res3.size());
                print_seq(res3);

            }else{
                System.out.println(res2.size());
                print_seq(res2);
            }
        }else if(res2.size() >= res3.size()){
            System.out.println(res2.size());
            print_seq(res2);

        }else{
            System.out.println(res3.size());
            print_seq(res3);
        }

    }

    void print_seq(Vector<Integer> A){ //metoda wypisujaca ciag
        System.out.print("[ ciag: ");
        for(int i = A.size() - 1; i >= 0 ; i--){
            if(i != 0){
                System.out.print(A.elementAt(i)+" ");
            }else{
                System.out.print(A.elementAt(i)+"]\n");
            }
        }
    }
}