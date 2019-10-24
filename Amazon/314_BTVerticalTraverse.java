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
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(map, root);
        for (int key: map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
    
    
    public void helper(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) {
            return;
        }
        Queue<SuperNode> myQueue = new ArrayDeque<>();
        myQueue.offer(new SuperNode(root, 0));
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
                myQueue.offer(new SuperNode(cur.node.left, cur.dist - 1));
            }
            if (cur.node.right != null) {
                myQueue.offer(new SuperNode(cur.node.right, cur.dist + 1));
            }
        }
    }
    
    static class SuperNode {
        TreeNode node;
        int dist;
        public SuperNode(TreeNode node, int dist) {
            this.node = node;
            this.dist = dist;
        }
    }
}
