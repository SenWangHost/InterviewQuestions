/**
 *
 */
package Array;

/**
 * In MATLAB, there is a very useful function called 'reshape', which can reshape a matrix into a new one with different size but keep its original data.
 * You're given a matrix represented by a two-dimensional array, and two positive integers r and c representing the row number
 * and column number of the wanted reshaped matrix, respectively.
 * The reshaped matrix need to be filled with all the elements of the original matrix in the same row-traversing order as they were.
 * If the 'reshape' operation with given parameters is possible and legal, output the new reshaped matrix;
 * Otherwise, output the original matrix.
 *
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 1, c = 4
 * Output:
 * [[1,2,3,4]]
 * Explanation:
 * The row-traversing of nums is [1,2,3,4]. The new reshaped matrix is a 1 * 4 matrix, fill it row by row by using the previous list.
 *
 * Example 2:
 * Input:
 * nums =
 * [[1,2],
 * [3,4]]
 * r = 2, c = 4
 * Output:
 * [[1,2],
 * [3,4]]
 * Explanation:
 * There is no way to reshape a 2 * 2 matrix to a 2 * 4 matrix. So output the original matrix.
 * Note:
 * 1. The height and width of the given matrix is in range [1, 100].
 * 2. The given r and c are all positive.
 * @author SenWang
 *
 */
public class ReshapeTheMatrix {
    /**
     * this is my own solution to this question. This solution is acceptable and beats 60% of the answer.
     * The runtime complexity should be O(r * c)
     * @param nums the matrix to be reshaped.
     * @param r the row number that the new matrix needs to have.
     * @param c the column number that the new matrix needs to have.
     * @return the new reshaped matrix
     */
    public static int[][] solution(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row == r && col == c) {
            return nums;
        }
        if (row * col != r * c) {
            return nums;
        }
        // transform the input matrix into an array
        int[] array = new int[row * col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                array[i * col + j] = nums[i][j];
            }
        }
        // transform the array back to the new matrix
        int[][] result = new int[r][c];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                result[i][j] = array[i * c + j];
            }
        }
        return result;
    }
    /**
     * The reference solution to this question. The runtime complexity would be O(n * m).
     * @param nums the matrix to be reshaped.
     * @param r the row number that the new matrix needs to have.
     * @param c the column number that the new matrix needs to have.
     * @return the new reshaped matrix
     */
    public static int[][] solutionRef(int[][] nums, int r, int c) {
        int row = nums.length;
        int col = nums[0].length;
        if (row == r && col == c) {
            return nums;
        }
        if (row * col != r * c) {
            return nums;
        }
        int[][] result = new int[r][c];
        // use integer division and mod operation.
        for (int i = 0; i < row * col; i++) {
            result[i / c][i % c] = nums[i / col][i % col];
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] test = {{1, 2}, {3, 4}};
        int[][] result = ReshapeTheMatrix.solutionRef(test, 1, 4);
        for (int i = 0; i < result.length; i++) {
            System.out.print("[");
            for (int j = 0; j < result[0].length; j++) {
                System.out.print(result[i][j] + ", ");
            }
            System.out.print("]");
        }
    }

}
