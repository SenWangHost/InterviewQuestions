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
     * This is one of the reference solution to this question, which uses the partition function
     * in the quick sort to determine the kth largest element.
     * @param nums the array of numbers to be considered.
     * @param k the kth largest number in the array
     * @return the kth largest number in the array
     */
    public static int solutionRef(int[] nums, int k) {
        return partition(nums, 0, nums.length - 1, nums.length - k);
    }
    /**
     * This is the helper function for the reference solution above.
     * @param nums the array of numbers to be considered.
     * @param low the lower index of the array.
     * @param high the higher index of the array.
     * @param k the kth largest element in the array.
     * @return the kth largest element in the array.
     */
    private static int partition(int[] nums, int low, int high, int k) {
        if (low >= high) {
            return Integer.MAX_VALUE;
        }
        int pivot = nums[high];
        int i = low;
        int j = high - 1;
        while (true) {
            while (nums[i] < pivot) {
                i++;
            }
            while (j >= 0 && nums[j] > pivot) {
                j--;
            }
            if (i >= j) {
                break;
            } else {
                swap(nums, i, j);
            }
        }
        swap(nums, i, high);
//        return i;
        if (i == k) {
            return nums[i];
        } else if (i < k) {
            return partition(nums, i + 1, high, k);
        } else {
            return partition(nums, low, i - 1, k);
        }
    }
    /**
     * This is the helper function to swap two elements in the array.
     * @param array the array of numbers to be considered.
     * @param first the index of first number to be swapped.
     * @param second the index of second number to be swapped.
     */
    private static void swap(int[] array, int first, int second) {
        int temp = array[first];
        array[first] = array[second];
        array[second] = temp;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 4;
        int result = KthLargestElementInAnArray.solutionRef(nums, k);
        System.out.println(result);
//        int[] test = {42, 89, 63, 12, 94, 27, 78, 3, 50, 36};
//        System.out.println(partition(test, 0, test.length - 1, 0));
//        for (int num : test) {
//            System.out.print(num + " ");
//        }
    }

}
