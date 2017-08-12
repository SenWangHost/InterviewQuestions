/**
 *
 */
package Math;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * @author SenWang
 *
 */
public class PowerOfTwo {
    /**
     * This is the test function for this question.
     * @param n the number to be determined.
     * @return true if this number is a power of two, false otherwise.
     */
    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 2 != 0) {
                return false;
            }
            n /= 2;
        }
        return true;
    }
    /**
     * This is one reference solution to this question. The idea is
     * power of 2 means only 1 bit of n is 1, so use the n & (n - 1) == 0
     * to judge whether this is the case.
     * @param n the number to be determined.
     * @return true if this number is a power of two, false otherwise.
     */
    public static boolean solutionRef(int n) {
        if (n <= 0) {
            return false;
        }
        return (n & (n - 1)) == 0;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 32;
        boolean result = PowerOfTwo.solutionRef(test);
        System.out.println(result);
    }
}
