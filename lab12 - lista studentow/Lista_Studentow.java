import java.util.*;

public class Lista_Studentow {
    public ArrayList<Student> students;
    public Lista_Studentow(){
        students = new ArrayList<>();
    }

    public void add(Student new_student){
        students.add(new_student);
    }

    public void add(String im, String naz, int w){
        students.add(new Student(im, naz, w));
    }

    public void wypisz_wszystkich(){
        for(int i = 0; i < students.size(); i++){
            System.out.println(students.get(i));
        }
    }

    public void sort_imie_rosnaca(){
        Collections.sort(students, new SortImieRosnaco());
    }

    public void sort_imie_malejaca(){
        Collections.sort(students, new SortImieMalejaco());
    }

    public void sort_nazwisko_rosnaca(){
        Collections.sort(students, new SortNazwiskoRosnaco());
    }

    public void sort_nazwisko_malejaca(){
        Collections.sort(students, new SortNazwiskoMalejaco());
    }

    public void sort_wiek_rosnaca(){
        Collections.sort(students, new SortWiekRosnaco());
    }

    public void sort_wiek_malejaca(){
        Collections.sort(students, new SortWiekMalejaco());
    }
}
