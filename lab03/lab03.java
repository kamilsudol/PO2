/*

    Lab03, Kamil Sudoł

*/


public class lab03 {
    public static void main(String[] args){

        if(args.length != 4){
            System.out.println("Nieprawidlowa liczba argumentow, hint(java lab04 size_x size_y steps preset)");
            System.exit(1);
        }else if(Integer.parseInt(args[0]) < 3 || Integer.parseInt(args[1]) < 3){
            System.out.println("Nieprawidlowy rozmiar planszy, hint(x and y >= 3)");
            System.exit(1);
        }

        Gra nowa_gra = new Gra(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]), Integer.parseInt(args[3]));
        nowa_gra.start();
    }
}