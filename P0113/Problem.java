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
    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        var paths = new ArrayList<List<Integer>>();
        if (root == null) {
            return paths;
        }

        pathSum(root, new ArrayList<Integer>(), targetSum, paths);
        return paths;
    }

    void pathSum(TreeNode node, List<Integer> path, int targetSum, List<List<Integer>> allPaths) {
        if (node == null) return;

        path.add(node.val);
        var diff = targetSum - node.val;

        if (node.left == null && node.right == null) {
            if (diff == 0) {
                var pathCopy = new ArrayList<Integer>(path);
                allPaths.add(pathCopy);
            }
            path.remove(path.size() - 1);
            return;
        }

        pathSum(node.left, path, diff, allPaths);
        pathSum(node.right, path, diff, allPaths);
        path.remove(path.size() - 1);
    }
}