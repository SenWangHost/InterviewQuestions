/**
 *
 */
package Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.
 * @author SenWang
 *
 */
public class SearchInRotatedSortedArray {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }
        if (nums.length == 1) {
            if (nums[0] == target) {
                return 0;
            } else {
                return -1;
            }
        }
        int i = 1;
        while (i < nums.length && nums[i - 1] < nums[i]) {
            i++;
        }
        if (i >= nums.length) {
            return binarySearch(nums, 0, nums.length - 1, target);
        } else {
            if (target <= nums[i - 1] && target >= nums[0]) {
                return binarySearch(nums, 0, i - 1, target);
            } else {
                return binarySearch(nums, i, nums.length - 1, target);
            }
        }
    }
    /**
     * the helper function for binary search
     */
    private static int binarySearch(int[] nums, int start, int end, int target) {
        while (start <= end) {
            int mid = (end - start) / 2 + start;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
