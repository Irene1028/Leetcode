class Solution {
    public boolean verifyPreorder(int[] preorder) {
        Stack<Integer> stack = new Stack<>();
        int low = Integer.MIN_VALUE;
        for (int cur : preorder) {
            if (cur < low) {
                return false;
            }
            while (!stack.empty() && cur > stack.peek()) {
                low = stack.pop();
            }
            stack.push(cur);
        }
        return true;
    }
    
}

// Time = O(n), traverse one pass
// Space = O(n), in case that the array is a desending order

class Solution {
    public boolean verifyPreorder(int[] preorder) {
        // stupid method
        // find left subtree, and see whether all right subtree nodes smaller than cur root.
        return verify(preorder, 0, preorder.length - 1);
        
    }
    private boolean verify(int[] preorder, int start, int end) {
        if (start >= end) return true;
        int left = start + 1;
        while (left <= end && preorder[left] < preorder[start]) {
            left++;
        }
        if (left > end) {
            return verify(preorder, start + 1, end);
        }
        int right = left;
        while (right <= end) {
            if (preorder[right] < preorder[start]) {
                return false;
            }
            right++;
        }
        return verify(preorder, start + 1, left - 1) && verify(preorder, left, end);
    }
}

// Time = O(n), traverse one pass
// Space = O(n), in case that the array is a desending order
