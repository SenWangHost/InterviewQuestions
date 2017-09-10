/**
 *
 */
package DynamicProgramming;

/**
 * Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right
 * which minimizes the sum of all numbers along its path.
 * Note: You can only move either down or right at any point in time.
 * @author SenWang
 *
 */
public class MinimumPathSum {
    /**
     * This is my own solution for this question, which adapts from unique path 2 solution.
     * @param grid two dimensional array representing the grid.
     * @return the minimize sum of the path.
     */
    public static int solution(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                    continue;
                } else if (i == 0) {
                    grid[i][j] += grid[i][j - 1];
                } else if (j == 0) {
                    grid[i][j] += grid[i - 1][j];
                } else {
                    grid[i][j] += Math.min(grid[i - 1][j], grid[i][j - 1]);
                }
            }
        }
        return grid[row - 1][col - 1];
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] grid = {{3, 1, 2}, {4, 7, 1}, {5, 10, 3}};
        System.out.println(MinimumPathSum.solution(grid));
    }

}
