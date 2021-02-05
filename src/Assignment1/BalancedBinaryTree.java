package Assignment1;

/**
 * 110. Balanced Binary Tree
 * <p>
 * Given a binary tree, determine if it is height-balanced.
 * For this problem, a height-balanced binary tree is defined as:
 * a binary tree in which the left and right subtrees of every node differ in height by no more than 1.
 */
public class BalancedBinaryTree {

    public boolean balanced = true;

    public boolean isBalanced(TreeNode root) {
        getHeight(root);
        return balanced;
    }

    public int getHeight(TreeNode node) {

        if (node == null) {
            return 0;
        }

        int lHeight = getHeight(node.left);
        int rHeight = getHeight(node.right);

        if (Math.abs(lHeight - rHeight) > 1) {
            balanced = false;
        }

        return 1 + Math.max(lHeight, rHeight);
    }

}






