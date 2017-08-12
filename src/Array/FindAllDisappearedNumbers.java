/**
 *
 */
package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
 * Find all the elements of [1, n] inclusive that do not appear in this array.
 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
 *
 * Example:
 * Input:
 * [4,3,2,7,8,2,3,1]
 * Output:
 * [5,6]
 * @author SenWang
 */
public class FindAllDisappearedNumbers {
    /**
     * This is the reference solution to this question. The idea is to find the missing
     * number by by find their indexes, because if there are not missing numbers in the
     * array, nums[i] = i + 1 -> i = nums[i] - 1. Then, we mark the indexes by negating
     * the number at that index. Then, we loop through the array again and find the number
     * that are not negated.
     * and the runtime complexity would be O(n * log(n)).
     * @param nums the array of numbers to be considered.
     * @return an arraylist that contains the answer.
     */
    public static List<Integer> solutionRef(int[] nums) {
        int n = nums.length;
        List<Integer> result = new ArrayList<Integer>();
        // mark the index we have seen during the first loop through.
        for (int i = 0; i < n; i++) {
            int shouldBeIndex = Math.abs(nums[i]) - 1;
            if (nums[shouldBeIndex] > 0) {
                nums[shouldBeIndex] *= -1;
            }
        }
        // find the non-negative numbers during the second loop through.
        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                result.add(i + 1);
            }
        }
        return result;
    }
    /**
     * This is another reference solution from the leetcode.
     * The idea is simple, if nums[i] != i + 1 and nums[i] != nums[nums[i] - 1],
     * then we swap nums[i] with nums[nums[i] - 1], for example, nums[0] = 4 and nums[3] = 7,
     * then we swap nums[0] with nums[3]. So In the end the array will be sorted and if nums[i] != i + 1,
     * then i + 1 is missing.
     * @param nums the array of numbers to be considered.
     * @return an arraylist that contains the answer.
     */
    public static List<Integer> solutionRef2(int[] nums) {
        List<Integer> result = new ArrayList<Integer>();
        // swap the element into its should-be position.
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[i];
                nums[i] = nums[temp - 1];
                nums[temp - 1] = temp;
            }
        }
        // find the element that is not in its should-be position.
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }
    /**
     * This is test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {4, 3, 2, 7, 8, 2, 3, 1};
        List<Integer> result = FindAllDisappearedNumbers.solutionRef2(test);
        Iterator<Integer> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }

}
