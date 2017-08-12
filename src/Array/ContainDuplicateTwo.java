/**
 *
 */
package Array;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array
 * such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
 *
 * @author SenWang
 *
 */
public class ContainDuplicateTwo {
    /**
     * This is my own solution to this problem, which makes use of hashmap.
     * @param nums the array of numbers to be considered.
     * @param k the at-most distance that two duplicates could have.
     * @return true if such duplicates exist, else otherwise.
     */
    public static boolean solution(int[] nums, int k) {
        Map<Integer, Integer> memory = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (memory.containsKey(nums[i]) && memory.get(nums[i]) != i && Math.abs(memory.get(nums[i]) - i) <= k) {
                return true;
            }
            memory.put(nums[i], i);
        }
        return false;
    }
    /**
     * The reference solution has the same idea as my solution.
     * Instead, it uses the hashset as the aiding data structure.
     * @param nums the array of numbers to be considered.
     * @param k the at-most distance that two duplicates could have.
     * @return true if such duplicates exist, else otherwise.
     */
    public static boolean solutionRef(int[] nums, int k) {
        Set<Integer> set = new HashSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) {
                return true;
            }
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 1};
        boolean result = ContainDuplicateTwo.solution(test, 6);
        System.out.println(result);
    }

}
