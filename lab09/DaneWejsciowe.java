import java.util.*;

public class DaneWejsciowe {
    public ArrayList<String> dzieciaki;
    DaneWejsciowe(){
        dzieciaki = new ArrayList<String>();
    }

    public void pobierzDane(String line){
        dzieciaki.add(line);
    }

    public int maxVal(int a){
        String[] tmp;
        int max = 0;
        int b;
        for(int i = 1; i < Integer.parseInt(dzieciaki.get(0)) + 1; i++){
            tmp = dzieciaki.get(i).split(" ");
            b = Integer.parseInt(tmp[a]);
            if(max <= b){
                max = b;
            }
        }
        return max + 1;
    }
}
