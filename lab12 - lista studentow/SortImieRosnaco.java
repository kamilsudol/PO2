import java.util.*;

public class SortImieRosnaco implements Comparator<Student> {
    public int compare(Student x, Student y){
        return x.getImie().compareTo(y.getImie());
    }
}
