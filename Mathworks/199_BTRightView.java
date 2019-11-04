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
    public List<Integer> rightSideView(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<>();
        helper(root, map, 0);
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < map.size(); i++) {
            list.add(map.get(i));
        }
        return list;
    }
    public void helper(TreeNode root, Map<Integer, Integer> map, int level) {
        if (root == null) {
            return;
        }
        map.put(level, map.getOrDefault(level, root.val));
        helper(root.right, map, level + 1);
        helper(root.left, map, level + 1);
    }
}
/*
Time O(n)
Space O(n)
*/
