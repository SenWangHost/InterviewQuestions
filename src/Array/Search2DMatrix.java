/**
 *
 */
package Array;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties;
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 *
 * For example,
 * Consider the following matrix:
 * [
 *  [1,   3,  5,  7],
 *  [10, 11, 16, 20],
 *  [23, 30, 34, 50]
 * ]
 * Given target = 3, return true.
 * @author SenWang
 *
 */
public class Search2DMatrix {
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
     * the binary search
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
     * this is the reference solution to this question, which just treat this 2d matrix
     * as a sorted array.
     */
    public static boolean solutionRef(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int start = 0;
        int end = row * col - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int mid_value = matrix[mid / col][mid % col];
            if (mid_value == target) {
                return true;
            } else if (mid_value < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
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
