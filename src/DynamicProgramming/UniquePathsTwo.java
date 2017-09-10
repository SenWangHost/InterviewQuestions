/**
 *
 */
package DynamicProgramming;

/**
 * Follow up for "Unique Paths":
 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
 *
 * For example,
 * There is one obstacle in the middle of a 3x3 grid as illustrated below.
 * [
 *  [0,0,0],
 *  [0,1,0],
 *  [0,0,0]
 * ]
 * The total number of unique paths is 2.
 * Note: m and n will be at most 100.
 * @author SenWang
 *
 */
public class UniquePathsTwo {
    /**
     * This is reference solution to this question, which uses dynamic programming.
     * @param obstacleGrid the two dimensional grid for indicating the obstacles.
     * @return the number of unique paths from upper left to bottom right.
     */
    public static int solution(int[][] obstacleGrid) {
        int row = obstacleGrid.length;
        int col = obstacleGrid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (obstacleGrid[i][j] == 1) {
                    obstacleGrid[i][j] = 0;
                } else if (i == 0 && j == 0) {
                    obstacleGrid[i][j] = 1;
                } else if (i == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i][j - 1] * 1;
                } else if (j == 0) {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] * 1;
                } else {
                    obstacleGrid[i][j] = obstacleGrid[i - 1][j] + obstacleGrid[i][j - 1];
                }
            }
        }
        return obstacleGrid[row - 1][col - 1];
    }
    /**
     * This is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int row = 3;
        int col = 3;
        int[][] obstacleGrid = new int[row][col];
        obstacleGrid[1][0] = 1;
        System.out.println(UniquePathsTwo.solution(obstacleGrid));
    }

}
