/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 
 // time limit exceed
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        
        if(head == null) return head;
        
        head = reverse(head);
        ListNode cur = head, prev = head;
        while(n - 1 > 1){
            n--;
            cur = cur.next;
        }
        prev = cur;
        prev.next = cur.next.next;
        head = reverse(head);
        return head;
    }
    private ListNode reverse(ListNode head){
        ListNode pointer = head;
        ListNode newList = null;
        while(pointer != null){
            ListNode curNode = pointer;
            curNode.next = newList;
            newList = curNode;
        }
        return newList;
    }
}
