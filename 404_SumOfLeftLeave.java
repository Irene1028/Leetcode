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
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null && root.right == null) {
            // right leave
            return 0;
        }
        if (root.left == null) {
            return sumOfLeftLeaves(root.right); 
        }
        int left = 0;
        int right = 0;
        if (root.left.left == null && root.left.right == null) {
            left = root.left.val;
        } else {
            left = sumOfLeftLeaves(root.left);
        }
        if (root.right == null) {
            right = 0;
        } else {
            right = sumOfLeftLeaves(root.right);
        }
        
        return left + right;
    }
}
