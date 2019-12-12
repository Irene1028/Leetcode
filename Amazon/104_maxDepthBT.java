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
    public int maxDepth(TreeNode root) {
        // BFS traverse the tree and use a map and a queue
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Integer> map = new HashMap<>();
        int maxDepth = 1;
        queue.offer(root);
        map.put(root, 1);
        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur.left != null) {
                queue.offer(cur.left);
                map.put(cur.left, map.get(cur) + 1);
                maxDepth = map.get(cur.left);
            }
            if (cur.right != null) {
                queue.offer(cur.right);
                map.put(cur.right, map.get(cur) + 1);
                maxDepth = map.get(cur.right);
            }
        }
        return maxDepth;
    }
}

// Time: O(n), we only reach each node once and only once.
// Space: O(n)

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
    public int maxDepth(TreeNode root) {
        // DFS
        if (root == null) return 0;
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);
        return Math.max(leftMax, rightMax) + 1;
    }
}

// Time 100% beated
// Space O(n) in worst case, every node has only left
//       O(logN) in best case, balanced tree, every node has left and right. recursion happened height times.
