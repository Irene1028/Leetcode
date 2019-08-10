/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // null list or single node
        if(headA == null || headB == null) return null;
        
        //long list
        Set<ListNode> nodeSeen = new HashSet<ListNode>();
        ListNode curNodeA = headA, curNodeB = headB;
        while(curNodeA != null){
            nodeSeen.add(curNodeA);
            curNodeA = curNodeA.next;
        }
        while(curNodeB != null){
            if(nodeSeen.contains(curNodeB)) return curNodeB;
            curNodeB = curNodeB.next;
        }
        return null;
    }
}

/* 
Two pointer solution
*/
public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    //boundary check
    if(headA == null || headB == null) return null;
    
    ListNode a = headA;
    ListNode b = headB;
    
    //if a & b have different len, then we will stop the loop after second iteration
    while( a != b){
    	//for the end of first iteration, we just reset the pointer to the head of another linkedlist
        a = a == null? headB : a.next;
        b = b == null? headA : b.next;    
    }
    
    return a;
}
