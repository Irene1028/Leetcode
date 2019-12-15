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
    public int kthSmallest(TreeNode root, int k) {
        // inorder traverse, return k th
        List<Integer> inorder = new ArrayList<>();
        addInorder(root, inorder);
        if (inorder.size() == 0) {
            return 0;
        }
        return inorder.get(k-1);
    }
    private void addInorder(TreeNode root, List<Integer> inorder) {
        if (root == null) return;
        addInorder(root.left, inorder);
        inorder.add(root.val);
        addInorder(root.right, inorder);
        return;
    }
}
// Time O(n), n is nodes number, we traverse every node.
// Space, O(n), n is size of inorder
