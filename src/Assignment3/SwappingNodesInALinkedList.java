package Assignment3;

/**
 * 1721. Swapping Nodes in a Linked List
 * <p>
 * You are given the head of a linked list, and an integer k.
 * Return the head of the linked list after swapping the values of the
 * kth node from the beginning and the kth node from the end (the list is 1-indexed).
 */
public class SwappingNodesInALinkedList {

    public ListNode swapNodes(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        //Initialize aPrePointer, aPointer, bPrePointer, bPointer corresponding
        //to the Kth node and kth node from the end
        ListNode pre = new ListNode(-1, head);
        ListNode aPrePointer = pre, aPointer = null, bPrePointer = pre, bPointer = null;

        //get length of the head;
        int length = 0;
        ListNode cur = head;
        while (cur != null) {
            length++;
            cur = cur.next;
        }

        //get the index of kth node and kth node from the end
        int indexFroK = k - 1, indexEndK = length - k;

        //for() loop to get the position of aPrePonter, aPointer, bPrePointer, bPointer
        for (int i = 0; i < length; i++) {
            if (i < indexFroK) {
                aPrePointer = aPrePointer.next;
            }

            if (i < indexEndK) {
                bPrePointer = bPrePointer.next;
            }
        }

        aPointer = aPrePointer.next;
        bPointer = bPrePointer.next;

        //assign aPrePointer.next to bPointer
        aPrePointer.next = bPointer;

        //assign bPrePointer.next to aPointer
        bPrePointer.next = aPointer;

        //give temp to store bPointer.next
        ListNode temp = bPointer.next;

        //assign bPointer.next to aPointer.next,
        bPointer.next = aPointer.next;

        //assign aPointer.next to temp
        aPointer.next = temp;

        return pre.next;


    }
}
