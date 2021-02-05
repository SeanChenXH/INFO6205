package Assignment1;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. Minimum Depth of Binary Tree
 * <p>
 * Given a binary tree, find its minimum depth.
 * The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.
 * Note: A leaf is a node with no children.
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int minDepth = 0;
        int size;
        Queue<TreeNode> queue = new LinkedList<>();

        queue.add(root);

        while (!queue.isEmpty()) {
            minDepth++;
            size = queue.size();
            while (size > 0) {
                TreeNode cur = queue.poll();
                TreeNode l = cur.left;
                TreeNode r = cur.right;

                if (l == null && r == null) {
                    return minDepth;
                } else if (l == null && r != null) {
                    queue.add(r);
                } else if (r == null && l != null) {
                    queue.add(l);
                } else {
                    queue.add(l);
                    queue.add(r);
                }
                size = size - 1;
            }
        }
        return minDepth;
    }
}
