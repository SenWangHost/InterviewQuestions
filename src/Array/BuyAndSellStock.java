/**
 *
 */
package Array;

/**
 * Say you have an array for which the ith element is the price of a given stock on day i.
 * If you were only permitted to complete at most one transaction (ie, buy one and sell one share of the stock),
 * design an algorithm to find the maximum profit.
 *
 * Example 1:
 * Input: [7, 1, 5, 3, 6, 4]
 * Output: 5
 * max. difference = 6-1 = 5 (not 7-1 = 6, as selling price needs to be larger than buying price)
 *
 * Example 2:
 * Input: [7, 6, 4, 3, 1]
 * Output: 0
 * In this case, no transaction is done, i.e. max profit = 0
 * @author SenWang
 *
 */
public class BuyAndSellStock {
    /**
     * This is my own solution to this question. This is the brute force solution.
     * The runtime complexity of this solution is not acceptable.
     * which is not acceptable.
     * @param prices the array representing the prices at different days.
     * @return the max profit by buying and selling the stock.
     */
    public static int solution(int[] prices) {
        int profit = Integer.MIN_VALUE;
        for (int i = 0; i < prices.length; i++) {
            int buy = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                profit = Math.max(profit, prices[j] - buy);
            }
        }
        if (profit < 0) {
            return 0;
        }
        return profit;
    }
    /**
     * This is another solution of mine. This solution's idea is the same as
     * finding the so far min and calculate the max profit.
     * @param prices the array representing the prices at different days.
     * @return the max profit by buying and selling the stock.
     */
    public static int solution2(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int sell = prices[0];
        int sellIndex = 0;
        int buy = prices[0];
        int buyIndex = 0;
        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] <= buy) {
                buy = prices[i];
                buyIndex = i;
            }
            if (prices[i] >= sell) {
                sell = prices[i];
                sellIndex = i;
            }
            if (sellIndex > buyIndex && sell - buy >= profit) {
                profit = sell - buy;
            } else {
                sell = buy;
                sellIndex = buyIndex;
            }
        }
        return profit;
    }
    /**
     * This is the reference solution, which try to find the so far min and calculate
     * the maximum profit.
     * @param prices the array representing the prices at different days.
     * @return the max profit by buying and selling the stock.
     */
    public static int solutionRef(int[] prices) {
        if (prices.length == 0) {
            return 0;
        }
        int profit = 0;
        int sofarMin = Integer.MAX_VALUE;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < sofarMin) {
                sofarMin = prices[i];
            } else if (prices[i] - sofarMin > profit) {
                profit = prices[i] - sofarMin;
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
        int[] test = {5, 10, 4, 9};
        int result = BuyAndSellStock.solution2(test);
        System.out.println(result);
    }

}
