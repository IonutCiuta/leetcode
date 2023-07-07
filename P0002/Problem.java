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
  public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
      ListNode r = new ListNode(0);
      ListNode a = l1;
      ListNode b = l2;
      ListNode i = r;
      boolean carryover = false;

      while (a != null && b != null) {
          var sum = a.val + b.val + (carryover ? 1 : 0);
          var val = sum % 10;
          carryover = sum > 9;
          
          i.next = new ListNode(val);
          i = i.next;
          a = a.next;
          b = b.next;
      }

      while (a != null) {
          var sum = a.val + (carryover ? 1 : 0);
          var val = sum % 10;
          carryover = sum > 9;
          
          i.next = new ListNode(val);
          i = i.next;
          a = a.next;
      }

       while (b != null) {
          var sum = b.val + (carryover ? 1 : 0);
          var val = sum % 10;
          carryover = sum > 9;
          
          i.next = new ListNode(val);
          i = i.next;
          b = b.next;
      }

      if (carryover) {
          i.next = new ListNode(1);
          carryover = false;
      }

      return r.next;
  }
}