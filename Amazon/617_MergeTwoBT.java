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
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        // create a new tree
        if (t1 == null && t2 == null) return null;
        TreeNode cur;
        if (t1 == null) {
            cur = new TreeNode(t2.val);
            cur.left = mergeTrees(null, t2.left);
            cur.right = mergeTrees(null, t2.right);
        } else if (t2 == null) {
            cur = new TreeNode(t1.val);
            cur.left = mergeTrees(t1.left, null);
            cur.right = mergeTrees(t1.right, null);
        } else {
            cur = new TreeNode(t1.val + t2.val);
            cur.left = mergeTrees(t1.left, t2.left);
            cur.right = mergeTrees(t1.right, t2.right);
        }
        return cur;
    }
}
