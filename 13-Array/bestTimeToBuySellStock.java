/* -> problem : Buy & Sell Stocks
* =>You are given an array prices where prices[il is the price of a given stock
*       on the ith day. You want to maximize your profit by choosing a single day to
*       buy one stock and choosing a different day in the future to sell that stock.
*       Return the maximum profit you can achieve from this transaction. If you
*       cannot achieve any profit, return 0.
* 
*   - we are given prices = [7, 1, 5, 3, 6, 4] 
*/

public class bestTimeToBuySellStock {
    public static void main(String[] args) {

        int[] prices = {7, 1, 5, 3, 6, 4};

        int buyPrice = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int i=0;i< prices.length;i++) {
            // case 1 : when we r making profit
            if(buyPrice < prices[i]/*selling price today*/) {
                int profit = prices[i] - buyPrice;
                maxProfit = Math.max(maxProfit, profit);
            } 
            else { // case 2 : when we r in loss buyPrice > prices[i], then we buy stock and the average price of stock will become low means buyPrice = todaysPrice
                buyPrice = prices[i];
            }
        }

        System.out.println("max profit : " + maxProfit);
    }
}
