/**
 *
 */
package HashTable;

/**
 * Given two sparse matrices A and B, return the result of AB.
 * You may assume that A's column number is equal to B's row number.
 *
 * Example:
 * A = [
 * [ 1, 0, 0],
 * [-1, 0, 3]
 * ]
 *
 * B = [
 * [ 7, 0, 0 ],
 * [ 0, 0, 0 ],
 * [ 0, 0, 1 ]
 * ]


     |  1 0 0 |   | 7 0 0 |   |  7 0 0 |
AB = | -1 0 3 | x | 0 0 0 | = | -7 0 3 |
                  | 0 0 1 |
 * @author SenWang
 *
 */
public class SparseMatrixMultiplication {
    /**
     * this is my own solution to this question.
     */
    public static int[][] solution(int[][] A, int[][] B) {
        int rowA = A.length;
        int col = A[0].length;
        int colB = B[0].length;
        int[][] result = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int j = 0; j < colB; j++) {
                for (int k = 0; k < col; k++) {
                    result[i][j] += A[i][k] * B[k][j];
                }
            }
        }
        return result;
    }
    /**
     * this is the reference solution to this question, skip the loop if one of
     * multiplication factor is zero
     */
    public static int[][] solutionRef(int[][] A, int[][] B) {
        int rowA = A.length;
        int col = A[0].length;
        int colB = B[0].length;
        int[][] result = new int[rowA][colB];
        for (int i = 0; i < rowA; i++) {
            for (int k = 0; k < col; k++) {
                if (A[i][k] != 0) {
                    for (int j = 0; j < colB; j++) {
                        if (B[k][j] != 0) {
                            result[i][j] += A[i][k] * B[k][j];
                        }
                    }
                }
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

    }

}
