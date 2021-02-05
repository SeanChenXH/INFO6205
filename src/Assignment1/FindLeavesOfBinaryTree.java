package Assignment1;

import java.util.ArrayList;
import java.util.List;

/**
 * 366. Find Leaves of Binary Tree
 * Given a binary tree, collect a tree's nodes as if you were doing this: Collect and remove all leaves,
 * repeat until the tree is empty
 */
public class FindLeavesOfBinaryTree {
    public List<List<Integer>> findLeaves(TreeNode root) {
        List<List<Integer>> list = new ArrayList<>();
        getHeight(root, list);
        return list;
    }

    public int getHeight(TreeNode node, List<List<Integer>> list) {
        if (node == null) {
            return -1;
        }

        int lHeight = getHeight(node.left, list);
        int rHeight = getHeight(node.right, list);

        int curHeight = 1 + Math.max(lHeight, rHeight);

        if (curHeight == list.size()) {
            list.add(curHeight, new ArrayList<Integer>());
        }

        list.get(curHeight).add(node.val);

        return curHeight;
    }
}
