public class Node<T> {
    private T val;
    public Node<T> next;

    public Node(T v){
        val = v;
        next = null;
    }

    T getVal(){
        return val;
    }
}