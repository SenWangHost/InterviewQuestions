/**
 *
 */
package Math;

/**
 * Implement pow(x, n).
 * @author SenWang
 *
 */
public class PowerXN {
    /**
     * this is the reference solution to this question.
     */
    public static double solution(double x, int n) {
        if (n < 0) {
            return 1 / x * solution(1/ x, -(n + 1));
        }
        if (n == 0) {
            return 1;
        }
        if (n == 2) {
            return x * x;
        }
        if (n % 2 == 0) {
            return solution(solution(x, n / 2), 2);
        } else {
            return x * solution(solution(x, n / 2), 2);
        }
    }
    /**
     * this is another reference solution to this question, which uses
     * double x strategy
     */
    public static double solutionRef2(double x, int n) {
        if (n == 0) {
            return 1;
        }
        double temp = x;
        temp = solutionRef2(x, n / 2);
        if (n % 2 == 0) {
            return temp * temp;
        } else {
            if (n > 0) {
                return x * temp * temp;
            } else {
                return temp * temp / x;
            }
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solution(2, Integer.MAX_VALUE));
    }

}
