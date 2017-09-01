/**
 *
 */
package Heap;

import java.util.Arrays;
import java.util.Map;
import java.util.TreeMap;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted
 * order, not the kth distinct element.
 *
 * For example,
 * Given [3,2,1,5,6,4] and k = 2, return 5.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ array's length.
 * @author SenWang
 *
 */
public class KthLargestElementInAnArray {
    /**
     * This is my own solution to this question, which uses heap to sort the array
     * @param nums the array of numbers to be considered.
     * @param k the kth largest number in the array
     * @return the kth largest number in the array
     */
    public static int solution(int[] nums, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> entry = map.pollLastEntry();
            count += entry.getValue();
            if (count >= k) {
                return entry.getKey();
            }
        }
        return 0;
    }
    /**
     * This is another solution of mine, which uses sorting algorithm.
     * @param nums the array of numbers to be considered.
     * @param k the kth largest number in the array
     * @return the kth largest number in the array
     */
    public static int solution2(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int result = KthLargestElementInAnArray.solution2(nums, k);
        System.out.println(result);
    }

}
