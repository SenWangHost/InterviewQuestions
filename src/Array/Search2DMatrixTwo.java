/**
 *
 */
package Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 *
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 *
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   4,  7, 11, 15],
 *  [2,   5,  8, 12, 19],
 *  [3,   6,  9, 16, 22],
 *  [10, 13, 14, 17, 24],
 *  [18, 21, 23, 26, 30]
 * ]
 * Given target = 5, return true.
 * Given target = 20, return false.
 * @author SenWang
 *
 */
public class Search2DMatrixTwo {
    /**
     * this is my own solution to this question.
     */
    public static boolean solution(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return false;
        }
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            int low = matrix[i][0];
            int high = matrix[i][col - 1];
            if (target >= low && target <= high && binarySearch(matrix[i], target)) {
                return true;
            }
        }
        return false;
    }
    /**
     *
     */
    private static boolean binarySearch(int[] sorted, int target) {
        int start = 0;
        int end = sorted.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (sorted[mid] == target) {
                return true;
            } else if (sorted[mid] > target) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return false;
    }
    /**
     * this is reference solution to this question, rule out one row or one col at each comparison
     */
    public static boolean solutionRef(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        int row = 0;
        int col = matrix[0].length - 1;
        while (col >= 0 && row < matrix.length) {
            if (matrix[row][col] == target) {
                return true;
            } else if (matrix[row][col] > target) {
                row++;
            } else {
                col--;
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

    }

}
