class Solution {
    public int maxProfit(int[] prices) {
        int min = Integer.MAX_VALUE;
        int max = 0;
        int res = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            } else if (prices[i] - min > max) {
                max = prices[i] - min;
            }
            if (i == prices.length - 1) {
                res += max;
            } else if (i < prices.length - 1 && prices[i + 1] < prices[i]) {
                res += max;
                // System.out.println(min);
                // System.out.println(max);
                max = 0;
                min = prices[i + 1];
            }
        }
        return res;
    }
}
