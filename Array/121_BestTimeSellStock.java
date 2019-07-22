// Brute Force
class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        for(int i = 0; i<prices.length-1; i++){
            for(int j = i+1; j<prices.length; j++){
                int profit = prices[j] - prices[i];
                if(profit > maxProfit) maxProfit = profit;
            }
        }
        return maxProfit;
    }
}

// A fast solution
class Solution {
    public int maxProfit(int[] prices) {
        // Once the problem did not say the array is non-empty
        // We should always check array's length
        if(prices.length == 0) return 0;
        
        int minSoFar = prices[0];
        int maxProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i] < minSoFar)
                minSoFar = prices[i];
            else
                maxProfit = Math.max(maxProfit, prices[i]-minSoFar);
        }
        return maxProfit;
    }
}
