class Solution {
    int[] dp;
    public int coinChange(int[] coins, int amount) {
        dp = new int[amount];
        return helper(coins, amount);
    }
    public int helper(int[] coins, int amount) {
        if (amount == 0) return 0;
        if (amount < 0) return -1;
        if (dp[amount - 1] != 0) return dp[amount - 1];
        int min = Integer.MAX_VALUE;
        for (int coin : coins) {
            int ans = helper(coins, amount - coin);
            if (ans >= 0 && ans < min) {
                min = ans + 1;
            }
        }
        if (min != Integer.MAX_VALUE) {
            dp[amount - 1] = min;
        } else {
            dp[amount - 1] = -1;
        }
        return dp[amount - 1];
    }
}
