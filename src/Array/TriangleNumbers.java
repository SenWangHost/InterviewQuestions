/**
 *
 */
package Array;

import java.util.Arrays;

/**
 * Given an array consists of non-negative integers, your task is to count the number of triplets chosen from the array that
 * can make triangles if we take them as side lengths of a triangle.
 *
 * Input: [2,2,3,4]
 * Output: 3
 * Explanation:
 * Valid combinations are:
 * 2,3,4 (using the first 2)
 * 2,3,4 (using the second 2)
 * 2,2,3
 *
 * Note:
 * The length of the given array won't exceed 1000.
 * The integers in the given array are in the range of [0, 1000].
 * @author SenWang
 *
 */
public class TriangleNumbers {
    /**
     * My own solution to this question. slightly optimized for O(n^3)
     * @param num the array of numbers for input
     * @return the number of pairs of number that can form triangle.
     */
    public int triNum(int[] nums) {
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    if (nums[i] + nums[j] > nums[k]) {
                        result += 1;
                    } else {
                        break;
                    }
                }
            }
        }
        return result;
    }
    /**
     * One good solution to this question, utilize the properties of sorted arrays.
     * Should be the same as liner scan
     * @param num the array of numbers for input
     * @return the number of pairs of number that can form triangle.
     */
    public int triNumGood(int[] nums) {
        // sort the array in ascending order.
        Arrays.sort(nums);
        int result = 0;
        // start from the maximum number on the right side of the array.
        for (int i = nums.length - 1; i >= 2; i--) {
            int max = nums[i];
            // set up index for loop through the rest of array
            // staring the bottom and top.
            int low = 0;
            int high = i - 1;
            while (low < high) {
                if (nums[low] + nums[high] > max) {
                    result += high - low;
                    high--;
                } else {
                    low++;
                }
            }
        }
        return result;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TriangleNumbers test = new TriangleNumbers();
        int[] arr = {2, 2, 3, 4};
        System.out.println(test.triNum(arr));
    }

}
