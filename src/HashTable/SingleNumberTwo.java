/**
 *
 */
package HashTable;

import java.util.HashSet;
import java.util.Set;

/**
 * Given an array of integers, every element appears three times except for one, which appears exactly once.
 * Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
 * @author SenWang
 *
 */
public class SingleNumberTwo {
    /**
     * This is the my simple solution to this question, which uses
     * hash set to remember the number we have come across.
     * @param nums the array of numbers to be considered.
     * @return the single number which occurs only once.
     */
    public static int solution(int[] nums) {
        Set<Integer> set = new HashSet<Integer>();
        long thirdSum = 0;
        long sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (!set.contains(nums[i])) {
                thirdSum += nums[i];
                set.add(nums[i]);
            }
        }
        return (int) ((thirdSum * 3 - sum) / 2);
    }
    /**
     * This is my another solution to this question, which uses
     * bit wise opertion, the idea is similar to the single number question version 1.
     * @param nums the array of numbers to be considered.
     * @return the single number which occurs only once.
     */
    public static int solution2(int[] nums) {
        int sum = nums[0];
        int thirdSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum += nums[i];
            thirdSum ^= nums[i];
        }
        System.out.println(thirdSum);
        return (thirdSum * 3 - sum) / 2;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {2, 1, 3, 1, 3, 3, 1};
        System.out.println(SingleNumberTwo.solution2(array));
    }

}
