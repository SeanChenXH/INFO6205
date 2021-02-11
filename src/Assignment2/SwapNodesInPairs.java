package Assignment2;

/**
 * 24. Swap Nodes in Pairs
 * <p>
 * Given a linked list, swap every two adjacent nodes and return its head.
 */
public class SwapNodesInPairs {

    public ListNode swapPairs(ListNode head) {

        if (head == null) {
            return null;
        }

        ListNode p1 = head;

        if (head.next == null) {
            return head;
        }

        ListNode p2 = head.next;

        ListNode p3 = swapPairs(head.next.next);

        p1.next = p3;
        p2.next = p1;

        return p2;
    }
}
