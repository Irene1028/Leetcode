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
