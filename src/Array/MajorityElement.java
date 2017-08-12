/**
 *
 */
package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of size n, find the majority element.
 * The majority element is the element that appears more than [n/2] times.
 * You may assume that the array is non-empty and the majority element always exist in the array.
 * @author SenWang
 * This question has several types of solutions
 */
public class MajorityElement {
    /**
     * This is my own solution to this question. It makes use of the hashmap.
     * @param nums the array of numbers to be considered.
     * @return the majority element that is defined by this question.
     */
    public static int solution(int[] nums) {
        // use the hashmap to keep track of the times one element occurs.
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(nums[i])) {
                map.put(nums[i], 1);
            } else {
                int times = map.get(nums[i]);
                map.put(nums[i], times + 1);
            }
            int times = map.get(nums[i]);
            if (times > nums.length / 2) {
                return nums[i];
            }
        }
        return -1;
    }
    /**
     * This solution using the sorting in java to find the answer.
     * The runtime complexity is O(n * log(n))
     * However, when tested, it runs faster than the first solution.???
     * @param nums the array of numbers to be considered.
     * @return the majority element that is defined by this question.
     */
    public static int solutionSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length / 2];
    }
    /**
     * This solution use moore voting algorithm, find more information online about
     * this algorithm.
     * @param nums the array of numbers to be considered.
     * @return the majority element that is defined by this question.
     */
    public static int solutionVoting(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (count == 0) {
                result = nums[i];
            }
            if (result == nums[i]) {
                count++;
            } else {
                count--;
            }
        }
        return result;
    }
    /**
     * This is the bit manipulation method. Assume that all the numbers in the array
     * is 32-bit integer. Then, for each number and each bit position, if the count of 1 at
     * a specific bit position is greater than size / 2, then it indicates that the majority element would have
     * 1 at this bit position, otherwise it would be zero.
     * @param nums the array of numbers to be considered.
     * @return the majority element that is defined by this question.
     */
    public static int solutionBitManipulation(int[] nums) {
        int[] bits = new int[32];
        for (int i = 0; i < nums.length; i++) {
            for (int j = 0; j < 32; j++) {
                if (((nums[i] >> (31 - j)) & 1) == 1) {
                    bits[i]++;
                }
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] > nums.length / 2) {
                bits[i] = 1;
            } else {
                bits[i] = 0;
            }
            result += bits[i] * (1 << (31 - i));
        }
        return result;
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 4, 2, 2, 7, 2, 9, 2};
        int result = MajorityElement.solutionVoting(test);
        System.out.println(result);
    }
}
