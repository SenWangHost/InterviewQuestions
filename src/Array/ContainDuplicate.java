/**
 *
 */
package Array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, find if the array contains any duplicates.
 * Your function should return true if any value appears at least twice in the array,
 * and it should return false if every element is distinct.
 *
 * @author SenWang
 *
 */
public class ContainDuplicate {
    /**
     * This is my own solution to this question, which makes use of hashmap.
     * @param nums the array of numbers to be considered.
     * @return true if duplicate exists else otherwise.
     */
    public static boolean solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (!set.contains(nums[i])) {
                set.add(nums[i]);
            } else {
                return true;
            }
        }
        return false;
    }
    /**
     * This is my own solution, which makes use of sorting.
     * @param nums the array of numbers to be considered.
     * @return true if duplicate exists else otherwise.
     */
    public static boolean solution2(int[] nums) {
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] == nums[i]) {
                return true;
            }
        }
        return false;
    }
    /**
     * The reference solutions have the same idea as my own solution.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 1, 3, 4, 2};
        boolean result = ContainDuplicate.solution(test);
        System.out.println(result);
    }

}
