package Best_Time_To_Buy_And_Sell_Stock;

public class Solution {
    public int maxProfit(int[] prices){
        int mini = prices[0];
        int profit = 0;
        for(int i =1; i < prices.length; i++){
            int localProfit = prices[i] - mini;
            profit = Math.max(localProfit, profit);
            mini = Math.min(mini, prices[i]);
        }
        return profit;
    }
    
}
