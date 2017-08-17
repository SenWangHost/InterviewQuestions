/**
 *
 */
package BitManipulation;

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
     * This is the reference solution to this question, the solution comes from a
     * discussion for a series of similar questions. The detailed explanation is on leetcode.
     * @param nums the array of numbers to be considered.
     * @return the single number which occurs only once.
     */
    public static int solutionRef(int[] nums) {
        // we need to two counter and a mask.
        int x1 = 0;
        int x2 = 0;
        int mask = 0;
        for (int num : nums) {
            x2 ^= (x1 & num);
            x1 ^= num;
            mask = ~(x1 & x2);
            x1 &= mask;
            x2 &= mask;
        }
        return x1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {2, 1, 3, 1, 3, 3, 1};
        System.out.println(SingleNumberTwo.solutionRef(array));
    }

}
