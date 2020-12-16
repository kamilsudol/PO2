public class Podworko {
    public int[][] plansza;
    private int x;
    private int y;
    private DaneWejsciowe A;
    public Podworko(DaneWejsciowe A){
        x = A.maxVal(2);
        y = A.maxVal(3);
        plansza = new int[x][y];
        this.A = A;
        wypelnij();
    }

    public void wypelnij(){
        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                plansza[i][j] = 0;
            }
        }
        String[] tmp;
        int x1, x2, y1,y2;
        for(int k = 1; k < Integer.parseInt(A.dzieciaki.get(0)) + 1; k++){
            tmp = A.dzieciaki.get(k).split(" ");
            x1 = Integer.parseInt(tmp[0]);
            y1 = Integer.parseInt(tmp[1]);
            x2 = Integer.parseInt(tmp[2]);
            y2 = Integer.parseInt(tmp[3]);
            for(int i = x1; i <= x2; i++){
                for(int j = y1; j <= y2; j++){
                    plansza[i][j]++;
                }
            }
        }
    }

    public void zlicz(){
        int count = 0;

        for(int i = 0; i < x; i++){
            for(int j = 0; j < y; j++){
                 if(plansza[i][j] < Integer.parseInt(A.dzieciaki.get(0)) - 1){
                     count++;
                 }
            }
        }
        System.out.println(count);
    }
}
