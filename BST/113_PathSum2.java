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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();
        helper(root, sum, 0, result, cur);
        return result;
        
    }
    private void helper(TreeNode root, int sum, int curSum, List<List<Integer>> result, List<Integer> cur) {
        if (root == null) {
            return;
        }
        curSum += root.val;
        cur.add(root.val);
        if (root.left == null && root.right == null && curSum == sum) {
            result.add(new ArrayList<>(cur));
            cur.remove(cur.size() - 1);
            return;
        }
        helper(root.left, sum, curSum, result, cur);
        helper(root.right, sum, curSum, result, cur);
        cur.remove(cur.size() - 1);
        return;
    }
}
