/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 
 // my solution
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = new ListNode(0);
        ListNode node1 = l1, node2 = l2, curNode = head;
        while(node1 != null && node2 != null){
            if(node1.val < node2.val){
                curNode.next = new ListNode(node1.val);
                node1 = node1.next;
            }
            else{
                curNode.next = new ListNode(node2.val);
                node2 = node2.next;
            }
            curNode = curNode.next;
        }
        if(node1 != null){
            curNode.next = node1;
        }
        else{
            curNode.next = node2;
        }
        return head.next;
    }
}

// a recursive solution
public ListNode mergeTwoLists(ListNode l1, ListNode l2){
		if(l1 == null) return l2;
		if(l2 == null) return l1;
		if(l1.val < l2.val){
			l1.next = mergeTwoLists(l1.next, l2);
			return l1;
		} else{
			l2.next = mergeTwoLists(l1, l2.next);
			return l2;
		}
}
