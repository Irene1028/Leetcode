/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // single node or null list
        if(head == null || head.next == null) return false;
        
        // long list
        Set<ListNode> nodeSet = new HashSet<>();
        ListNode curNode = head;
        while(curNode!= null){
            if(nodeSet.contains(curNode)) return true;
            else{
                nodeSet.add(curNode);
                curNode = curNode.next;
            }
        }
        return false;
    }
}

// a O(1) space complexity solution

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        // single node or null list
        if(head == null || head.next == null) return false;
        
        // long list
        ListNode slow = head, fast = head.next;
        while(slow != fast){
            if(fast == null || fast.next == null) return false;
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }
}
