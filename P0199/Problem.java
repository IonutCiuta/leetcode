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
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) {
            return List.of();
        }

        var r = new ArrayList<Integer>();
        var q = new ArrayDeque<TreeNode>();

        q.offer(root);
        int n = 1;

        while (!q.isEmpty()) {
            int i = 0;
            int newNodes = 0;
            while (i < n) {
                var node = q.poll();
                if (i == 0) r.add(node.val);

                if(node.right != null) {
                    q.offer(node.right);
                    newNodes++;
                }

                if(node.left != null) {
                    q.offer(node.left);
                    newNodes++;
                }
                i++;
            }
            n = newNodes;
        }

        return r;
    }
}