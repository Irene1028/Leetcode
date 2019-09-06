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
    public boolean isValidBST(TreeNode root) {
        // idea recursion
        // need helper fuction
        
        // base case
        if (root == null) return true;
        boolean left_valid = isValidBST(root.left);
        boolean right_valid = isValidBST(root.right);
        if (left_valid == true && right_valid == true) {
            TreeNode left_max = root.left;
            while (left_max != null && left_max.right != null) {
                left_max = left_max.right;
            }
            TreeNode right_min = root.right;
            while (right_min != null && right_min.left != null) {
                right_min = right_min.left;
            }
            if (left_max == null && right_min == null) {
                return true;
            }
            else if (left_max == null && right_min.val > root.val) {
                return true;
            }
            else if (right_min == null && left_max.val < root.val) {
                return true;
            }
            else if (right_min != null && left_max != null){
                if (right_min.val > root.val && left_max.val < root.val) {
                    return true;
                }
                else
                    return false;
            }
            else
                return false;
        }
        return false;
    }
    
}

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
    public boolean isValidBST(TreeNode root) {
        // idea, from top to bottom
        // we should use long type here. int is not long enough.
        return isValidHelper (root, Long.MAX_VALUE, Long.MIN_VALUE);
    }
    private boolean isValidHelper(TreeNode root, long upperLine, long lowerLine) {
        if (root == null) return true;
        // should be >= and <=, should not exist two same keys.
        if (root.val >= upperLine) {
            return false;
        }
        if (root.val <= lowerLine) {
            return false;
        }
        return isValidHelper(root.left, root.val, lowerLine) && isValidHelper(root.right, upperLine, root.val);
    }
}
