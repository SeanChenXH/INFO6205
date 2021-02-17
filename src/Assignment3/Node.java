package Assignment3;

public class Node<T> {
    T val;
    Node<T> next;
    Node<T> prev;

    public Node() {

    }

    public Node(T val, Node<T> next, Node<T> prev) {
        this.val = val;
        this.next = next;
        this.prev = prev;
    }
}
