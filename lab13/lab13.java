public class lab13 {
    public static void main(String[] args){
        try{
            Serial s = new Serial();
            if(args[0].endsWith(".txt") && args[1].endsWith(".ser")){
                s.serialize(args[0], args[1]);
            }else if(args[0].endsWith(".ser") && args[1].endsWith(".txt")){
                s = s.deserialize(args[0]);
                s.compute(args[1]);
            }else{
                System.out.println("Zle rozszerzenia plikow!");
                System.exit(1);
            }
        }catch(ArrayIndexOutOfBoundsException e){
            System.out.println("Niepoprawna liczba argumentow!");
            System.exit(1);
        }
    }
}
