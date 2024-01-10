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
    public ListNode deleteMiddle(ListNode head) {
        if (head.next == null) return null;
        var i = head;
        var j = head.next.next;
        while (j != null && j.next != null) {
            i = i.next;
            j = j.next.next;
        }
        var mid = i.next;
        i.next = mid.next;
        mid.next = null;
        return head;
    }
}