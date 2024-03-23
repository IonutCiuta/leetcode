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
    public void reorderList(ListNode head) {
        var nodes = new Stack<ListNode>();

        var p = head;
        var len = 0;
        while (p != null) {
            nodes.push(p);
            p = p.next;
            len++;
        }

        var mid = len / 2;
        p = head;

        var i = 0;
        while (i < mid) {
            var next = nodes.pop();

            var copyOfNext = p.next;
            p.next = next;
            next.next = copyOfNext;
            p = copyOfNext;

            i++;
        }

        p.next = null;
    }
}