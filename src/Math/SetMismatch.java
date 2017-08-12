/**
 *
 */
package Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * The set S originally contains numbers from 1 to n. But unfortunately, due to the data error, one of the numbers
 * in the set got duplicated to another number in the set, which results in repetition of one number and loss of another number.
 * Given an array nums representing the data status of this set after the error. Your task is to firstly
 * find the number occurs twice and then find the number that is missing. Return them in the form of an array.
 *
 * Example 1:
 * Input: nums = [1,2,2,4]
 * Output: [2,3]
 * Note:
 * 1. The given array size will in the range [2, 10000].
 * 2. The given array's numbers won't have any order.
 * @author SenWang
 *
 */
public class SetMismatch {
    /**
     * This is my own solution to this question. Find the duplicate number by hashset, find
     * the missing number by calculating the sum of 1 to n.
     * @param nums the array of numbers to be considered.
     * @return the array containing the duplicated number and the missing number.
     */
    public static int[] solution(int[] nums) {
        int len = nums.length;
        long sum = 0;
        int[] result = new int[2];
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < len; i++) {
            if (!set.contains(nums[i])) {
                sum += nums[i];
                set.add(nums[i]);
            } else {
                result[0] = nums[i];
            }
        }
        long sumOrigin = (len + 1) * len / 2;
        result[1] = Math.abs((int) (sumOrigin - sum));
        return result;
    }
    /**
     * This is my another solution to this question, which uses sorting
     * to find the duplicate number and calculate the sum of 1 to n to
     * find the missing number. The runtime complexity would be O(n * log(n)).
     * But the runtime tested on leetcode is actually better than the first solution.
     * @param nums the array of numbers to be considered.
     * @return the array containing the duplicated number and the missing number.
     */
    public static int[] solution2(int[] nums) {
        Arrays.sort(nums);
        int len = nums.length;
        long sum = nums[0];
        int[] result = new int[2];
        for (int i = 1; i < len; i++) {
            if (nums[i] == nums[i - 1]) {
                result[0] = nums[i];
            } else {
                sum += nums[i];
            }
        }
        long sumOrigin = (len + 1) * len / 2;
        result[1] = Math.abs((int) (sumOrigin - sum));
        return result;
    }
    /**
     * This is one of the reference solution that doesn't use hashset or sorting.
     * The idea is to put each element k to the k-1th position unless the k-1th is already occupied by k.
     * In that case we know k is a duplicate. In a second pass, we look for the ith position where its value is not i+1,
     * we know i+1 is the missing value.
     * @param nums the array of numbers to be considered.
     * @return the array containing the duplicated number and the missing number.
     */
    public static int[] solutionRef(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[nums[i]-1] != nums[i]) {
                swap(nums, i, nums[i]-1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i+1) return new int[]{nums[i], i+1};
        }
        return null;
    }
    /**
     * This is the helper function to swap two elements in the array.
     * @param nums the array of numbers to be considered.
     * @param i the index i for swapping from.
     * @param j the index j for swapping to.
     */
    private static void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 2, 4};
        int[] result = SetMismatch.solution2(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
