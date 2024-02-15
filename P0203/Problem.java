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
    public ListNode removeElements(ListNode head, int val) {
        while (head != null && head.val == val) {
            head = head.next;
        }

        if (head == null) {
            return head;
        }

        var prev = head;
        var p = head.next;

        while (p != null) {
            if (p.val == val) {
                prev.next = p.next;
                p = p.next;
            } else {
                p = p.next;
                prev = prev.next;
            }
        }

        return head;
    }
}