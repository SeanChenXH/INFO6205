package Assignment3;

/**
 * 203. Remove Linked List Elements
 * <p>
 * Remove all elements from a linked list of integers that have value val.
 */
public class RemoveLinkedListElements {

    public ListNode removeElements(ListNode head, int val) {

        ListNode dummy = new ListNode(-1, head);

        ListNode pointer = dummy;

        while (pointer.next != null) {
            if (pointer.next.val == val) {
                pointer.next = pointer.next.next;

            } else {
                pointer = pointer.next;
            }

        }
        return dummy.next;
    }
}
