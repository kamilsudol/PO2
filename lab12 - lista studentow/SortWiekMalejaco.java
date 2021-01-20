import java.util.*;

public class SortWiekMalejaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return String.valueOf(y.getWiek()).compareTo(String.valueOf(x.getWiek()));
    }
}
