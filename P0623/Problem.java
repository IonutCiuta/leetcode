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
    public TreeNode addOneRow(TreeNode root, int val, int depth) {
        if (depth == 1) {
            var newRoot = new TreeNode(val, root, null);
            return newRoot;
        }
        addRow(root, val, depth, 1);
        return root;
    }

    void addRow(TreeNode node, int val, int depth, int currentDepth) {
        if (currentDepth == depth - 1) {
            var left = node.left;
            node.left = new TreeNode(val, left, null);
            var right = node.right;
            node.right = new TreeNode(val, null, right);
        } else {
            var nextLevel = currentDepth + 1;
            if (node.left != null) addRow(node.left, val, depth, nextLevel);
            if (node.right != null) addRow(node.right, val, depth, nextLevel);
        }
    }
}