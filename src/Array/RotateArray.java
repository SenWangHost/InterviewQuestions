/**
 *
 */
package Array;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Rotate an array of n elements to the right by k steps.
 * For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
 * Note:
 * Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 *
 * @author SenWang
 */
public class RotateArray {
    /**
     * This is my own solution to this question. Use the data structure queue.
     * @param nums the array of numbers to be considered.
     * @param k the number of steps to rotate
     */
    public static void solution(int[] nums, int k) {
        Deque<Integer> queue = new LinkedList<Integer>();
        for (int i = 0; i < nums.length; i++) {
            queue.addLast(nums[i]);
        }
        for (int i = 0; i < k; i++) {
            int temp = queue.removeLast();
            queue.addFirst(temp);
        }
        for (int i = 0; i < nums.length; i++) {
            nums[i] = queue.pollFirst();
        }
    }
    /**
     * This is another solution to this question, which doesn't use any
     * data structures and any data structures and modify the array in place.
     * @param nums the array of numbers to be considered.
     * @param k the number of steps to rotate
     */
    public static void solution2(int[] nums, int k) {
        int size = nums.length;
        k = k % size;
        if (k > 0 && k < size) {
            int[] temp = new int[size - k];
            for (int i = 0; i < size; i++) {
                if (i < size - k) {
                    temp[i] = nums[i];
                }
                if (i < k) {
                    nums[i] = nums[i + size - k];
                }
            }
            for (int i = 0; i < size - k; i++) {
                nums[k + i] = temp[i];
            }
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3, 4, 5, 6, 7};
        RotateArray.solution2(test, 7);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ", ");
        }
    }

}
