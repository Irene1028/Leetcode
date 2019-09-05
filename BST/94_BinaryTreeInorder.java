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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> traversal = new ArrayList<>();
        helper(traversal, root);
        return traversal;
    }
    private void helper (List<Integer> traversal, TreeNode root) {
        if (root == null) return;
        if (root.left != null) {
            helper(traversal, root.left);
        }
        traversal.add(root.val);
        if (root.right != null) {
            helper(traversal, root.right);
        }
    }
}
