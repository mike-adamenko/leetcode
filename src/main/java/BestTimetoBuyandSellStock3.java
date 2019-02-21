import java.util.Arrays;

/**
 * https://leetcode.com/problems/best-time-to-buy-and-sell-stock-iii/
 *
 123. Best Time to Buy and Sell Stock III
 Hard

 876

 51

 Favorite

 Share
 Say you have an array for which the ith element is the price of a given stock on day i.

 Design an algorithm to find the maximum profit. You may complete at most two transactions.

 Note: You may not engage in multiple transactions at the same time (i.e., you must sell the stock before you buy again).

 Example 1:

 Input: [3,3,5,0,0,3,1,4]
 Output: 6
 Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
 Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
 Example 2:

 Input: [1,2,3,4,5]
 Output: 4
 Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
 Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
 engaging multiple transactions at the same time. You must sell before buying again.
 Example 3:

 Input: [7,6,4,3,1]
 Output: 0
 Explanation: In this case, no transaction is done, i.e. max profit = 0.
 */
public class BestTimetoBuyandSellStock3 {
    public static void main(String[] args) {
        int[] arr = {1,2,4,2,5,7,2,4,9,0};
        System.out.println(new BestTimetoBuyandSellStock3().maxProfit(arr));
    }

    public int maxProfit2(int[] prices) {
        if (prices==null || prices.length<2)return 0;
        int total = 0;
        boolean inTx=false;
        int[] tx = new int[prices.length];
        for (int i=0; i< prices.length-1; i++) {
            if (prices[i+1]>prices[i]) {
                total += prices[i+1]-prices[i];
                inTx = true;
            }else{
                tx[i]= total;
                total=0;
                inTx = false;
            }
        }
        if (inTx)tx[prices.length-1]= total;
        Arrays.sort(tx);

        return tx[tx.length-1]+tx[tx.length-2];
    }

    public int maxProfit3(int[] prices) {
        if(prices == null || prices.length == 0) return 0;
        int totalK = 2;
        int[][] dp = new int[totalK+1][prices.length];
        for(int k = 1;k<=totalK;k++){//profit = 0 when k = 0
            for(int i = 1;i< prices.length;i++){
                int maxProfitSellOnDayI = Math.max(0,prices[i] - prices[0]);//buy on day 0, sell on day i
                for(int j = 1;j<i;j++){//buy on day j, sell on day i
                    maxProfitSellOnDayI = Math.max(maxProfitSellOnDayI,dp[k-1][j-1] + prices[i] - prices[j]);
                }
                dp[k][i] = Math.max(dp[k][i-1],maxProfitSellOnDayI);//sell on day i OR not
            }
        }
        return dp[totalK][prices.length-1];
    }

    public int maxProfit4(int[] prices) {
        int hold1 = Integer.MIN_VALUE, hold2 = Integer.MIN_VALUE;
        int release1 = 0, release2 = 0;
        for(int i:prices){                              // Assume we only have 0 money at first
            release2 = Math.max(release2, hold2+i);     // The maximum if we've just sold 2nd stock so far.
            hold2    = Math.max(hold2,    release1-i);  // The maximum if we've just buy  2nd stock so far.
            release1 = Math.max(release1, hold1+i);     // The maximum if we've just sold 1nd stock so far.
            hold1    = Math.max(hold1,    -i);          // The maximum if we've just buy  1st stock so far.
        }
        return release2; ///Since release1 is initiated as 0, so release2 will always higher than release1.
    }
    public int maxProfit(int[] prices)  {
        if(prices == null || prices.length == 0) return 0;
        int buy1 = Integer.MAX_VALUE, buy2 = Integer.MAX_VALUE;
        int sell1 = 0, sell2 = 0;

        for (int i = 0; i < prices.length; i++) {
            buy1 = Math.min(buy1, prices[i]);
            sell1 = Math.max(sell1, prices[i] - buy1);
            buy2 = Math.min(buy2, prices[i] - sell1);
            sell2 = Math.max(sell2, prices[i] - buy2);
        }

        return sell2;
    }


}
