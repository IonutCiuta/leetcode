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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        ListNode p = list1;
        ListNode insertStart = null;
        ListNode insertEnd = null;

        int i = 1;
        while (p != null) {
            if (insertStart != null && insertEnd != null) {
                break;
            }

            if (i == a) {
                insertStart = p;
            }

            if (i == b + 1) {
                insertEnd = p;
            }

            p = p.next;
            i++;
        }

        insertStart.next = list2;

        ListNode q = list2;
        while (q.next != null) {
            q = q.next;
        }

        q.next = insertEnd.next;
        return list1;
    }
}