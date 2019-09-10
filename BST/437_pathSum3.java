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
    public int pathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int rootSum = rootPathSum(root, sum);
        int leftPathSum = pathSum(root.left, sum);
        int rightPathSum = pathSum(root.right, sum);
        return rootSum + leftPathSum + rightPathSum;
    }
    
    private int rootPathSum(TreeNode root, int sum) {
        if (root == null) {
            return 0;
        }
        int isMe = (root.val == sum) ? 1: 0;
        int leftSum = rootPathSum(root.left, sum - root.val);
        int rightSum = rootPathSum(root.right, sum - root.val);
        return isMe + leftSum + rightSum;
    }
}
