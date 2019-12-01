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
