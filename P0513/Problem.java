/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    class LeftMostValue {
        int val;
        int level;

        LeftMostValue(int rootval) {
            this.val = rootval;
            this.level = 0;
        }
    }

    public int findBottomLeftValue(TreeNode root) {
        var leftMostValue = new LeftMostValue(root.val);
        leftmost(root, leftMostValue, 0);
        return leftMostValue.val;
    }

    void leftmost(TreeNode node, LeftMostValue leftMostValue, int level) {
        if (node == null) {
            return;
        }

        leftmost(node.left, leftMostValue, level + 1);
        leftmost(node.right, leftMostValue, level + 1);

        if (level > leftMostValue.level) {
            leftMostValue.level = level;
            leftMostValue.val = node.val;
        }
    }
}