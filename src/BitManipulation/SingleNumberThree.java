/**
 *
 */
package BitManipulation;

/**
 * Given an array of numbers, in which exactly two elements appear only once and all the other
 * elements appear exactly twice. Find the two elements that appear only once.
 * For example:
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * Note:
 * 1. The order of the result is not important. So in the above example, [5, 3] is also correct.
 * 2. Your algorithm should run in linear runtime complexity. Could you implement it using only constant space complexity?
 * @author SenWang
 *
 */
public class SingleNumberThree {
    /**
     * This is my own solution to this question.
     * @param nums the array of numbers to be considered.
     * @return the two numbers that occur only once.
     */
    public static int[] solutionRef(int[] nums) {
        int xorResult = 0;
        for (int num : nums) {
            xorResult ^= num;
        }
        // get the rightmost set bit using two's complement.
        int rightMostSet = xorResult & (-xorResult);
        // use the right most set bit to partition the array and get the two
        // single number by xor.
        int[] result = new int[2];
        for (int num : nums) {
            if ((num & rightMostSet) == 0) {
                result[0] ^= num;
            } else {
                result[1] ^= num;
            }
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] array = {1, 2, 1, 3, 2, 5};
        int[] result = SingleNumberThree.solutionRef(array);
        for (int num : result) {
            System.out.println(num);
        }
    }
}
