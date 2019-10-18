class Solution {
    public int mctFromLeafValues(int[] arr) {
        int len = arr.length;
        int[][] dpTable = new int[len][len];
        return helper(arr, 0, len - 1, dpTable);
    }
    
    public int helper(int[] arr, int start, int end, int[][] dp) {
        if (start >= end) {
            return 0;
        }
        if (dp[start][end] != 0) {
            return dp[start][end];
        }
        int minCost = Integer.MAX_VALUE;
        for (int i = 0; i < end - start; i++) {
            int leftMinCost = helper(arr, start, start + i, dp);
            int rightMinCost = helper(arr, start + i + 1, end, dp);
            int lMax = -1;
            int rMax = -1;
            for (int j = start; j <= start + i; j++) {
                if (lMax < arr[j]) {
                    lMax = arr[j];
                }
            }
            for (int j = start + i + 1; j <= end; j++) {
                if (rMax < arr[j]) {
                    rMax = arr[j];
                }
            }
            int curCost = leftMinCost + rightMinCost + lMax * rMax;
            if (curCost < minCost) {
                minCost = curCost;
            }
        }
        dp[start][end] = minCost;
        return dp[start][end];
    }
}
