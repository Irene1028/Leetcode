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
    public int countNodes(TreeNode root) {
        int leftNodes = 0, rightNodes = 0;
        if (root == null) return 0;
        leftNodes = countNodes(root.left);
        rightNodes = countNodes(root.right);      
        return leftNodes + rightNodes + 1;
    }
}
