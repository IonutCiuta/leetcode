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
    public int maxDepth(TreeNode root) {
        return deeper(root, 0);
    }

    int deeper(TreeNode node, int depth) {
        if (node == null) {
            return depth;
        }
        return Math.max(
                deeper(node.left, depth + 1),
                deeper(node.right, depth + 1)
        );
    }
}