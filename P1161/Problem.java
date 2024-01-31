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
    public int maxLevelSum(TreeNode root) {
        var maxSum = Integer.MIN_VALUE;
        var sumToLevels = new HashMap<Integer, Integer>();

        int level = 1;
        var q = new ArrayDeque<TreeNode>();

        q.offer(root);
        int nodesOnLevel = 1;
        int levelSum = 0;
        int nextLevelNodes = 0;

        while (nodesOnLevel > 0) {
            var n = q.poll();
            nodesOnLevel--;
            levelSum += n.val;

            if (n.right != null) {
                q.offer(n.right);
                nextLevelNodes++;
            }

            if (n.left != null) {
                q.offer(n.left);
                nextLevelNodes++;
            }

            if (nodesOnLevel == 0) {
                if (levelSum >= maxSum) {
                    maxSum = levelSum;
                    var minLevel = sumToLevels.get(levelSum);
                    if (minLevel == null) {
                        sumToLevels.put(levelSum, level);
                    } else {
                        sumToLevels.put(levelSum, Math.min(level, minLevel));
                    }
                }
                level++;
                levelSum = 0;
                nodesOnLevel = nextLevelNodes;
                nextLevelNodes = 0;
            }
        }
        return sumToLevels.get(maxSum);
    }
}