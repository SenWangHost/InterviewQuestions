/**
 *
 */
package DynamicProgramming;

/**
 * You are a professional robber planning to rob houses along a street. Each house has a certain amount of
 * money stashed, the only constraint stopping you from robbing each of them is that adjacent houses have
 * security system connected and it will automatically contact the police if two adjacent houses were broken
 * into on the same night.
 * Given a list of non-negative integers representing the amount of money of each house,
 * determine the maximum amount of money you can rob tonight without alerting the police.
 * @author SenWang
 *
 */
public class HouseRobber {
    /**
     * This is one of the reference solution to this question, which uses
     * dynamic programming. The basic idea is for ith house, the robber could either
     * choose to rob the house or not.
     * @param nums the array of numbers to be considered.
     * @return the maximum amount to be robbed.
     */
    public static int solution(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[i], dp[i - 1]);
        }
        return dp[dp.length - 1];
    }
    /**
     * This is another solution to this question, which uses dynamic solution but with
     * O(1) space.
     * @param nums the array of numbers to be considered.
     * @return the maximum amount to be robbed.
     */
    public static int solution2(int[] nums) {
        int rob = 0; // max monney can get if rob current house
        int notrob = 0; // max money can get if not rob current house
        for (int i=0; i< nums.length; i++) {
            int currob = notrob + nums[i]; // if rob current value, previous house must not be robbed
            notrob = Math.max(notrob, rob); // if not rob ith house, take the max value of robbed (i-1)th house and not rob (i-1)th house
            rob = currob;
        }
        return Math.max(rob, notrob);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
