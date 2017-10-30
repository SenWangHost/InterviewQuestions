/**
 *
 */
package BinarySearch;

/**
 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
 * prove that at least one duplicate number must exist. Assume that there is only one duplicate number, find the duplicate one
 * Note:
 * 1. You must not modify the array (assume the array is read only).
 * 2. You must use only constant, O(1) extra space.
 * 3. Your runtime complexity should be less than O(n2).
 * 4. There is only one duplicate number in the array, but it could be repeated more than once.
 * @author SenWang
 *
 */
public class FindDuplicateNumber {
    /**
     * this is one of the reference solution to this question.
     */
    public static int solution(int[] nums) {
        int start = 1;
        int end = nums.length - 1;
        while (start < end) {
            int mid = start + (end - start) / 2;
            int count = 0;
            for (int num : nums) {
                if (num <= mid) {
                    count++;
                }
            }
            if (count <= mid) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        return start;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
