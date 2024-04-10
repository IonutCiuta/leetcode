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
    public boolean isPalindrome(ListNode head) {
        var deq = new ArrayDeque<Integer>();

        var p = head;
        while (p != null) {
            deq.push(p.val);
            p = p.next;
        }

        while (deq.size() > 1) {
            var left = deq.removeLast();
            var right = deq.pop();
            if (left != right) {
                return false;
            }
        }

        return true;
    }
}