/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 /* Brute Force */
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int n = lists.length;
        for (int i = 0; i < n; i++) {
            ListNode cur = lists[i];
            while (cur != null) {
                queue.offer(cur.val);
                cur = cur.next;
            }
        }
        ListNode dummy = new ListNode(0);
        ListNode curTail = dummy;
        while (!queue.isEmpty()) {
            curTail.next = new ListNode(queue.poll());
            curTail = curTail.next;
        }
        return dummy.next;
    }
}
