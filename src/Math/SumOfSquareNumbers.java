/**
 *
 */
package Math;

/**
 * Given a non-negative integer c, your task is to decide whether there're two integers a and b such that a2 + b2 = c.
 *
 * Example 1:
 * Input: 5
 * Output: True
 * Explanation: 1 * 1 + 2 * 2 = 5
 *
 * Example 2:
 * Input: 3
 * Output: False
 * @author SenWang
 *
 */
public class SumOfSquareNumbers {
    /**
     * This is my own solution to this question, which checks whether c - a^2 is
     * a perfect square.
     * @param c the number to be determined.
     * @return true if it is sum of square numbers, false otherwise.
     */
    public static boolean solution(int c) {
        for (long a = 0; a * a <= c; a++) {
            double remain = Math.sqrt(c - a * a);
            if (remain == (int) remain) {
                return true;
            }
        }
        return false;
    }
    /**
     * This is one of the reference solution to this question, which makes
     * use of binary search when checking whether c - a^2 is a perfect square.
     * @param c the number to be determined.
     * @return true if it is sum of square numbers, false otherwise.
     */
    public static boolean solutionRef(int c) {
        for (long a = 0; a * a <= c; a++) {
            int upper = c - (int) (a * a);
            if (binarySearch(0, upper, upper)) {
                return true;
            }
        }
        return false;
    }
    /**
     * This is the helper function to check whether mid * mid = target
     * using binary search.
     * @param low the lower limit for searching.
     * @param high the upper limit for searching.
     * @param target the square to be checked
     * @return true if mid * mid == target exists, false otherwise.
     */
    private static boolean binarySearch(long low, long high, int target) {
        while (low <= high) {
            long mid = (high - low) / 2 + low;
            if (mid * mid == target) {
                return true;
            } else if (mid * mid > target) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 5;
        boolean result = SumOfSquareNumbers.solutionRef(test);
        System.out.println(result);
    }
}
