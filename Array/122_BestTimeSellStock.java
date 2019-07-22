// my solution
class Solution {
    public int maxProfit(int[] prices) {
        // check prices.length
        if(prices.length<2) return 0;
        
        int maxProfit = 0;
        int curProfit = 0;
        for(int i = 1; i < prices.length; i++){
            if(prices[i]>prices[i-1]){
                curProfit = prices[i] - prices[i-1];
                maxProfit += curProfit;
            }
        }
        return maxProfit;
    }
}
