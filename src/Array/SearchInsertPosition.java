/**
 *
 */
package Array;

/**
 * Given a sorted array and a target value, return the index if the target is found.
 * If not, return the index where it would be if it were inserted in order.
 * You may assume no duplicates in the array.
 *
 * Here are few examples.
 * [1,3,5,6], 5 → 2
 * [1,3,5,6], 2 → 1
 * [1,3,5,6], 7 → 4
 * [1,3,5,6], 0 → 0
 * @author SenWang
 *
 */
public class SearchInsertPosition {
    /**
     * This is my own solution to this question. This solution is acceptable and the runtime complexity is O(n)
     * @param nums the array of numbers to be considered.
     * @param target the target number to be inserted.
     * @return the index of inserted position.
     */
    public static int solution(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                return i;
            } else if (target < nums[i]) {
                if (i == 0) {
                    return 0;
                }
                return i - 1;
            } else {
                if (i == nums.length - 1 || target < nums[i + 1]) {
                    return i + 1;
                }
            }
        }
        return -1;
    }
    /**
     * The reference solution uses the binary search method.
     * @param nums the array of numbers to be considered.
     * @param target the target number to be inserted.
     * @return the index of inserted position.
     */
    public static int solutionRef(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target > nums[mid]) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return low;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 3, 5, 6};
        int target = 7;
        int result = SearchInsertPosition.solution(test, target);
        System.out.println(result);
    }

}
