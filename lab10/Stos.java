public class Stos<T> {
    private Node<T> head;
    
    public Stos(){
        head = null;
    }

    public void push(T val){
        if(head == null){
            head = new Node<>(val);
        }else{
            Node<T> tmp = new Node<>(val);
            tmp.next = head;
            head = tmp;
        }
    }

    public void pop(){
        if(head!=null){
            head = head.next;
        }
    }

    public String toString(){
        Node<T> tmp = head;
        String str_stack = new String("");
        while(tmp.next!=null){
            str_stack += "{" + tmp.getVal() + "} ";
            tmp = tmp.next;
        }
        str_stack += "{" + tmp.getVal() + "} ";
        return str_stack;
    }
}