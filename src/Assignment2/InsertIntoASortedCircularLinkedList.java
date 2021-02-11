package Assignment2;

/**
 * 708 Insert into a Sorted Circular Linked List
 * <p>
 * Given a node from a Circular Linked List which is sorted in ascending order,
 * write a function to insert a value insertVal into the list such that it remains
 * a sorted circular list. The given node can be a reference to any single node in
 * the list, and may not be necessarily the smallest value in the circular list.
 * <p>
 * If there are multiple suitable places for insertion, you may choose any place to
 * insert the new value. After the insertion, the circular list should remain sorted.
 * <p>
 * If the list is empty (i.e., given node is null), you should create a new single
 * circular list and return the reference to that single node. Otherwise, you should
 * return the original given node.
 */
public class InsertIntoASortedCircularLinkedList {

    public Node insert(Node head, int insertVal) {

        if (head == null) {
            Node newNode = new Node(insertVal);
            newNode.next = newNode;
            return newNode;
        }

        if (head.next == head) {
            Node newNode = new Node(insertVal, head);
            head.next = newNode;
            return head;
        }

        Node p1 = head;
        Node p2 = head.next;
        boolean toInsert = false;

        do {
            if (insertVal >= p1.val && insertVal <= p2.val) {
                toInsert = true;
            }

            if (p1.val > p2.val) {
                if (insertVal >= p1.val || insertVal <= p2.val) {
                    toInsert = true;
                }
            }

            if (toInsert) {
                Node node = new Node(insertVal);
                p1.next = node;
                node.next = p2;
                return head;
            }

            p1 = p1.next;
            p2 = p2.next;

        } while (p1 != head);

        p1.next = new Node(insertVal, p2);
        return head;
    }

}
