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
    int getNodes = 0;
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode ans_left = null, ans_right = null;
        //
        if (root.left != null) {
            ans_left = lowestCommonAncestor(root.left, p, q);
        }
        if (root.right != null) {
            ans_right = lowestCommonAncestor(root.right, p, q);
        }
        if (root.val == p.val || root.val == q.val) {
            getNodes++;
            return root;
        }
        if (ans_left != null && ans_right != null) {
            return root;
        }
        if (getNodes == 2) {
            if (ans_left != null) {
                return ans_left;
            }
            if (ans_right != null) {
                return ans_right;
            }
        }   
        else if (getNodes == 1)
            return root;
        return null;
    }
}
