import java.util.*;

public class Testuj {
    private ArrayList<ArrayList<Integer>> test;
    private ArrayList<ArrayList<Integer>> out;
    private int n;
    private int m;

    public Testuj(ArrayList<String> sequence){
        test = new ArrayList<>();
        out = new ArrayList<>();
        resolveSequence(sequence);
    }

    public void resolveSequence(ArrayList<String> sequence){
        for(int i = 0; i < sequence.size(); i++){
            String[] tmp = sequence.get(i).split(" ");
            if(i == 0){
                n = Integer.parseInt(tmp[0]);
                m = Integer.parseInt(tmp[1]);
            }else{
                ArrayList<Integer> int_tmp = new ArrayList<>();
                for(int j = 0; j < tmp.length; j++){
                    int_tmp.add(Integer.parseInt(tmp[j]));
                }
                test.add(int_tmp);
            }
        }
    }

    public void result(){
        for(int i = 0; i < n; i++){
            ArrayList<Integer> int_tmp = new ArrayList<>();
            for(int j = 0; j < n; j++){
                int_tmp.add((i == j)? 1 : 0);
            }
            out.add(int_tmp);
        }

        for(int k = 0; k < m; k++) {
            ArrayList<Integer> int_tmp = test.get(k);
            for(int i = 0; i < n / 2; i++){
                for(int j = n / 2; j < n; j++){
                    out.get(int_tmp.get(i) - 1).set(int_tmp.get(j) - 1, 1);
                    out.get(int_tmp.get(j) - 1).set(int_tmp.get(i) - 1, 1);
                }
            }
        }
        
        if(compare()){
            System.out.println("TAK");
        }else{
            System.out.println("NIE");
        }
    }

    public Boolean compare(){
        int sum = 0;
        for(int i = 0; i < out.size(); i++){
            for(int j = 0; j < out.get(i).size(); j++){
                sum += out.get(i).get(j);
            }
        }
        return n*n == sum;
    }
}
