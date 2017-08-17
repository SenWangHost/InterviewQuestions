/**
 *
 */
package BitManipulation;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers, every element appears twice except for one. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author SenWang
 *
 */
public class SingleNumber {
    /**
     * This is my own solution to this question, which is simple solution
     * and makes use of hash map.
     * @param nums an array of numbers to be considered.
     * @return the single one among the numbers.
     */
    public static int solution(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (map.get(nums[i]) == 1) {
                return nums[i];
            }
        }
        return 0;
    }
    /**
     * This is my another solution, which uses hash set and only traverse the array
     * once.
     * @param nums an array of numbers to be considered.
     * @return the single one among the numbers.
     */
    public static int solution2(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        long halfSum = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!set.contains(nums[i])) {
                halfSum += nums[i];
                set.add(nums[i]);
            }
        }
        return (int) (halfSum * 2 - sum);
    }
    /**
     * The reference solution uses bit manipulation, which use xor.
     * Since A ^ A = 0, and A ^ B ^ A = B, finally, the single one will be left off.
     * @param nums an array of numbers to be considered.
     * @return the single one among the numbers.
     */
    public static int solutionRef(int[] nums) {
        int result = nums[0];
        for (int i = 1; i < nums.length; i++) {
            result ^= nums[i];
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 1, 3, 3, 2};
        System.out.println(SingleNumber.solution(test));
    }
}
