public class Wpis {
    private String key;
    private String val;

    Wpis(String k, String v){
        key = k;
        val = v;
    }

    String getKey(){return key;}

    String getVal(){return val;}

    String getStr(String x){
        if(x.equals(key)){
            return getVal();
        }else {
            return getKey();
        }
    }

    boolean check(String x){
        return x.equals(key) || x.equals(val);
    }

    public String toString(){
        return key + " " + val + "\n";
    }
}