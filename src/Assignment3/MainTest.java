package Assignment3;

public class MainTest {

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addToHead(3);
        list.addToHead(2);
        list.addToHead(1);
        list.addToTail(4);
        list.addToTail(5);
        list.addToHead(10);
        list.print();
    }
}
