/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given a sequence of n integers a1, a2, ..., an, a 132 pattern is a subsequence ai, aj, ak such that i < j < k
 * and ai < ak < aj. Design an algorithm that takes a list of n numbers as input and checks whether there is a 132
 * pattern in the list.
 * Note: n will be less than 15,000.
 *
 * Example 1:
 * Input: [1, 2, 3, 4]
 * Output: False
 * Explanation: There is no 132 pattern in the sequence.
 *
 * Example 2:
 * Input: [3, 1, 4, 2]
 * Output: True
 * Explanation: There is a 132 pattern in the sequence: [1, 4, 2].
 *
 * Example 3:
 * Input: [-1, 3, 2, 0]
 * Output: True
 * Explanation: There are three 132 patterns in the sequence: [-1, 3, 2], [-1, 3, 0] and [-1, 2, 0].
 * @author SenWang
 *
 */
public class OneThreeTwoPattern {
    /**
     * This is O(n^2) reference solution to this question. The detailed explanation is
     * on leetcode discussion board of this question.
     * The runtime complexity would be O(n^2)
     * @param nums the array of numbers to be input.
     * @return true if 132 pattern exists in the array, false othserwise.
     */
    public static boolean solutionRef1(int[] nums) {
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= min) {
                min = nums[i];
            }
            if (min == nums[i]) {
                continue;
            }
            for (int j = nums.length - 1; j > i; j--) {
                if (min < nums[j] && nums[j] < nums[i]) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This is second reference solution to this question.
     * The runtime complexity would be O(n).
     * @param nums the array of numbers to be input.
     * @return true if 132 pattern exists in the array, false othserwise.
     */
    public static boolean solutionRef2(int[] nums) {
        int[] arr = Arrays.copyOf(nums, nums.length);
        // prescan the array to store the min value of each subarray into the auxiliary array.
        for (int i = 1; i < nums.length; i++) {
            arr[i] = Math.min(nums[i - 1], arr[i - 1]);
        }

        for (int j = nums.length - 1, top = nums.length; j >= 0; j--) {
            if (nums[j] <= arr[j]) {
                continue;
            }
            while (top < nums.length && arr[top] <= arr[j]) {
                top++;
            }
            if (top < nums.length && nums[j] > arr[top]) {
                return true;
            }
            arr[--top] = nums[j];
        }

        return false;
    }
    /**
     * This is another reference solution, which uses stack to keep track
     * the min-max pair. The detailed explanation is on discussion section on leetcode.
     * @param nums the array of numbers to be input.
     * @return true if 132 pattern exists in the array, false othserwise.
     */
    public static boolean solutionRef3(int[] nums) {
        Deque<Pair> stack = new ArrayDeque<Pair>();
        for (int n : nums) {
            if (stack.isEmpty() || n < stack.peek().min) {
                stack.push(new Pair(n, n));
            } else if (n > stack.peek().min) {
                Pair last = stack.pop();
                if(n < last.max) {
                    return true;
                } else {
                    last.max = n;
                    while(!stack.isEmpty() && n >= stack.peek().max) {
                        stack.pop();
                    }
                    // At this time, n < stack.peek().max (if stack not empty)
                    if(!stack.isEmpty() && stack.peek().min < n)  {
                        return true;
                    }
                    stack.push(last);
                }
            }
        }
        return false;
    }
    /**
     * This is the pair of min-max to be pushed onto the stack.
     * @author SenWang
     */
    private static class Pair {
        /**
         * The min value.
         */
        private int min;
        /**
         * The max value.
         */
        private int max;
        /**
         * The constructor for the pair.
         * @param min the min value to be stored.
         * @param max the max value to be stored.
         */
        private Pair(int min, int max) {
            this.min = min;
            this.max = max;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test1 = {1, 2, 3, 4};
        int[] test2 = {3, 1, 4, 2};
        int[] test3 = {-1, 3, 2, 0};
        System.out.println(OneThreeTwoPattern.solutionRef1(test1));
        System.out.println(OneThreeTwoPattern.solutionRef1(test2));
        System.out.println(OneThreeTwoPattern.solutionRef1(test3));
    }

}
