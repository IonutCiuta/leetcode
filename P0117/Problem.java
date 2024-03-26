/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

class Solution {
    public Node connect(Node root) {
        if (root == null) {
            return root;
        }

        var q = new ArrayDeque<Node>();
        q.add(root);
        var nodesToConnect = 1;

        while(!q.isEmpty()) {
            int nextRoundNodes = 0;
            Node prev = null;
            while (nodesToConnect > 0) {
                var curr = q.poll();
                curr.next = prev;
                prev = curr;
                if (curr.right != null) {
                    q.add(curr.right);
                    nextRoundNodes++;
                }
                if (curr.left != null) {
                    q.add(curr.left);
                    nextRoundNodes++;
                }
                nodesToConnect--;
            }
            nodesToConnect = nextRoundNodes;
        }

        return root;
    }
}