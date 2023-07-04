import java.util.HashSet;

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
class Solution {
  public boolean hasCycle(ListNode head) {
      var visited = new HashSet<ListNode>();
      
      var it = head;
      while (it != null) {
          if (visited.contains(it)) {
              return true;
          }
          visited.add(it);
          it = it.next;
      }

      return false;
  }
}