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
    public boolean isEvenOddTree(TreeNode root) {
        var currentLevel = new ArrayDeque<TreeNode>();
        var nextLevel = new ArrayDeque<TreeNode>();

        currentLevel.add(root);
        int level = 0;

        while (true) {
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;
            nextLevel = new ArrayDeque<TreeNode>();

            while (!currentLevel.isEmpty()) {
                var node = currentLevel.poll();
                var evenLevel = (level % 2 == 0);
                var evenValue = (node.val % 2 == 0);

                if (evenLevel) {
                    if (evenValue || node.val <= max) return false;
                    max = node.val;
                } else {
                    if (!evenValue || node.val >= min) return false;
                    min = node.val;
                }

                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
            }

            if (nextLevel.isEmpty()) break;

            currentLevel = nextLevel;
            level++;
        }

        return true;
    }
}