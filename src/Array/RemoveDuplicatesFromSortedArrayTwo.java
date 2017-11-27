/**
 *
 */
package Array;

/**
 * Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.
 * @author SenWang
 *
 */
public class RemoveDuplicatesFromSortedArrayTwo {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int[] copy = new int[nums.length];
        int base = nums[0];
        int count = 0;
        int j = 0;
        for (int n : nums) {
            if (n == base) {
                count++;
            } else {
                base = n;
                count = 1;
            }
            if (count <= 2) {
                copy[j] = base;
                j++;
            }
        }
        for (int i = 0; i < j; i++) {
            nums[i] = copy[i];
        }
        return j;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
