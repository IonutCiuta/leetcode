import java.util.ArrayDeque;

class Solution {
  public void reorderList(ListNode head) {
      var stack = new ArrayDeque<ListNode>();

      var it = head;
      while (it != null) {
          stack.push(it);
          it = it.next;
      }

      it = head;
      while (true) {
          var top = stack.poll();
          if (it.next == top) {
              top.next = null;
              return;
          }

          if (it == top) {
              it.next = null;
              return;
          }

          var next = it.next;
          it.next = top;
          top.next = next;
          it = next;
      }
  }
}