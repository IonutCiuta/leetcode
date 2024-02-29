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
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode resultHead = null;
        ListNode resultPointer = null;

        int fullyExploredLists = 0;
        while (fullyExploredLists != lists.length) {
            fullyExploredLists = 0;
            int minValue = 10_000;
            int minNodeList = -1;
            ListNode minNode = null;

            for (int i = 0; i < lists.length; i++) {
                var list = lists[i];
                if (list == null) {
                    fullyExploredLists++;
                } else {
                    if (list.val <= minValue) {
                        minValue = list.val;
                        minNodeList = i;
                        minNode = list;
                    }
                }
            }

            if (minNode != null) {
                if (resultHead == null) {
                    resultHead = minNode;
                    lists[minNodeList] = lists[minNodeList].next;
                    resultHead.next = null;
                    resultPointer = resultHead;
                } else {
                    resultPointer.next = minNode;
                    lists[minNodeList] = lists[minNodeList].next;
                    resultPointer = resultPointer.next;
                    resultPointer.next = null;
                }
            }
        }

        return resultHead;
    }
}