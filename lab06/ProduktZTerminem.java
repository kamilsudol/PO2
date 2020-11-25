public class ProduktZTerminem extends ProduktSzablon{
    public int data;
    public int data_smierci;
    public void kolejnyDzien(){
        data += 1;
    }

    public boolean sprawdzDatePrzydatnosci(){
        return data == data_smierci;
    }
}
