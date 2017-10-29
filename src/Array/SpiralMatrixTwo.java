/**
 *
 */
package Array;

/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.
 * For example,
 * Given n = 3,
 * You should return the following matrix:
 * [
 *  [ 1, 2, 3 ],
 *  [ 8, 9, 4 ],
 *  [ 7, 6, 5 ]
 * ]
 * @author SenWang
 *
 */
public class SpiralMatrixTwo {
    /**
     * this is my own solution to this question, which uses the same algorithm of the first question.
     */
    public static int[][] solution(int n) {
        int[][] result = new int[n][n];
        int rowBegin = 0;
        int rowEnd = n - 1;
        int colBegin = 0;
        int colEnd = n - 1;
        int num = 1;
        while (num <= n * n) {
            // traverse right
            for (int i = colBegin; i <= colEnd; i++) {
                result[rowBegin][i] = num;
                num++;
            }
            rowBegin++;
            // traverse down
            for (int i = rowBegin; i <= rowEnd; i++) {
                result[i][colEnd] = num;
                num++;
            }
            colEnd--;
            // traverse left
            if (colBegin <= colEnd) {
                for (int i = colEnd; i >= colBegin; i--) {
                    result[rowEnd][i] = num;
                    num++;
                }
                rowEnd--;
            }

            // traverse up
            if (rowBegin <= rowEnd) {
                for (int i = rowEnd; i >= rowBegin; i--) {
                    result[i][colBegin] = num;
                    num++;
                }
                colBegin++;
            }

        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 2;
        int[][] result = solution(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(result[i][j]);
            }
        }
    }

}
