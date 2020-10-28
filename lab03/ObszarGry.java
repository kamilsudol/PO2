public class ObszarGry {
    private final int x;
    private final int y;
    private int[][] plansza;

    /**
     * Podstawowy konstruktor inicjalizujacy plansze o wymiarach XxY zerami.
     * @param x
     * @param y
     */

    ObszarGry(int x, int y){
        this.x = x;
        this.y = y;
        plansza = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                plansza[i][j] = 0;
            }
        }
    }

    /**
     * Prosta metoda ustawiajaca wartosc na planszy pod zadanymi indeksami.
     * @param x
     * @param y
     * @param value
     */

    public void set(int x, int y, int value){
        plansza[x][y] = value;
    }

    /**
     * Prosta metoda zwracajaca wartosc planszy pod zadanymi indeksami.
     *
     * @param x
     * @param y
     * @return int
     */

    public int get(int x, int y){
        return plansza[x][y];
    }

    /**
     * Metoda wyswietlajaca plansze.
     */

    public void wyswietl(){
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                if(get(i,j) == 0){
                    System.out.print(". ");
                }else{
                    System.out.print("X ");
                }
            }
            System.out.println();
        }
    }

    /**
     * Metoda tworzaca kopie aktualnej planszy.
     * @return int[][]
     */

    public int[][] kopiujObszar(){
        int[][] kopia = new int[y][x];
        for(int i = 0; i < y; i++){
            for(int j = 0; j < x; j++){
                kopia[i][j] = plansza[i][j];
            }
        }
        return kopia;
    }
}