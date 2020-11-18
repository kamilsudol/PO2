public class Node {
    public Node prev;
    public Node next;
    public String command;

    public Node(String c){
        prev = null;
        command = c;
        next = null;
    }

    public Node getPrev(){
        return prev;
    }

    public Node getNext() {
        return next;
    }

    public String getCommand(){
        return command;
    }

    public void nodeAdd(Node A){
        next = A;
        A.prev = this;
    }
}
