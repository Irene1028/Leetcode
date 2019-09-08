/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// CONSIDER NEGATIVE NUM
class Solution {
    public boolean hasPathSum(TreeNode root, int sum) {
        return helper(root, sum, 0);
    }
    private boolean helper(TreeNode root, int sum, int curSum) {
        if (root == null) {
            return false;
        }
        curSum += root.val;
        // if (curSum > sum) {
        //     return false;
        // }
        if (root.left == null && root.right == null && curSum == sum) {
            return true;
        }
        return helper(root.left, sum, curSum) || helper(root.right, sum, curSum);
    }
}
