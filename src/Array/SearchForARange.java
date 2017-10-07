/**
 *
 */
package Array;

/**
 * Given an array of integers sorted in ascending order, find the starting and ending
 * position of a given target value.
 *
 * Your algorithm's runtime complexity must be in the order of O(log n).
 * If the target is not found in the array, return [-1, -1].
 * For example,
 * Given [5, 7, 7, 8, 8, 10] and target value 8,
 * return [3, 4].
 * @author SenWang
 *
 */
public class SearchForARange {
    /**
     * this is my own solution to this question.
     */
    public static int[] solution(int[] nums, int target) {
        int length = nums.length;
        int low = 0;
        int high = length - 1;
        int[] result = {-1, -1};
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] == target) {
                int left = mid;
                int right = mid;
                while (right + 1 < length && nums[right + 1] == target) {
                    right += 1;
                }
                while (left - 1 >= 0 && nums[left - 1] == target) {
                    left -= 1;
                }
                result[0] = left;
                result[1] = right;
                return result;
            } else if (nums[mid] > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return result;
    }
    /**
     * this is the reference solution to this question, which would be strictly O(log(n)),
     * and uses recursion.
     */
    public static int[] solutionRef(int[] nums, int target) {
        int[] range = {nums.length, -1};
        solutionHelper(nums, target, 0, nums.length - 1, range);
        if (range[0] > range[1]) {
            range[0] = -1;
        }
        return range;
    }
    /**
     * this is the helper function for this question.
     */
    private static void solutionHelper(int[] nums, int target, int left, int right, int[] range) {
        if (left > right) {
            return;
        }
        int mid = left + (right - left) / 2;
        if (nums[mid] == target) {
            if (mid < range[0]) {
                range[0] = mid;
                solutionHelper(nums, target, left, mid - 1, range);
            }
            if (mid > range[1]) {
                range[1] = mid;
                solutionHelper(nums, target, mid + 1, right, range);
            }
        } else if (nums[mid] < target) {
            solutionHelper(nums, target, mid + 1, right, range);
        } else {
            solutionHelper(nums, target, left, mid - 1, range);
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {3, 4, 4, 4, 5, 7, 7, 8, 8, 10};
        int[] result = solution(array, 10);
        for (int num : result) {
            System.out.println(num);
        }
    }

}
