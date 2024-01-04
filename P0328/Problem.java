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
    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode oddHead = null;
        ListNode oddIt = null;
        ListNode evenHead = null;
        ListNode evenIt = null;

        int i = 1;
        while (head != null) {
            if (i % 2 == 0) {
                if (evenHead == null) {
                    evenHead = head;
                    evenIt = evenHead;
                } else {
                    evenIt.next = head;
                    evenIt = evenIt.next;
                }
            } else {
                if (oddHead == null) {
                    oddHead = head;
                    oddIt = oddHead;
                } else {
                    oddIt.next = head;
                    oddIt = oddIt.next;
                }
            }
            i += 1;
            head = head.next;
        }

        oddIt.next = evenHead;
        evenIt.next = null;
        return oddHead;
    }
}