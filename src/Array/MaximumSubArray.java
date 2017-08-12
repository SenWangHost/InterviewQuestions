/**
 *
 */
package Array;

/**
 * Find the contiguous subarray within an array (containing at least one number) which has the largest sum.
 * For example, given the array [-2,1,-3,4,-1,2,1,-5,4],
 * the contiguous subarray [4,-1,2,1] has the largest sum = 6.
 * @author SenWang
 *
 */
public class MaximumSubArray {
    /**
     * This is the reference solution to this question. The idea comes from
     * the subproblem to the orginal problem. The detailed analysis of this problem
     * can be seen on the leetcode. Also see link to Kadane's algorithm.
     * @param nums the array of numbers to be considered.
     * @return the maximum sum of the subarray.
     */
    public static int solutionRef(int[] nums) {
        int size = nums.length;
        int[] dp = new int[size];
        dp[0] = nums[0];
        int max = dp[0];
        for (int i = 1; i < size; i++) {
            int increment = 0;
            if (dp[i - 1] > 0) {
                increment = dp[i - 1];
            } else {
                increment = 0;
            }
            dp[i] = nums[i] + increment;
            max = Math.max(max, dp[i]);
        }
        return max;
    }
    /**
     * Another reference solution to this question, which uses kadane's algorithm.
     * @param nums the array of numbers to be considered.
     * @return the maximum sum of the subarray.
     */
    public static int solutionRef2(int[] nums) {
        int max_ending_here = nums[0];
        int max_so_far = nums[0];
        for (int i = 0; i < nums.length; i++) {
            max_ending_here = Math.max(nums[i], max_ending_here + nums[i]);
            max_so_far = Math.max(max_so_far, max_ending_here);
        }
        return max_so_far;
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int result = MaximumSubArray.solutionRef2(test);
        System.out.println(result);
    }

}
