/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isPalindrome(ListNode head) {
        // method1, copy linked list to array and use two pointers.
        // time O(n) but space O(n)
        if(head == null || head.next == null) return true;
        ListNode fast = head, slow = head;
        while(fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;
        }
        if(fast != null){
            slow = slow.next;
        }
        slow = reverse(slow);
        //System.out.println(slow.val);
        fast = head;
        while(slow != null){
            if(fast.val != slow.val) return false;
            fast = fast.next;
            slow = slow.next;
        }
        return true;
    }
    public ListNode reverse(ListNode head){
        ListNode newNode = null;
        ListNode next = null;
        ListNode curNode = head;
        while(curNode != null){
            newNode = new ListNode(curNode.val);
            newNode.next = next;
            next = newNode;
            curNode = curNode.next;
        }
        return newNode;
    }
}
