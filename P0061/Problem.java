/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (k == 0 || head == null) {
            return head;
        }

        var nodesList = new ArrayList<ListNode>();

        var p = head;
        while (p != null) {
            nodesList.add(p);
            p = p.next;
        }

        var n = nodesList.size();
        var rot = k % n;
        System.out.println("Rot: " + rot);

        if (rot == 0 || n == 1) {
            return head;
        }

        var tailEnd = nodesList.get(n - 1);
        var tailStart = nodesList.get(n - rot);
        var newTail = nodesList.get(n - rot - 1);

        tailEnd.next = head;
        newTail.next = null;
        return tailStart;
    }
}