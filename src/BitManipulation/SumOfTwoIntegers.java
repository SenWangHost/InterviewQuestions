/**
 *
 */
package BitManipulation;

/**
 * Calculate the sum of two integers a and b, but you are not allowed to use the operator + and -.
 * Example:
 * Given a = 1 and b = 2, return 3.
 * @author SenWang
 *
 */
public class SumOfTwoIntegers {
    /**
     * This is my own solution to this question.
     * @param a the first integer to be considered.
     * @param b the second integer to be considered.
     * @return the sum to two input integers
     */
    public static int solution(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        // use xor to calculate the adding operation
        // use and to calculate the carry bit
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
    /**
     * This is the recursive solution to this question.
     * @param a the first integer to be considered.
     * @param b the second integer to be considered.
     * @return the sum to two input integers
     */
    public static int solution2(int a, int b) {
        if (b == 0) {
            return a;
        }
        return solution2(a ^ b, (a & b) << 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int a = 3;
        int b = 8;
        System.out.println(SumOfTwoIntegers.solution2(a, b));
    }

}
