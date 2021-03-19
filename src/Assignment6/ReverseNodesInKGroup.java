package Assignment6;

/**
 * 25. Reverse Nodes in k-Group
 * <p>
 * Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.
 * <p>
 * k is a positive integer and is less than or equal to the length of the linked list. If the number of
 * nodes is not a multiple of k then left-out nodes, in the end, should remain as it is.
 */
public class ReverseNodesInKGroup {
    public ListNode reverseKGroup(ListNode head, int k) {
        int count = 0;
        ListNode pointer = head;

        while (count < k && pointer != null) {
            pointer = pointer.next;
            count++;
        }

        if (count == k) {
            ListNode newhead = reverseList(head, k);
            head.next = reverseKGroup(pointer, k);
            return newhead;
        }

        return head;
    }

    public ListNode reverseList(ListNode head, int k) {

        ListNode newNode = null;
        ListNode pointer = head;

        while (k > 0) {
            ListNode temp = pointer.next;
            pointer.next = newNode;
            newNode = pointer;
            pointer = temp;
            k--;
        }
        return newNode;
    }
}
