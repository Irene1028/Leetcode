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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return ans;
        stack.push(root);
        helper(ans, stack, false);
        return ans;
    }
    public void helper(List<List<Integer>> list, Stack<TreeNode> stack, boolean inOddLevel) {
        if (stack.isEmpty()) return;
        List<Integer> curLevel = new ArrayList<>();
        Stack<TreeNode> nextLevel = new Stack<>();
        if (inOddLevel) {
            // odd level, right first
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                curLevel.add(curNode.val);
                if (curNode.left != null) nextLevel.push(curNode.left);   
                if (curNode.right != null) nextLevel.push(curNode.right);
            }
            Collections.reverse(curLevel);
            list.add(curLevel);
            helper(list, nextLevel, false);
        } else {
            // even level
            while (!stack.isEmpty()) {
                TreeNode curNode = stack.pop();
                curLevel.add(curNode.val);
                if (curNode.right != null) nextLevel.push(curNode.right);
                if (curNode.left != null) nextLevel.push(curNode.left);
            }
            Collections.reverse(curLevel);
            list.add(curLevel);
            helper(list, nextLevel, true);
        }
    }
}
