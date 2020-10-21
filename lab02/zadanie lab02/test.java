import java.util.*;

public class test{
    public static void main(String[] args){

        Scanner in = new Scanner(System.in);
        int x = in.nextInt();
        int y = in.nextInt();
        int[] t1 = new int[x];
        int[] t2 = new int[y];
        for(int i = 0; i < x; i++){
            t1[i] = in.nextInt();
        }
        for(int i = 0; i < y; i++){
            t2[i] = in.nextInt();
        }
        Seq A = new Seq(t1);
        Seq B = new Seq(t2);
        
        A.compare(B);
    }
}