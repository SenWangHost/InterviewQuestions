/**
 * This package contains interview questions mainly related to data
 * structure arrays.
 */
package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 * Given nums = [2, 7, 11, 15], target = 9,
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 * @author SenWang
 *
 */
public class TwoSum {
    /**
     * This is the reference solution for TwoSum question.
     * @param nums the integer array for input
     * @param target the target sum that two numbers should add up to.
     */
    public int[] solution(int[] nums, int target) {
        // loop through the array and store the counter part into a hashMap for
        // future use.
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!map.containsKey(target - nums[i])) {
                map.put(nums[i], i);
            } else {
                result[1] = i;
                result[0] = map.get(target - nums[i]);
                return result;
            }
        }
        return null;
    }
    /**
     * This is the test program for TwoSum question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TwoSum test = new TwoSum();
        int[] nums = {2, 7, 11, 15};
        int[] result = test.solution(nums, 9);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
