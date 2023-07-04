import java.util.ArrayDeque;

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
  public ListNode removeNthFromEnd(ListNode head, int n) {
      var stack = new ArrayDeque<ListNode>();

      var it = head;
      while (it != null) {
          stack.push(it);
          it = it.next;
      }

      ListNode target = null;
      while (n > 0) {
          target = stack.poll();
          n -= 1;
      }

      var prev = stack.poll();

      if (prev == null) {
          return head.next;
      } else {
          prev.next = target.next;
          target.next = null;
          return head;
      }
  }
}