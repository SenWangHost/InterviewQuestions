/**
 *
 */
package BitManipulation;

/**
 * Write a function that takes an unsigned integer and returns the number of ’1' bits it has (also known as the Hamming weight).
 * For example, the 32-bit integer ’11' has binary representation 00000000000000000000000000001011, so the function should return 3.
 * @author SenWang
 *
 */
public class NumberOfOneBits {
    /**
     * This is my own solution to this question.
     * @param n the unsigned integer to be considered.
     * @return the number of 1 bits in this number.
     */
    public static int solution(int n) {
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((n & 1) == 1) {
                count++;
            }
            n = n >> 1;
        }
        return count;
    }
    /**
     * This is one of reference solutions to this question.
     * Instead of using bit shifting, it uses n & (n - 1) to clear the least significant '1' bit.
     * @param n the unsigned integer to be considered.
     * @return the number of 1 bits in this number.
     */
    public static int solutionRef(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = Integer.MAX_VALUE;
        System.out.println(NumberOfOneBits.solution(test));
    }

}
