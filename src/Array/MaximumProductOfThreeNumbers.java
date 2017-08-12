/**
 *
 */
package Array;

import java.util.Arrays;

/**
 * Given an integer array, find three numbers whose product is maximum and output the maximum product.
 * Example 1:
 * Input: [1,2,3]
 * Output: 6
 *
 * Example 2:
 * Input: [1,2,3,4]
 * Output: 24
 *
 * Note:
 * The length of the given array will be in range [3,104] and all elements are in the range [-1000, 1000].
 * Multiplication of any three numbers in the input won't exceed the range of 32-bit signed integer.
 *
 * @author SenWang
 *
 */
public class MaximumProductOfThreeNumbers {
    /**
     * This is my own solution for this question. This solution is acceptable but the runtime complexity
     * is O(n * log(n)), which is not so good.
     * @param nums the array of numbers to be accounted for.
     * @return the maximum product of three numbers
     */
    public static int solution(int[] nums) {
        int size = nums.length;
        if (size == 3) {
            return nums[0] * nums[1] * nums[2];
        }
        Arrays.sort(nums);
        int result1 = nums[size - 1] * nums[size - 2] * nums[size - 3];
        int result2 = nums[size - 1] * nums[size - 2] * nums[0];
        int result3 = nums[size - 1] * nums[1] * nums[0];
        int result4 = nums[0] * nums[1] * nums[2];
        return Math.max(Math.max(result1, result2), Math.max(result3, result4));
    }
    /**
     * This is the reference solution from the leetcode. The runtime complexity is O(n), which is pretty good
     * for this solution.
     * @param nums the array of numbers to be accounted for.
     * @return the maximum product of three numbers
     */
    public static int solutionRef(int[] nums) {
        // simply try to find three largest number and two smallest numbers by looping
        // through the array, the runtime complexity is O(n)
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        int max3 = Integer.MIN_VALUE;
        int min1 = Integer.MAX_VALUE;
        int min2 = Integer.MAX_VALUE;
        for (int n : nums) {
            // update the three maximum numbers
            if (n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (n > max2) {
                max3 = max2;
                max2 = n;
            } else if (n > max3) {
                max3 = n;
            }
            // update the two minimum numbers
            if (n < min1) {
                min2 = min1;
                min1 = n;
            } else if (n < min2) {
                min2 = n;
            }
        }
        return Math.max(max1 * max2 * max3, max1 * min1 * min2);
    }
    /**
     * This is test case for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-4, 3, -2, 3};
        int result = MaximumProductOfThreeNumbers.solution(nums);
        System.out.println(result);
    }

}
