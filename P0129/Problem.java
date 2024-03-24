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
    int sum = 0;

    public int sumNumbers(TreeNode root) {
        var sb = new StringBuilder();
        sum(root, sb);
        return sum;
    }

    void sum(TreeNode node, StringBuilder sb) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            sb.append(node.val);
            sum += Integer.parseInt(sb.toString());
            // undo add of leaf node value
            sb.setLength(Math.max(sb.length() - 1, 0));
            return;
        }

        sb.append(node.val);
        sum(node.left, sb);
        sum(node.right, sb);
        // undo add of current node after exploration
        sb.setLength(Math.max(sb.length() - 1, 0));
    }
}