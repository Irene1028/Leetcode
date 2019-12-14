// DP Exceed Time Limit
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            int base = 1;
            for (int j = i; j < n; j++) {
                base *= nums[j];
                dp[i][j] = base;
                // System.out.print(dp[i][j]);
            }
            // System.out.println(" ");
        }
        int[] ret = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) {
                ret[i] = dp[1][n-1];
            } else if (i == n - 1) {
                ret[i] = dp[0][n-2];
            } else {
                ret[i] = dp[0][i - 1] * dp[i + 1][n - 1];
            }
        }
        return ret;
    }
}
//
// Time O(n)

class Solution {
    public int[] productExceptSelf(int[] nums) {
        // recursion
        int n = nums.length;
        int[] ret = new int[n];
        int[] leftProduct = new int[n];
        int[] rightProduct = new int[n];
        for (int i = 0; i < n; i++) {
            if (i == 0) 
                leftProduct[i] = 1;
            else 
                leftProduct[i] = leftProduct[i - 1] * nums[i - 1];
        }
        for (int i = n - 1; i >= 0; i--) {
            if (i == n - 1) 
                rightProduct[i] = 1;
            else 
                rightProduct[i] = rightProduct[i + 1] * nums[i + 1];
        }
        for (int i = 0; i < n; i++) {
            ret[i] = leftProduct[i] * rightProduct[i];
        }
        return ret;
    }
    
}
