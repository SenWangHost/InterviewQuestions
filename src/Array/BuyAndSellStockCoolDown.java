/**
 *
 */
package Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
 *
 * 1. You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
 * 2. After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
 *
 * Example:
 * prices = [1, 2, 3, 0, 2]
 * maxProfit = 3
 * transactions = [buy, sell, cooldown, buy, sell]
 * @author SenWang
 *
 */
public class BuyAndSellStockCoolDown {
    /**
     * This is my own solution for this question.
     * @param prices the array representing different prices at different days.
     * @return the maximum profit.
     */
    public static int solution(int[] prices) {
        return 0;
    }
    /**
     * This is the reference solution to this question.
     * @param prices the array representing different prices at different days.
     * @return the maximum profit.
     */
    public static int solutionRef(int[] prices) {
        int sell = 0, prev_sell = 0, buy = Integer.MIN_VALUE, prev_buy;
        for (int price : prices) {
            prev_buy = buy;
            buy = Math.max(prev_sell - price, prev_buy);
            prev_sell = sell;
            sell = Math.max(prev_buy + price, prev_sell);
        }
        return sell;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3, 0, 2};
        int result = BuyAndSellStockCoolDown.solution(test);
        System.out.println(result);
    }

}
