public class Gra {
    private final int size_x;
    private final int size_y;
    private final int steps;
    private final int preset;
    private ObszarGry plansza;

    /**
     * Podstawowy konstruktor inicjalizujacy skladniki klasy.
     * @param x
     * @param y
     * @param stp
     * @param prst
     */

    public Gra(int x, int y, int stp, int prst){
        size_x = x;
        size_y = y;
        steps = stp;
        preset = prst;
        plansza = new ObszarGry(size_x, size_y);
    }

    /**
     * Wzor - niezmiennik
     */

    private void lodz(){
        plansza.set(size_y/2,size_x/2 + 1,1);
        plansza.set(size_y/2 - 1,size_x/2,1);
        plansza.set(size_y/2 + 1, size_x/2, 1);
        plansza.set(size_y/2,size_x/2 - 1,1);
        plansza.set(size_y/2 - 1,size_x/2 - 1, 1);
    }

    /**
     * Wzor - spaceship
     */

    private void szybowiec(){
        plansza.set(size_y/2 - 1,size_x/2 + 1,1);
        plansza.set(size_y/2 - 1,size_x/2,1);
        plansza.set(size_y/2 - 1,size_x/2 - 1,1);
        plansza.set(size_y/2 ,size_x/2 - 1,1);
        plansza.set(size_y/2 + 1,size_x/2,1);
    }

    /**
     * Wzor - oscylator
     */

    private void blinker(){
        plansza.set(size_y/2,size_x/2 + 1,1);
        plansza.set(size_y/2,size_x/2,1);
        plansza.set(size_y/2,size_x/2 - 1,1);
    }

    /**
     * Wzor - losowy rozklad
     */

    private void losowo(){
        for(int i = 0; i < size_y; i++){
            for(int j = 0; j < size_x; j++){
                if(Math.random() >= .5){
                    plansza.set(i, j, 1);
                }else{
                    plansza.set(i, j, 0);
                }
            }
        }
    }

    /**
     * Metoda generujaca wzor w zaleznosci od wczesniejszego wyboru.
     */

    private void wygeneruj_wzor(){
        switch(preset){
            case(0):
                losowo();
                break;
            case(1):
                lodz();
                break;
            case(2):
                blinker();
                break;
            case(3):
                szybowiec();
                break;
        }
    }

    /**
     * Metoda, przy pomocy ktorej zliczani sa zywi sasiedzi danego punktu,
     * na podstawie czego plansza jest potem aktualizowana metoda zmien().
     */

    private void aktualizuj(){
        int[][] plansza_tmp = plansza.kopiujObszar();
        int sasiedzi;
        for(int i = 0; i < size_y; i++) {
            for (int j = 0; j < size_x; j++) {
                sasiedzi = 0;
                //badanie srodka planszy
                if (i > 0 && i < size_y - 1 && j > 0 && j < size_x - 1) {
                    if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                    if (plansza_tmp[i - 1][j - 1] == 1) sasiedzi++;
                    if (plansza_tmp[i][j - 1] == 1) sasiedzi++;
                    if (plansza_tmp[i + 1][j - 1] == 1) sasiedzi++;
                    if (plansza_tmp[i + 1][j] == 1) sasiedzi++;
                    if (plansza_tmp[i + 1][j + 1] == 1) sasiedzi++;
                    if (plansza_tmp[i][j + 1] == 1) sasiedzi++;
                    if (plansza_tmp[i - 1][j + 1] == 1) sasiedzi++;

                    zmien(sasiedzi, i, j);
                } else if (i == 0) { //pierwsza krawedz
                    if (j == 0) {
                        if (plansza_tmp[i + 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j + 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    } else if (j == size_x - 1) {
                        if (plansza_tmp[i + 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j - 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    } else {
                        if (plansza_tmp[i + 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j + 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    }

                } else if (i == size_y - 1) { //druga krawedz
                    if (j == 0) {
                        if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j + 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    } else if (j == size_x - 1) {
                        if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j - 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    } else {
                        if (plansza_tmp[i - 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j + 1] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    }

                } else if (i > 0 && i < size_y - 1) { //trzecia krawedz
                    if (j == 0) {
                        if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j + 1] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    } else if (j == size_x - 1) {  //czwarta krawedz
                        if (plansza_tmp[i - 1][j] == 1) sasiedzi++;
                        if (plansza_tmp[i - 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j - 1] == 1) sasiedzi++;
                        if (plansza_tmp[i + 1][j] == 1) sasiedzi++;

                        zmien(sasiedzi, i, j);
                    }
                }
            }
        }
    }

    /**
     * Metoda decydujaca o tym, czy dany punkt ma zostac wskrzeszony czy dobity.
     *
     * @param sasiedzi
     * @param i
     * @param j
     */

    private void zmien(int sasiedzi, int i, int j) {
        if(plansza.get(i, j) == 0){
            if(sasiedzi == 3) {
                plansza.set(i, j, 1);
            }
        }else{
            if(sasiedzi == 3 || sasiedzi == 2){
                plansza.set(i, j, 1);
            }else{
                plansza.set(i, j, 0);
            }
        }
    }

    /**
     * Metoda sterujaca calym procesem gry.
     * Na poczatku zostaje wygenerowany wczesniej wybrany wzor,
     * gdzie potem w zaleznosci od podanej liczby krokow plansza
     * jest aktualizowana.
     */

    public void start(){
        wygeneruj_wzor();
        String title = new String("");
        for(int i = 0; i < (int)size_x/2; i++){
            title += "= ";
        }
        for(int i = 1; i < steps + 1; i++){
            System.out.println(title + i + " " + title);
            plansza.wyswietl();
            aktualizuj();
        }
    }
}