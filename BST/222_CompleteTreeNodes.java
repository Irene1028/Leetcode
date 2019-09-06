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

// Time O(n)

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
        if (root == null) return 0;
        int left_height = 1, right_height = 1;
        TreeNode cur = root;
        while (cur.left != null) {
            left_height++;
            cur = cur.left;
        }
        cur = root;
        while (cur.right != null) {
            right_height++;
            cur = cur.right;
        }
        if (left_height > right_height) {
            int leftNodes = countNodes(root.left);
            int rightNodes = countNodes(root.right);
            return leftNodes + rightNodes + 1;
        }
        if (left_height == right_height) {
            return (int)Math.pow(2, left_height) - 1;
        }
        return 0;
    }
}

// Time O(logn * logn)
