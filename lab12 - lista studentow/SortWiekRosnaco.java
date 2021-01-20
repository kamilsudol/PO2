import java.util.*;

public class SortWiekRosnaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return String.valueOf(x.getWiek()).compareTo(String.valueOf(y.getWiek()));
    }
}
