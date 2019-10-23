/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        // idea: dfs
        // each node:
        // cur.left.next == cur.right;
        helper(root);
        return root;
        
    }
    
    public void helper(Node cur) {
        // null nodes
        if (cur == null) {
            return;
        }
        // leaf nodes
        if (cur.left == null && cur.right == null) {
            return;
        }
        Node toBeNexted;
        if (cur.left != null && cur.right != null) {
            cur.left.next = cur.right;
            toBeNexted = cur.right;
        } else if (cur.left == null) {
            toBeNexted = cur.right;
        } else {
            toBeNexted = cur.left;
        }
        if (cur.next != null) {
            Node target = cur;
            while (target.next.left == null && target.next.right == null && target.next.next != null) {
                target = target.next;
            }
            if (target.next.left != null) {
                toBeNexted.next = target.next.left;
            } else if (target.next.right != null) {
                toBeNexted.next = target.next.right;
            } else {
                toBeNexted.next = null;
            }
        }
        helper(cur.right);
        helper(cur.left);
    }
}
