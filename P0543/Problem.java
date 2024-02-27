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
    class Holder {
        int val = 0;
    }

    public int diameterOfBinaryTree(TreeNode root) {
        var h = new Holder();
        var r = d(root, h);

        // I'm counting nodes (N) so the number of paths is N - 1
        return Math.max(r, h.val) - 1;
    }

    int d(TreeNode n, Holder holder) {
        if (n.left == null && n.right == null) {
            return 1;
        }

        var lenLeft = 0;
        if (n.left != null) lenLeft = d(n.left, holder);

        var lenRight = 0;
        if (n.right != null) lenRight = d(n.right, holder);

        int nodeMax = 1 + lenLeft + lenRight;
        holder.val = Math.max(nodeMax, holder.val);

        return 1 + Math.max(lenLeft, lenRight);
    }
}