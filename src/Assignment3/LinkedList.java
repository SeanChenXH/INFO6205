package Assignment3;

public class LinkedList<T> {

    Node<T> node = null;

    public LinkedList() {

    }

    public int size() {
        int size = 0;
        Node<T> cur = node;
        while (cur != null) {
            size++;
            cur = cur.next;
        }
        return size;
    }

    public void print(){
        Node<T> cur = node;
        while(cur !=null){
            System.out.printf(cur.val+"<->");
            cur = cur.next;
        }
        System.out.printf("null");
    }

    public void addToHead(T val){
        Node<T> newNode = new Node<>(val,node,null);
        node = newNode;
    }

    public void addToTail(T val){
        Node<T> cur = node;
        while(cur.next != null){
            cur = cur.next;
        }
        Node<T> newNode = new Node<>(val, null, node);
        cur.next = newNode;
    }

}
