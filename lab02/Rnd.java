//import java.util.;

public class Rnd {

    double[] tab;
    Rnd(int N, int k){
        tab = new double[N];
        for(int i = 0; i < N; i++){
            tab[i] = .0;
            for(int j = 0; j < k; j++){
                tab[i]+=Math.random();
            }
        }
    }
    void Print(){
        for(int i = 0; i < tab.length; i++){
            System.out.println("["+i+"]="+tab[i]);
        }
    }
    void Draw(){

        for(int i = 0; i < tab.length; i++){
            double star = (tab[i]-Min())/(Max()-Min())*50;
            System.out.print("["+i+"]:");
            for(int j = 0; j < (int)star; j++){
                System.out.print("*");
            }
            System.out.print("\n");
        }
    }
    double Min(){
        double min = tab[0];
        for (double v : tab) {
            if (v <= min) {
                min = v;
            }
        }
        return min;
    }
    double Max(){
        double max = tab[0];
        for (double v : tab) {
            if (v >= max) {
                max = v;
            }
        }
        return max;

    }
    double Average(){
        double av = .0;
        for (double v : tab) {
            av += v;
        }
        return av/ tab.length;
    }
}
