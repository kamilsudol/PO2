import java.io.FileNotFoundException;
import java.io.IOException;

public class lab08 {
    public static void main(String[] args){
        try{
            if(args.length != 2){
                throw new MyIOException();
            }else{
                MyFileReader file = new MyFileReader(args[0], args[1]);
                file.average();
                file.save();
            }
        }catch(MyIOException e){
            e.what();
            e.printStackTrace();
            System.exit(1);
        }
    }
}
