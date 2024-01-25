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
    public int pairSum(ListNode head) {
        var nodes = new ArrayList<Integer>();

        var p = head;
        while (p != null) {
            nodes.add(p.val);
            p = p.next;
        }

        int max = 0;
        int i = 0;
        int j = nodes.size() - 1;
        while (i < j) {
            int sum = nodes.get(i) + nodes.get(j);
            max = max > sum ? max : sum;
            i++;
            j--;
        }

        return max;
    }
}