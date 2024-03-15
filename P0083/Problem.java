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
    public ListNode deleteDuplicates(ListNode head) {
        var p = head;

        while (p != null) {
            var n = p.next;
            while (n != null && p.val == n.val) {
                n = n.next;
            }
            if (n != p.next) {
                p.next = n;
            }
            p = p.next;
        }

        return head;
    }
}