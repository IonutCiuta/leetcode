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
    public List<Double> averageOfLevels(TreeNode root) {
        var current = new ArrayDeque<TreeNode>();
        current.add(root);
        var averages = new ArrayList<Double>();
        average(current, new ArrayDeque<TreeNode>(), averages);
        return averages;
    }

    void average(Queue<TreeNode> current, Queue<TreeNode> next, List<Double> averages) {
        double sum = 0;
        int count = 0;

        while (!current.isEmpty()) {
            var node = current.poll();
            count++;
            sum += node.val;
            if (node.left != null) next.add(node.left);
            if (node.right != null) next.add(node.right);
        }

        if (count != 0) {
            averages.add(sum / count);
            average(next, current, averages);
        }
    }
}