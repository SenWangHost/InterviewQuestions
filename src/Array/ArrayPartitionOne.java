/**
 *
 */
package Array;

import java.util.Arrays;

/**
 * Given an array of 2n integers, your task is to group these integers into n pairs of integer,
 * say (a1, b1), (a2, b2), ..., (an, bn) which makes sum of min(ai, bi) for all i from 1 to n as large as possible.
 *
 * Example 1:
 * Input: [1,4,3,2]
 * Output: 4
 * Explanation: n is 2, and the maximum sum of pairs is 4 = min(1, 2) + min(3, 4).
 *
 * Note:
 * n is a positive integer, which is in the range of [1, 10000].
 * All the integers in the array will be in the range of [-10000, 10000].
 * @author SenWang
 *
 */
public class ArrayPartitionOne {
    /**
     * This is my own solution to this question. This solution use sorting
     * algorithm and the runtime complexity would be O(n * log(n)).
     * There is a proof of this algorithm on the leetcode.
     * @param nums the array of numbers to be considered.
     * @return the sum of min(ai, bi).
     */
    public static int solution(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 0) {
                sum += nums[i];
            }
        }
        return sum;
    }
    /**
     * This is the reference solution to this question, which
     * uses the bucket sort algorithm because the range of integers are given.
     * @param nums the array of numbers to be considered.
     * @return the sum of min(ai, bi).
     */
    public static int solutionRef(int[] nums) {
        int[] array = new int[20001];
        // the bucket sort algorithm, it maps the integer itself into the index of
        // another array, then, when you process the new array by the index, you will encounter
        // the element in a sorting order.
        for (int i = 0; i < nums.length; i++) {
            array[nums[i] + 10000]++;
        }
        int sum = 0;
        boolean smaller = true;
        for (int i = 0; i < array.length;) {
            if (array[i] > 0) {
                if (smaller) {
                    sum += i - 10000;
                }
                smaller = !smaller;
                array[i]--;
            } else {
                i++;
            }
        }
        return sum;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 4, 3, 2};
        int result = ArrayPartitionOne.solution(test);
        System.out.println(result);
    }
}
