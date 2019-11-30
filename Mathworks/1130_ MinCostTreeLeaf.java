class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int ans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(Integer.MAX_VALUE);
        for (int a : arr) {
            while (stack.peek() <= a) {
                int toBeRemoved = stack.pop();
                int cost = toBeRemoved * Math.min(stack.peek(), a);
                ans += cost;
            }
            stack.push(a);
        }
        while (stack.size() > 2) {
            ans += stack.pop() * stack.peek();
        }
        return ans;
    }
}

// Time O(n)
// Space O(n)
