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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (right - left == 0) {
            return head;
        }

        var p = head;
        var i = 1;

        ListNode frontLink = null;
        while (i < left && p != null) {
            if (i == left - 1) {
                frontLink = p;
            }
            p = p.next;
            i++;
        }

        if (p == null) {
            return head;
        }

        var nodes = new ArrayDeque<Integer>();
        while (i <= right && p != null) {
            nodes.push(p.val);
            p = p.next;
            i++;
        }

        ListNode prev = frontLink;
        while (!nodes.isEmpty()) {
            var n = nodes.pop();

            if (prev == null) {
                head = new ListNode(n);
                prev = head;
            } else {
                prev.next = new ListNode(n);
                prev = prev.next;
            }
        }

        if (prev != null) {
            prev.next = p;
        }

        return head;
    }
}