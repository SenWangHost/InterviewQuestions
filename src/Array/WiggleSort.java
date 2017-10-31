/**
 *
 */
package Array;

/**
 * Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....
 * For example, given nums = [3, 5, 2, 1, 6, 4], one possible answer is [1, 6, 2, 5, 3, 4].
 * @author SenWang
 *
 */
public class WiggleSort {
    /**
     * this is reference solution to this question.
     */
    public static void solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (i % 2 == 1) {
                if (nums[i - 1] > nums[i]) {
                    swap(i - 1, i, nums);
                }
            } else if (i != 0 && nums[i - 1] < nums[i]) {
                swap(i - 1, i, nums);
            }
        }
    }
    /**
     * this is the swap function
     */
    private static void swap(int x, int y, int[] nums) {
        int temp = nums[x];
        nums[x] = nums[y];
        nums[y] = temp;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3,5,2,1,6,4};
        solution(nums);
        for (int num : nums) {
            System.out.println(num);
        }
    }

}
