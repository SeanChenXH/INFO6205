package Assignment2;

/**
 * 725. Split Linked List in Parts
 * <p>
 * Given a (singly) linked list with head node root, write a function to split the linked list into k consecutive linked list "parts".
 * The length of each part should be as equal as possible: no two parts should have a size differing by more than1.
 * This may lead to some parts being null.
 * The parts should be in order of occurrence in the input list, and parts occurring earlier should always have a size
 * greater than or equal parts occurring later.
 * Return a List of ListNode's representing the linked list parts that are formed.
 * Examples 1->2->3->4, k = 5 // 5 equal parts [ [1], [2], [3], [4], null ]
 */
public class SplitLinkedListInParts {
    public ListNode[] splitListToParts(ListNode root, int k) {

        ListNode cur = root;

        int num = 0;

        while (cur != null) {
            num++;
            cur = cur.next;
        }

        int basicSize = num / k;
        int rem = num % k;

        cur = root;
        ListNode[] ans = new ListNode[k];

        for (int i = 0; i < k && cur != null; i++) {
            int size = basicSize;
            if (i < rem) {
                size += 1;
            }
            ListNode head = cur;
            for (int j = 0; j < size - 1; j++) {
                if (cur != null) {
                    cur = cur.next;
                }
            }
            ListNode next = cur.next;
            cur.next = null;
            cur = next;
            ans[i] = head;
        }
        return ans;
    }
}
