package Midterm;

import java.util.HashSet;

public class Question1 {

    public static void main(String[] args) {
        //Test Case 1: No converging
        //n1: 1 -> 2 -> 3
        ListNode n1 = new ListNode(1);
        n1.next = new ListNode(2);
        n1.next.next = new ListNode(3);
        //n2: 4 -> 2 -> 1
        ListNode n2 = new ListNode(4);
        n2.next = new ListNode(2);
        n2.next.next = new ListNode(1);

        boolean test1 = areConverging(n1, n2);
        System.out.println("Test Case 1: " + test1); //false


        //Test Case 2: Converging
        //m2: 3 -> 4 -> 2 -> 1
        ListNode m2 = new ListNode(3);
        m2.next = new ListNode(4);
        m2.next.next = new ListNode(2);
        m2.next.next.next = new ListNode(1);
        //m1: 1 -> 2 -> 4 -> 2 -> 1
        ListNode m1 = new ListNode(1);
        m1.next = new ListNode(2);
        m1.next.next = m2.next;

        boolean test2 = areConverging(m1, m2);
        System.out.println("Test Case 2: " + test2); // true

        //Test Case 3: Edge cases
        //j1: 1 -> 2 -> 3
        ListNode j1 = new ListNode(1);
        j1.next = new ListNode(2);
        j1.next.next = new ListNode(3);
        //j2: null
        ListNode j2 = null;

        boolean test3 = areConverging(j1, j2);
        System.out.println("Test Case 3: " + test3); // false


    }

    //Time Complexity: O(n)
    //Space Complexity: O(n)
    public static boolean areConverging(ListNode n1, ListNode n2) {
        if (n1 == null || n1 == null) {
            return false;
        }

        ListNode l1 = n1;
        ListNode l2 = n2;
        HashSet<ListNode> set = new HashSet<>();

        while (l1 != null) {
            set.add(l1);
            l1 = l1.next;
        }

        while (l2 != null) {
            if (set.contains(l2)) {
                return true;
            } else {
                l2 = l2.next;
            }
        }

        return false;
    }
}
