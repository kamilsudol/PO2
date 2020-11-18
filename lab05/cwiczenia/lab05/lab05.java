public class lab05 {
    public static void main(String[] args) {
        Turtle t = new Turtle();
        while (t.end_check()) {
            String command = System.console().readLine();
            t.execute(command);
            System.out.println(command);
        }
    }
}