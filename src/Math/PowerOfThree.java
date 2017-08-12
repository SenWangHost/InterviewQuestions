/**
 *
 */
package Math;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * Follow up:
 * Could you do it without using any loop / recursion?
 * @author SenWang
 *
 */
public class PowerOfThree {
    /**
     * This is my own solution to this question.
     * @param n the integer to be determined.
     * @return true if the integer is a power of three, false otherwise.
     */
    public static boolean solution(int n) {
        if (n <= 0) {
            return false;
        }
        while (n > 1) {
            if (n % 3 != 0) {
                return false;
            }
            n /= 3;
        }
        return true;
    }
    /**
     * This is one reference solution to this question, which makes use
     * of the idea to find the maximum integer that is power of three and
     * check whether the input is a multiple of it.
     * @param n the integer to be determined.
     * @return true if the integer is a power of three, false otherwise.
     */
    public static boolean solutionRef(int n) {
        int maxPowerOfThree = (int) Math.pow(3, (int) (Math.log(0x7fffffff) / Math.log(3)));
        return n > 0 && maxPowerOfThree % n == 0;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 25;
        boolean result = PowerOfThree.solution(test);
        System.out.println(result);
    }
}
