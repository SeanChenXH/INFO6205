package Assignment3;

/**
 * 1669. Merge In Between Linked Lists
 * <p>
 * You are given two linked lists: list1 and list2 of sizes n and m respectively.
 * Remove list1's nodes from the ath node to the bth node, and put list2 in their place.
 * The blue edges and nodes in the following figure incidate the result:
 */
public class MergeInBetweenLinkedLists {
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {

        //initialize apoiter, bpointer
        ListNode aPointer = list1;
        ListNode bPointer = list1;

        //for() loop get the the apointer(a-1), bpointer(b+1)
        for (int i = 0; i < b + 1; i++) {
            if (i < a - 1) {
                aPointer = aPointer.next;
            }
            bPointer = bPointer.next;
        }

        //get end of the list2 pointer l2endpointer
        ListNode l2endPointer = list2;
        while (l2endPointer.next != null) {
            l2endPointer = l2endPointer.next;
        }

        //assign apointer.next to head of list2
        aPointer.next = list2;

        //assign l2endpoinger.next to the bpinter.
        l2endPointer.next = bPointer;

        //return list1
        return list1;
    }
}
