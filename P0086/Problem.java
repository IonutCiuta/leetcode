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
    public ListNode partition(ListNode head, int x) {
        ListNode lowSubListHead = null;
        ListNode lowSubListIt = null;

        ListNode highSubListHead = null;
        ListNode highSubListIt = null;

        ListNode p = head;
        while (p != null) {
            if (p.val < x) {
                if (lowSubListHead == null) {
                    lowSubListHead = new ListNode(p.val);
                    lowSubListIt = lowSubListHead;
                } else {
                    lowSubListIt.next = new ListNode(p.val);
                    lowSubListIt = lowSubListIt.next;
                }
            } else {
                if (highSubListHead == null) {
                    highSubListHead = new ListNode(p.val);
                    highSubListIt = highSubListHead;
                } else {
                    highSubListIt.next = new ListNode(p.val);
                    highSubListIt = highSubListIt.next;
                }
            }
            p = p.next;
        }

        highSubListIt = null;
        if (lowSubListHead != null) {
            lowSubListIt.next = highSubListHead;
            return lowSubListHead;
        } else {
            return highSubListHead;
        }
    }
}