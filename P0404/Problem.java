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
    public int sumOfLeftLeaves(TreeNode root) {
        return sum(root);
    }

    public int sum(TreeNode node) {
        if (node == null) {
            return 0;
        }

        if (node.left != null && node.left.right == null && node.left.left == null) {
            return node.left.val + sum(node.right);
        }

        return sum(node.right) + sum(node.left);
    }
}