/**
 *
 */
package Math;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 * @author SenWang
 *
 */
public class FactorialTrailingZeroes {
    /**
     * this is the reference solution to this, the idea is simple.
     * all zeroes come from factor 2 and factor 5, and in the range of 1 to n, the number of factor 5
     * is always less than the number of 2, so we just need to find out the number 5 factor in the factorial.
     *
     * This is the recursive version
     */
    public static int solution(int n) {
        if (n == 0) {
            return 0;
        }
        return n / 5 + solution(n / 5);
    }
    /**
     * the iterative version of the solution
     */
    public static int solution2(int n) {
        int result = 0;
        while (n > 0) {
            n /= 5;
            result += n;
        }
        return result;
    }
    /**
     * this is the test function for this question.
     */
    public static void main(String[] args) {

    }
}
