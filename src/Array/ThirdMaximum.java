/**
 *
 */
package Array;

import java.util.TreeSet;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 *
 * Example 1:
 * Input: [3, 2, 1]
 * Output: 1
 * Explanation: The third maximum is 1.
 *
 * Example 2:
 * Input: [1, 2]
 * Output: 2
 * Explanation: The third maximum does not exist, so the maximum (2) is returned instead.
 *
 * Example 3:
 * Input: [2, 2, 3, 1]
 * Output: 1
 * Explanation: Note that the third maximum here means the third maximum distinct number.
 * Both numbers with value 2 are both considered as second maximum.
 * @author SenWang
 *
 */
public class ThirdMaximum {
    /**
     * This is my own solution to this question. This solution is acceptable and runtime
     * complexity is pretty good and beats 98%. However, the tricky part is how to deal with
     * the input containing the min value of integer, which makes the code look ugly.
     * @param nums the array of numbers to be considered.
     * @return the third maximum number, if it doesn't exist, return the maximum number.
     */
    public static int solution(int[] nums) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        int thirdMax = Integer.MIN_VALUE;
        boolean min = false;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > max) {
                int temp1 = max;
                int temp2 = secMax;
                max = nums[i];
                secMax = temp1;
                thirdMax = temp2;
            } else if (nums[i] > secMax && nums[i] < max) {
                int temp = secMax;
                secMax = nums[i];
                thirdMax = temp;
            } else if (nums[i] > thirdMax && nums[i] < secMax) {
                thirdMax = nums[i];
            }
            if (nums[i] == Integer.MIN_VALUE) {
                nums[i]++;
                i--;
                min = true;
            }
        }
        if (thirdMax == Integer.MIN_VALUE) {
            return max;
        } else if (min == true && thirdMax == Integer.MIN_VALUE + 1) {
            return thirdMax - 1;
        } else {
            return thirdMax;
        }
    }
    /**
     * The reference solution comes from other people's posts.
     * which makes use of tree set data structure.
     * @param nums the array of numbers to be considered.
     * @return the third maximum number, if it doesn't exist, return the maximum number.
     */
    public static int solutionRef(int[] nums) {
        TreeSet<Integer> set = new TreeSet<Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (set.contains(nums[i])) {
                continue;
            }
            if (set.size() < 3 || nums[i] > set.first()) {
                if (set.size() == 3) {
                    set.remove(set.first());
                }
                set.add(nums[i]);
            }
        }
        if (set.size() == 3) {
            return set.first();
        } else {
            return set.last();
        }
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, Integer.MIN_VALUE};
        int result = ThirdMaximum.solutionRef(test);
        System.out.println(result);
    }

}
