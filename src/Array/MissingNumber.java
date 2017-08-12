/**
 *
 */
package Array;

import java.util.Arrays;

/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.
 * For example,
 * Given nums = [0, 1, 3] return 2.
 *
 * Note:
 * Your algorithm should run in linear runtime complexity. Could you implement it
 * using only constant extra space complexity?
 * @author SenWang
 *
 */
public class MissingNumber {
    /**
     * This is my own solution to this question. This time complexity of this
     * algorithm is O(n * log(n))
     * @param nums the array of numbers to be considered.
     * @return the missing number
     */
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        if (nums.length == 1) {
            if (nums[0] == 0) {
                return 1;
            } else {
                return 0;
            }
        }
        for (int i = 0; i < nums.length - 1; i++) {
            if (nums[i + 1] - nums[i] != 1) {
                return nums[i] + 1;
            }
        }
        if (nums[nums.length - 1] != nums.length) {
            return nums.length;
        }
        return 0;
    }
    /**
     * This is another solution to this question. which calculates
     * the sum of array and compares with the standard sum of 0 to n;
     * @param nums the array of numbers to be considered.
     * @return the missing number
     */
    public static int solution2(int[] nums) {
        int n = nums.length;
        int sumToBe = n * (n + 1) / 2;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
        }
        return sumToBe - sum;
    }
    /**
     * This is the reference solution to this question. which use xor operation.
     * The basic idea is to use XOR operation. We all know that a^b^b =a,
     * which means two xor operations with the same number will eliminate the number and reveal the original number.
     * In this solution, I apply XOR operation to both the index and value of the array.
     * In a complete array with no missing numbers, the index and value should be perfectly corresponding( nums[index] = index),
     * so in a missing array, what left finally is the missing number.
     */
    public static int solutionRef(int[] nums) {
        int xor = 0, i = 0;
        for (i = 0; i < nums.length; i++) {
            xor = xor ^ i ^ nums[i];
        }
        return xor ^ i;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {0, 1};
        int result = MissingNumber.solution(test);
        System.out.println(result);
    }

}
