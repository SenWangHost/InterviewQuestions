/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given two arrays (without duplicates) nums1 and nums2 where nums1’s elements are subset of nums2.
 * Find all the next greater numbers for nums1's elements in the corresponding places of nums2.
 * The Next Greater Number of a number x in nums1 is the first greater number to its right in nums2.
 * If it does not exist, output -1 for this number.
 *
 * Example 1:
 * Input: nums1 = [4,1,2], nums2 = [1,3,4,2].
 * Output: [-1,3,-1]
 * Explanation:
 * For number 4 in the first array, you cannot find the next greater number for it in the second array, so output -1.
 * For number 1 in the first array, the next greater number for it in the second array is 3.
 * For number 2 in the first array, there is no next greater number for it in the second array, so output -1.
 *
 * Example 2:
 * Input: nums1 = [2,4], nums2 = [1,2,3,4].
 * Output: [3,-1]
 * Explanation:
 * For number 2 in the first array, the next greater number for it in the second array is 3.
 * For number 4 in the first array, there is no next greater number for it in the second array, so output -1.
 * Note:
 * 1. All elements in nums1 and nums2 are unique.
 * 2. The length of both nums1 and nums2 would not exceed 1000.
 * @author SenWang
 *
 */
public class NextGreaterElementOne {
    /**
     * This is my own solution to this question. This solution uses two stack
     * to find the greater element.
     * @param findNums the array of numbers to find.
     * @param nums the array of numbers to be considered.
     * @return the array of integer which contains the finding result.
     */
    public static int[] solution(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Deque<Integer> mainStack = new ArrayDeque<Integer>();
        Deque<Integer> memStack = new ArrayDeque<Integer>();
        for (int i = 0; i < nums.length; i++) {
            mainStack.push(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++) {
            int target = findNums[i];
            int temp = mainStack.peek();
            // find the target element in the array
            while (!mainStack.isEmpty() && temp != target) {
                int number = mainStack.pop();
                memStack.push(number);
                temp = mainStack.peek();
            }
            // try to find the next greater element.
            while (!memStack.isEmpty()) {
                int comp = memStack.peek();
                if (comp > target) {
                    result[i] = comp;
                    break;
                } else {
                    mainStack.push(memStack.pop());
                }
            }
            if (memStack.isEmpty()) {
                result[i] = -1;
            }
            // restore the main stack.
            while (!memStack.isEmpty()) {
                int number = memStack.pop();
                mainStack.push(number);
            }
        }
        return result;
    }
    /**
     * This is another solution of mine, which only uses one stack
     * to keep track of greater element that have comes across.
     * @param findNums the array of numbers to find.
     * @param nums the array of numbers to be considered.
     * @return the array of integer which contains the finding result.
     */
    public static int[] solution2(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        for (int i = 0; i < findNums.length; i++) {
            int target = findNums[i];
            for (int j = nums.length - 1; j >= 0; j--) {
                if (nums[j] != target) {
                    stack.push(nums[j]);
                } else {
                    break;
                }
            }
            while (!stack.isEmpty()) {
                int comp = stack.peek();
                if (comp > target) {
                    result[i] = comp;
                    break;
                } else {
                    stack.pop();
                }
            }
            if (stack.isEmpty()) {
                result[i] = -1;
            } else {
                stack.clear();
            }
        }
        return result;
    }
    /**
     * This is the reference solution to this question. This solution uses
     * both the hashMap and the stack. The hashMap is used to improve the
     * efficiency of finding the number in the array. The stack is used to keep track
     * of the previous larger element.
     */
    public static int[] solutionRef(int[] findNums, int[] nums) {
        int[] result = new int[findNums.length];
        Deque<Integer> stack = new ArrayDeque<Integer>();
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                map.put(nums[i], -1);
            } else {
                map.put(nums[i], stack.peek());
            }
            stack.push(nums[i]);
        }
        for (int i = 0; i < findNums.length; i++) {
            result[i] = map.get(findNums[i]);
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] findNums = {1, 3, 5, 2, 4};
        int[] nums = {6, 5, 4, 3, 2, 1, 7};
        int[] result = NextGreaterElementOne.solution2(findNums, nums);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
