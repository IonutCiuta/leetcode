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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        var levels = new ArrayList<List<Integer>>();
        var current = new ArrayDeque<TreeNode>();
        current.add(root);
        getLevels(current, new ArrayDeque<TreeNode>(), levels);
        return levelsa;
    }

    void getLevels(ArrayDeque<TreeNode> current, ArrayDeque<TreeNode> next, List<List<Integer>> levels) {
        var nodesOnLevel = new ArrayList<Integer>();

        while (!current.isEmpty()) {
            var node = current.pop();
            nodesOnLevel.add(node.val);
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
        }

        if (!nodesOnLevel.isEmpty()) {
            levels.add(nodesOnLevel);
            getLevels(next, current, levels);
        }
    }
}
