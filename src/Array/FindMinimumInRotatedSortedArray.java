/**
 *
 */
package Array;

/**
 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

Find the minimum element.

You may assume no duplicate exists in the array.
 * @author SenWang
 *
 */
public class FindMinimumInRotatedSortedArray {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int[] nums) {
        int min1 = nums[0];
        int min2 = Integer.MAX_VALUE;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > nums[i]) {
                min2 = nums[i];
                break;
            }
        }
        return Math.min(min1, min2);
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
