import java.util.*;

public class SortNazwiskoMalejaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return y.getNazwisko().compareTo(x.getNazwisko());
    }
}
