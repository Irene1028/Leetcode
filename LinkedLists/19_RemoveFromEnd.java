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

/* Brute Force, two pass solution */
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        int len = 0;
        ListNode pointer = head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        while(pointer != null){
            len++;
            pointer = pointer.next;
        }
        pointer = dummy;
        int count = len - n;
        System.out.println(count);
        while(count > 0){
            pointer = pointer.next;
            count--;
        }
        // System.out.println(count);
        pointer.next = pointer.next.next;
        return dummy.next;
    }
    
}

/* Two Pointer Solution fast solution */

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null || head.next == null) return null;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode slow = dummy, fast = dummy;
        
        while(n > 0){
            fast = fast.next;
            n--;
        }
        
        while(fast.next != null){
            fast = fast.next;
            slow = slow.next;
        }
        // System.out.println(count);
        slow.next = slow.next.next;
        return dummy.next;
    }
    
}
