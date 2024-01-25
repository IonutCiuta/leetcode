**
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
    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        var leaves1 = new ArrayList<Integer>();
        getLeaves(root1, leaves1);

        var leaves2 = new ArrayList<Integer>();
        getLeaves(root2, leaves2);

        return leaves1.equals(leaves2);
    }

    void getLeaves(TreeNode root, List<Integer> leaves) {
        var left = root.left;
        var right = root.right;
        if (left == null && right == null) {
            leaves.add(root.val);
            return;
        }

        if (left != null) {
            getLeaves(left, leaves);
        }

        if (right != null) {
            getLeaves(right, leaves);
        }
    }
}