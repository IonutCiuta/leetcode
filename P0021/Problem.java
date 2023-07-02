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
  public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
      if (l1 == null) return l2;
      if (l2 == null) return l1;
      
      // curr1 should track list with smaller leading elem
      ListNode curr1, curr2;
      if (l1.val <= l2.val) {
          curr1 = l1;
          curr2 = l2;
      } else {
          curr1 = l2;
          curr2 = l1;
      }

      // start is the anchor for the resulting list
      // head is the iterator
      ListNode start = new ListNode(0);
      ListNode head = start;

      while(curr1 != null && curr2 != null) {
          // Add both cells if vals are equal
          if (curr1.val == curr2.val) {
              // Add first cell
              head.next = curr1;
              curr1 = curr1.next;
              
              // Move head
              head = head.next;

              // Add second cell
              head.next = curr2;
              curr2 = curr2.next;
              
              // Move head
              head = head.next;
              continue;
          }

          // Add smaller cell
          if (curr1.val < curr2.val) {
              head.next = curr1;
              curr1 = curr1.next;
          } else {
              head.next = curr2;
              curr2 = curr2.next;
          }

          // Move head
          head = head.next;
      }

      // Add remaining if any
      if (curr1 != null) {
          head.next = curr1;
      } else {
          head.next = curr2;
      }

      // Start is just an anchor
      return start.next;
  }
}