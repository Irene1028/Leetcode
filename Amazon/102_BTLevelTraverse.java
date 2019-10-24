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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(map, root);
        for (int k : map.keySet()) {
            ans.add(map.get(k));
        }
        return ans;
    }
    
    public void helper(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<SuperNode> myQueue = new LinkedList<>();
        myQueue.offer(new SuperNode(0, root));
        while (!myQueue.isEmpty()) {
            SuperNode cur = myQueue.poll();
            List<Integer> toBeAdded;
            if (map.containsKey(cur.dist)) {
                toBeAdded = map.get(cur.dist);
            } else {
                toBeAdded = new ArrayList<>();
                map.put(cur.dist, toBeAdded);
            }
            toBeAdded.add(cur.node.val);
            if (cur.node.left != null) {
               myQueue.offer(new SuperNode(cur.dist + 1, cur.node.left));
            } 
            if (cur.node.right != null) {
                myQueue.offer(new SuperNode(cur.dist + 1, cur.node.right));
            }
        }
    }
    static class SuperNode {
        int dist;
        TreeNode node;
        public SuperNode(int level, TreeNode node) {
            this.dist = level;
            this.node = node;
        }
    }
}
