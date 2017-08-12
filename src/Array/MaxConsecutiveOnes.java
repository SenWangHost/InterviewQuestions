/**
 *
 */
package Array;

/**
 * Given a binary array, find the maximum number of consecutive 1s in this array.
 * Example 1:
 * Input: [1,1,0,1,1,1]
 * Output: 3
 * Explanation: The first two digits or the last three digits are consecutive 1s.
 * The maximum number of consecutive 1s is 3.
 *
 * Note:
 * The input array will only contain 0 and 1.
 * The length of input array is a positive integer and will not exceed 10,000
 * @author SenWang
 *
 */
public class MaxConsecutiveOnes {
    /**
     * This is my own solution to this question.
     * @param nums the array of numbers to be considered.
     * @return the length of maximum consecutive numbers.
     */
    public static int solution(int[] nums) {
        int result = 0;
        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 1) {
                count += 1;
            } else {
                if (count >= result) {
                    result = count;
                }
                count = 0;
            }
        }
        if (count >= result) {
            result = count;
        }
        return result;
    }
    /**
     * The reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {0, 1, 1, 0, 1, 1, 1, 0, 1, 0, 0, 1, 1, 1, 1};
        int result = MaxConsecutiveOnes.solution(test);
        System.out.println(result);
    }

}
