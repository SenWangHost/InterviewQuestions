/**
 *
 */
package Math;

/**
 * Implement int sqrt(int x).
 * Compute and return the square root of x.
 * @author SenWang
 *
 */
public class ImplementSqrt {
    /**
     * This is my own solution to this question. The runtime complexity would be
     * O(N), which is pretty bad for this question.
     * @param x the integer input to calculate the square root.
     * @return the square root of input integer.
     */
    public static int solution(int x) {
        if (x == 0) {
            return 0;
        }
        int result = 1;
        // to avoid overflow, use division instead of multiplication.
        while (x / result > result) {
            int upper = result + 1;
            // to avoid overflow, use division instead of multiplication.
            if (x / upper < upper) {
                return result;
            }
            result++;
        }
        return result;
    }
    /**
     * This is one reference solution. Instead of using linear search, we can
     * use binary search to locate the number.
     * @param x the integer input to calculate the square root.
     * @return the square root of input integer.
     */
    public static int solutionRef(int x) {
        if (x == 0) {
            return 0;
        }
        int low = 1;
        int high = x;
        int result = 0;
        while (low <= high) {
            int mid = (high - low) / 2 + low;
            if (x / mid >= mid) {
                low = mid + 1;
                result = mid;
            } else {
                high = mid - 1;
            }
        }
        return result;
    }
    /**
     * This is another reference solution to this question, which uses newton's method
     * to calculate the integer square root of a positive integer.
     * @param x the integer input to calculate the square root.
     * @return the square root of input integer.
     */
    public static int solutionRef2(int x) {
        long r = x;
        while (r * r > x) {
            r = (r + x / r) / 2;
        }
        return (int) r;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = Integer.MAX_VALUE;
        int result = ImplementSqrt.solutionRef2(test);
        System.out.println(result);
    }

}
