/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubtree(TreeNode s, TreeNode t) {
        // if (s == null && t == null) {
        //     return true;
        // } else if (s == null || t == null) {
        //     return false;
        // }
        // find root;
        return isRoot(s, t);
        
    }
    private boolean equalValue(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        } else if (s == null || t == null) {
            return false;
        }
        if (s.val == t.val) {
            // subtree;
            return equalValue(s.left, t.left) && equalValue(s.right, t.right);
        }
        return false;
    }
    private boolean isRoot(TreeNode s, TreeNode t) {
        if (s == null && t == null) {
            return true;
        }
        if (s == null) {
            return false;
        }
        if (equalValue(s, t)) {
            return true;
        }
        return isRoot(s.left, t) || isRoot(s.right, t);
        
    }
}
