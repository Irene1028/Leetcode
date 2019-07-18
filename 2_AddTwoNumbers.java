
//Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
 
 
 /*idea: We have three numbers to add: node1.val, node2.val, carry
 Consider carry's value in while loop will decrease run time.
 We do not have to use an extra "if" for the highest digit.*/
 
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode rtHead = new ListNode(0);
        Integer carry = 0; 
        ListNode node1 = l1;
        ListNode node2 = l2;
        ListNode ans = rtHead;
        
        while(node1 != null || node2 != null || carry != 0){
            int newValue = 0;
            int x = (node1==null)? 0: node1.val;
            int y = (node2==null)? 0: node2.val;
            newValue = x + y + carry;
            ans.next = new ListNode(newValue%10);
            carry = newValue/10;      
            if(node1 != null) node1 = node1.next;
            if(node2 != null) node2 = node2.next;
            ans = ans.next;
        }
        
        return rtHead.next;
    }
}
