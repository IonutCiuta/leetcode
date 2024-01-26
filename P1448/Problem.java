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
    public int goodNodes(TreeNode root) {
        return goodNodes(root, Integer.MIN_VALUE);
    }

    int goodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }

        var score = 0;
        if (node.val >= max) {
            score = 1;
            max = node.val;
        }

        return score + goodNodes(node.left, max) + goodNodes(node.right, max);
    }
}