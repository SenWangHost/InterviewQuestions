/**
 *
 */
package BitManipulation;

/**
 * Given a positive integer, output its complement number. The complement strategy is to
 * flip the bits of its binary representation.
 *
 * Note:
 *
 * The given integer is guaranteed to fit within the range of a 32-bit signed integer.
 * You could assume no leading zero bit in the integer’s binary representation.
 *
 * Example 1:
 * Input: 5
 * Output: 2
 * Explanation: The binary representation of 5 is 101 (no leading zero bits), and its complement is 010.
 * So you need to output 2.
 *
 * Example 2:
 * Input: 1
 * Output: 0
 * Explanation: The binary representation of 1 is 1 (no leading zero bits), and its complement is 0.
 * So you need to output 0.
 * @author SenWang
 *
 */
public class NumberComplement {
    /**
     * This is my own solution to this question.
     * @param num the input number to be considered.
     * @return the complement of this number.
     */
    public static int solution(int num) {
        int range = 0;
        int temp = num;
        while (temp > 0) {
            temp >>= 1;
            range++;
        }
        int mask = ~(-1 << range);
        return (~num) & mask;
    }
    /**
     * This is one of the reference solutions to this question, which uses
     * java built in function to get the highest one bit.
     * @param num the input number to be considered.
     * @return the complement of this number
     */
    public static int solutionRef(int num) {
        return (~num) & ((Integer.highestOneBit(num) << 1) - 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 1;
        System.out.println(solutionRef(test));
    }

}
