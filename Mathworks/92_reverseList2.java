/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        ListNode cur = head;
        ListNode preStart = null, start = null, end = null;
        int index = 1;
        while (index <= n) {
            ListNode tmp = cur.next;
            if (index == m) {
                preStart = prev;
                start = cur;
            }
            if (index > m) {
                cur.next = prev;
            }
            index++;
            prev = cur;
            cur = tmp;
        }
        end = prev;
        preStart.next = end;
        start.next = cur;
        return dummy.next;
    }
}
