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
    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return 1 + goDown(root);
    }

    int goDown(TreeNode node) {
        if (node.left == null && node.right == null) {
            return 0;
        }

        var left = node.left == null ? Integer.MAX_VALUE : goDown(node.left);
        var right = node.right == null ? Integer.MAX_VALUE : goDown(node.right);

        return 1 + Math.min(left, right);
    }
}