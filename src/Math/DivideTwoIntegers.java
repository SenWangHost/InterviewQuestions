/**
 *
 */
package Math;

/**
 * Divide two integers without using multiplication, division and mod operator.
 * If it is overflow, return MAX_INT.
 * @author SenWang
 *
 */
public class DivideTwoIntegers {
    /**
     * this is the reference solution to this question.
     */
    public static int solution(int dividend, int divisor) {
        // Reduce the problem to positive long integer to make it easier.
        // Use long to avoid integer overflow cases.
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 || divisor > 0)) {
            sign = -1;
        }
        long ldividend = Math.abs((long) dividend);
        long ldivisor = Math.abs((long) divisor);
        // take care of the edge case
        if (ldivisor == 0) {
            return Integer.MAX_VALUE;
        }
        if (ldividend == 0 || ldividend < ldivisor) {
            return 0;
        }
        long lan = ldivide(ldividend, ldivisor);
        if (lan > Integer.MAX_VALUE) {
            if (sign == 1) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.MIN_VALUE;
            }
        } else {
            return (int) (lan * sign);
        }
    }
    /**
     * this is the helper function to divide two long
     */
    private static long ldivide(long ldividend, long ldivisor) {
        if (ldividend < ldivisor) {
            return 0;
        }
        long sum = ldivisor;
        long multiple = 1;
        while ((sum + sum) < ldividend) {
            sum += sum;
            multiple += multiple;
        }
        return multiple + ldivide(ldividend - sum, ldivisor);
    }
    /**
     * this is another solution to this question, which uses bit manipulation
     */
    public static int solution2(int dividend, int divisor) {
        if (divisor == 0 || (dividend == Integer.MIN_VALUE && divisor == -1)) {
            return Integer.MAX_VALUE;
        }
        int sign = 1;
        if ((dividend > 0 && divisor < 0) || (dividend < 0 && divisor > 0)) {
            sign = -1;
        }
        int result = 0;
        long ldividend = Math.abs(dividend);
        long ldivisor = Math.abs(divisor);
        while (ldividend >= ldivisor) {
            long temp = ldivisor;
            long multiple = 1;
            while (ldividend >= (temp << 1)) {
                temp <<= 1;
                multiple <<= 1;
            }
            ldividend -= temp;
            result += multiple;
        }
        if (sign == 1) {
            return result;
        } else {
            return -result;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(Integer.MIN_VALUE);
    }

}
