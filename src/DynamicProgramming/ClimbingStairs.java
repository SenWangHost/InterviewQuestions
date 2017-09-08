/**
 *
 */
package DynamicProgramming;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 * Note: Given n will be a positive integer.
 * @author SenWang
 */
public class ClimbingStairs {
    /**
     * This is my own solution to this question, which uses dynamic programming
     * try to find the recurrence relation.
     * @param n the number of stairs to be climbed.
     * @return the distinct to climb those steps.
     */
    public static int solution(int n) {
        if (n <= 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[dp.length - 1];
    }
    /**
     * The reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 6;
        System.out.println(ClimbingStairs.solution(test));
    }

}
