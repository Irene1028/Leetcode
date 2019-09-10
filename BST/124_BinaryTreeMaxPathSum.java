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
    int max = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        int toRootMax = toRootMaxSum(root);
        return max;
    }
    private int toRootMaxSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftMaxSum = toRootMaxSum(root.left);
        int rightMaxSum = toRootMaxSum(root.right);
        int curSum;
        if (leftMaxSum <= 0 && rightMaxSum <= 0) {
            curSum = root.val;
        }
        else if (leftMaxSum <= 0) {
            curSum = root.val + rightMaxSum;
        }
        else if (rightMaxSum <= 0) {
            curSum = root.val + leftMaxSum;
        }
        else {
            curSum = root.val + leftMaxSum + rightMaxSum;
        }
        if (curSum > max) {
            max = curSum;
        }
        return (leftMaxSum < 0 && rightMaxSum < 0) ? root.val: Math.max(leftMaxSum, rightMaxSum) + root.val; 
    }
}
