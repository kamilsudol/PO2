public class List {
    public Node start;
    public Node end;

    List(){
        start = null;
        end = null;
    }

    public void listAdd(String c){
        Node new_node = new Node(c);
        if(start == null) {
            start = new_node;
            end = new_node;
        }
        else{
            Node tmp = start;
            while(tmp.getNext() != null){
                tmp = tmp.getNext();
            }
            tmp.nodeAdd(new_node);
            end = new_node;
        }
    }

    public void print(){
        Node tmp = start;
        while(tmp.getNext() != null){
            System.out.println(tmp.getCommand());
            tmp = tmp.getNext();
        }
        System.out.println(tmp.getCommand());
    }

    public Node getStart(){
        return start;
    }

}
