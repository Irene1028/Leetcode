/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        ListNode nextNode = null;
        ListNode nodeP = head;
        ListNode newNode = null;
        while(nodeP!=null){
            newNode = new ListNode(nodeP.val);
            newNode.next = nextNode;
            nextNode = newNode;
            nodeP = nodeP.next;
        }
        return newNode;
    }
}

/*
Time = O(n), Space = O(n)
*/

/************** In Place Solution ***************/
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode curNode = head;
        ListNode prevNode = null;
        while (curNode != null) {
            ListNode nextCur = curNode.next;
            curNode.next = prevNode;
            prevNode = curNode;
            curNode = nextCur;
        }
        return prevNode;
    }
}

/* Time = O(n), Space = O(1). */

/*************** Recursion ****************/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
/* Time = O(n), Space = O(1). */

