/**
 *
 */
package BitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Now your job is to find the total Hamming distance between all pairs of the given numbers.
 * Example:
 * Input: 4, 14, 2
 * Output: 6
 * Explanation: In binary representation, the 4 is 0100, 14 is 1110, and 2 is 0010 (just
 * showing the four bits relevant in this case). So the answer will be:
 * HammingDistance(4, 14) + HammingDistance(4, 2) + HammingDistance(14, 2) = 2 + 2 + 2 = 6.
 * Note:
 * 1. Elements of the given array are in the range of 0 to 10^9
 * 2. Length of the array will not exceed 10^4.
 * @author SenWang
 *
 */
public class TotalHammingDistance {
    /**
     * This is my own solution to this question. The idea is to constrcut this result from bit to bit.
     * Consider the rightmost bit of all the numbers in the array. If there i numbers that their rightmost bit
     * is 1 and there j numbers that their rightmost bit is 0, they will contribute i * j to the final result,
     * because there are total i * j possible ways to make the rightmost bit different.
     * @param nums an array of integers to be considered.
     * @return the total hamming distance of the array.
     */
    public static int solutionRef(int[] nums) {
        int result = 0;
        int bitcount = 0;
        for (int i = 0; i < 32; i++) {
            for (int j = 0; j < nums.length; j++) {
                bitcount += ((nums[j] >> i) & 1);
            }
            result += bitcount * (nums.length - bitcount);
            bitcount = 0;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {4, 14, 2};
        int result = TotalHammingDistance.solutionRef(test);
        System.out.println(result);
    }

}
