/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode cur1 = l1, cur2 = l2;
        ListNode newHead = new ListNode(0);
        ListNode curNode = newHead;
        while (cur1 != null && cur2 != null) {
            if (cur1.val < cur2.val) {
                curNode.next = cur1;
                cur1 = cur1.next;
            } else {
                curNode.next = cur2;
                cur2 = cur2.next;
            }
            curNode = curNode.next;
        }
        if (cur1 == null) {
            curNode.next = cur2;
        } else {
            curNode.next = cur1;
        }
        return newHead.next;
    }
}
