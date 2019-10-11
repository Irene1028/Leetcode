/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        // non-empty
        // 1, deep copy the list with next pointer
        Node cur = head;
        Node newHead = new Node(head.val, null, null);
        Node newCur = newHead;
        while (cur.next != null) {
            newCur.next = new Node(cur.next.val, null, null);
            cur = cur.next;
            newCur = newCur.next;
        }
        //2, set the random pointers in the new list
        cur = head;
        newCur = newHead;
        while (cur != null) {
            // for each node in the new list
            if (cur.random == cur) {
                // a, random point to itself
                newCur.random = newCur;
            } else if (cur.random == null) {
                // b, random point to null;
                newCur.random = null;
            } else {
                // c, random point to other nodes
                Node it = head;
                Node newit = newHead;
                while (cur.random != it) {
                    it = it.next;
                    newit = newit.next;
                }
                newCur.random = newit;
            }
            cur = cur.next;
            newCur = newCur.next;
        }
        return newHead;
    }
}
