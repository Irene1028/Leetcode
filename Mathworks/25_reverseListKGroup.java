/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || !hasEnough(head, k)) {
            return head;
        }
        ListNode prev = null, cur = head, next = null;
        int count = k;
        while(count > 0) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
            count--;
        }
        head.next = reverseKGroup(cur, k);
        return prev;
        
    }
    public boolean hasEnough(ListNode head, int k) {
        ListNode cur = head;
        int count = k;
        while (count > 0) {
            if (cur == null) {
                return false;
            }
            cur = cur.next;
            count--;
        }
        return true;
        
    }
}
