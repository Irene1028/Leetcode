class Solution {
    public int rob(int[] nums) {
        // dp table
        if (nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = nums[1];
        for (int i = 2; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i - 1; j++) {
                if (dp[j] + nums[i] > max) {
                    max = dp[j] + nums[i];
                }
            }
            dp[i] = max;
        }
        return Math.max(dp[nums.length-1], dp[nums.length-2]);
    }
}
/* dp solution */
/* Time = O(n^2) */
/* Space = O(n) */
