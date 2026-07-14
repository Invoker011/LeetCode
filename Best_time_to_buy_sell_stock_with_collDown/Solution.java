package Best_time_to_buy_sell_stock_with_collDown;

public class Solution {
    public int maxProfit(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n+2][2];

        for(int i = n-1; i>=0;i--){
            for(int buy = 0; buy <=1; buy++){
                int profit =0;

                if(buy == 0){
                    profit = Math.max(0 + dp[i+1][0], -prices[i] + dp[i+1][1]);
                }
                if(buy == 1){
                    profit = Math.max(0+dp[i+1][0], prices[i] + dp[i+2][0]);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][0];
    }
    
}
