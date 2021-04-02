package Midterm;

import java.util.Stack;

public class Question2 {

    public static void main(String[] args) {
        //Test Case
        TreeNode root = new TreeNode(1);

        root.left = new TreeNode(2);
        root.right = new TreeNode(3);

        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);

        root.right.left = new TreeNode(6);
        root.right.right = new TreeNode(7);

        root.left.left.left = new TreeNode(8);
        root.left.left.right = new TreeNode(9);

        root.left.right.left = new TreeNode(10);
        root.left.right.right = new TreeNode(11);

        root.right.left.right = new TreeNode(13);
        root.right.right.left = new TreeNode(14);

        printPerimeter(root);
    }

    //Time Complexity O(n)
    //Space Complexity: O(n)
    public static void printPerimeter(TreeNode root) {
        Stack<TreeNode> stack = new Stack<>();
        System.out.printf("[");
        printPerimeter(root, 0, 0, stack);
        while (!stack.isEmpty()) {
            if (stack.size() != 1) {
                System.out.printf(stack.pop().val + ",");
            } else {
                System.out.printf(stack.pop().val + "");
            }
        }
        System.out.printf("]");
        System.out.println("");
    }

    private static void printPerimeter(TreeNode node, int left, int right, Stack<TreeNode> stack) {

        if (node != null) {
            if (node.left == null && node.right == null) {
                System.out.printf(node.val + ",");
            } else {
                if (left == 0) {
                    System.out.printf(node.val + ",");
                }
                if (right == 0 && left != 0) {
                    stack.push(node);
                }
            }
            printPerimeter(node.right, left, right + 1, stack);
            printPerimeter(node.left, left + 1, right, stack);
        }
    }
}
