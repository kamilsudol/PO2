import java.util.*;

public class SortNazwiskoRosnaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return x.getNazwisko().compareTo(y.getNazwisko());
    }
}
