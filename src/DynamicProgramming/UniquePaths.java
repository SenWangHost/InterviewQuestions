/**
 *
 */
package DynamicProgramming;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time. The robot is trying to reach the
 * bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 * @author SenWang
 *
 */
public class UniquePaths {
    /**
     * This is my own solution to this question, which uses dynamic programming.
     * @param m the number of columns.
     * @param n the number of rows.
     * @return the number of unique path from upper left to bottom right.
     */
    public static int solution(int m, int n) {
        int row = m + n - 1;
        int col = n;
        int[][] dp = new int[m + n - 1][n];
        for (int i = 0; i < row; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i - 1][j - 1];
            }
        }
        return dp[m + n - 2][n - 1];
    }
    /**
     * This is one of the reference solution. Basically, the problem is to calculate binomial
     * coefficient, which we use formula to calculate. But I prefer dp solution.
     * @param m the number of columns.
     * @param n the number of rows.
     * @return the number of unique path from upper left to bottom right.
     */
    public static int solutionRef(int m, int n) {
        int base = m + n - 2;
        int coeff = m - 1;
        double result = 1;
        // here we calculate the total possible path number
        // Combination(N, k) = n! / (k!(n - k)!)
        // reduce the numerator and denominator and get
        // C = ( (n - k + 1) * (n - k + 2) * ... * n ) / k!
        for (int i = 1; i <= coeff; i++) {
            result = result * (base - coeff + i) / i;
        }
        return (int) result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int m = 3;
        int n = 7;
        System.out.println(UniquePaths.solutionRef(m, n));
    }

}
