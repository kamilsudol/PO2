import java.util.*;

public class SortImieMalejaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return y.getImie().compareTo(x.getImie());
    }
}
