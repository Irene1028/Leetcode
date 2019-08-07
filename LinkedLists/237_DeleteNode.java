/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        // if given node is null
        if(node == null) return;
        // while node is not null(tail), move next value to current node
        while(node != null){
            node.val = node.next.val;
            // if it is the node before tail, set next node to null
            if(node.next.next == null) {
                node.next = null;
                break;
            }
            node = node.next;
        }
    }
}
