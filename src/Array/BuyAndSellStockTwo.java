/**
 *
 */
package Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
 * (ie, buy one and sell one share of the stock multiple times). However, you may not engage in multiple transactions
 * at the same time (ie, you must sell the stock before you buy again).
 * @author SenWang
 *
 */
public class BuyAndSellStockTwo {
    /**
     * This is my own solution to this question. The idea comes from BuyAndSellStock question version 1.
     * @param prices the array representing the prices at different days.
     * @return the max profit by buying and selling the stock.
     */
    public static int solution(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int sofarMin = prices[0];
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < sofarMin) {
                sofarMin = prices[i];
            } else if (prices[i] - sofarMin > 0) {
                profit += prices[i] - sofarMin;
                sofarMin = prices[i];
            }
        }
        return profit;
    }
    /**
     * This is the reference solution, which checks profitable buy and sell pair.
     * The runtime complexity is the same as my own solution.
     * @param prices the array representing the prices at different days.
     * @return the max profit by buying and selling the stock.
     */
    public static int solutionRef(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] - prices[i - 1] > 0) {
                profit += prices[i] - prices[i - 1];
            }
        }
        return profit;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 10};
        int result = BuyAndSellStockTwo.solution(test);
        System.out.println(result);
    }

}
