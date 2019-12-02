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
    public List<List<Integer>> verticalOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) return ans;
        Map<Integer, List<Integer>> map = new TreeMap<>();
        Queue<Mynode> queue = new LinkedList<>();
        queue.offer(new Mynode(root, 0));
        // int d = 0;
        while (!queue.isEmpty()) {
            Mynode curNode = queue.poll();
            List<Integer> curList = map.getOrDefault(curNode.d, new ArrayList<>());
            curList.add(curNode.n.val);
            map.put(curNode.d, curList);
            if (curNode.n.left != null)
                queue.offer(new Mynode(curNode.n.left, curNode.d - 1));
            if (curNode.n.right != null)
                queue.offer(new Mynode(curNode.n.right, curNode.d + 1));
        }
        // helper(root, queue, map, 0);
        for (Integer k: map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }
    static class Mynode {
        TreeNode n;
        int d;
        Mynode(TreeNode node, int dist) {
            n = node;
            d = dist;
        }
    }
    
}
// Time = O(2^n)
// Space = O(n)
