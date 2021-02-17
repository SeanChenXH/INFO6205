package Assignment3;

/**
 * 1474. Delete N Nodes After M Nodes of a Linked List
 * <p>
 * Given the head of a linked list and two integers m and n. Traverse the linked list and remove some nodes in the following way:
 * <p>
 * Start with the head as the current node.
 * Keep the first m nodes starting with the current node.
 * Remove the next n nodes
 * Keep repeating steps 2 and 3 until you reach the end of the list.
 * <p>
 * Return the head of the modified list after removing the mentioned nodes.
 * <p>
 * Follow up question: How can you solve this problem by modifying the list in-place?
 */
public class DeleteNNodesAfterMNodesOfALinkedList {

    public ListNode deleteNodes(ListNode head, int m, int n) {
        //Declaring curr pointer
        ListNode curr = new ListNode(-1, head);

        ListNode dummy = curr;
        //Declaring booean type for adding and deleting
        boolean bAdding = true, bDeleting = false;

        //Declaring count number for total adding and toal deleting
        int addCount = 0, delCount = 0;

        //using while loop to traverse list
        //if adding count % m == 0, which means end up adding
        //if deleting coutn % n ==0, which means end up deleting
        while (curr != null && curr.next != null) {
            if (bAdding) {
                curr = curr.next;
                addCount++;
                if (addCount % m == 0) {
                    bAdding = false;
                    bDeleting = true;
                }
                continue;
            }

            if (bDeleting) {
                curr.next = curr.next.next;
                delCount++;
                if (delCount % n == 0) {
                    bAdding = true;
                    bDeleting = false;
                }
                continue;
            }
        }

        //return head;
        return dummy.next;
    }
}
