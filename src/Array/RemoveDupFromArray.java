/**
 *
 */
package Array;

/**
 * Given a sorted array, remove the duplicates in place such that each element appear only once and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 *
 * For example,
 * Given input array nums = [1,1,2],
 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
 * It doesn't matter what you leave beyond the new length.
 * @author SenWang
 *
 */
public class RemoveDupFromArray {
    /**
     * This is my own solution for this question. This solution is not acceptable because the runtime complexity is n^2
     * @param nums the input array of nums for removing duplicates
     * @return the length of the array that duplicates were removed.
     */
    public int solution(int[] nums) {
        int size = nums.length;
        for (int i = 0; i < size - 1; i++) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size -= 1;
                i -= 1;
            }
        }
        return size;
    }
    /**
     * The reference solution for this question.
     * @param nums the input array of nums for removing duplicates
     * @return the length of the array that duplicates were removed.
     */
    public int solutionRef(int[] nums) {
        int count = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] == nums[i - 1]) {
                // count how many duplicates are in the array
                count += 1;
            } else {
                // replace the position with no-duplicate number.
                nums[i - count] = nums[i];
            }
        }
        return nums.length - count;
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RemoveDupFromArray test = new RemoveDupFromArray();
        int[] nums = {1, 1, 1, 2};
        int result = test.solutionRef(nums);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
