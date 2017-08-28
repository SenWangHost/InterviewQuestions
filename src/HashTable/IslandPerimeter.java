/**
 *
 */
package HashTable;

/**
 * You are given a map in form of a two-dimensional integer grid where 1 represents land and 0 represents water.
 * Grid cells are connected horizontally/vertically (not diagonally). The grid is completely surrounded by water,
 * and there is exactly one island (i.e., one or more connected land cells).
 * The island doesn't have "lakes" (water inside that isn't connected to the water around the island).
 * One cell is a square with side length 1. The grid is rectangular, width and height don't exceed 100.
 * Determine the perimeter of the island.
 *
 * Example:
 * [[0,1,0,0],
 *  [1,1,1,0],
 *  [0,1,0,0],
 *  [1,1,0,0]]
 *
 * Answer: 16
 * Explanation: The perimeter is the 16 yellow stripes in the image below:
 * @author SenWang
 *
 */
public class IslandPerimeter {
    /**
     * This is my own solution to this question above.
     * @param grid the two dimensional array representing the island.
     * @return the perimeter of the island.
     */
    public static int solution(int[][] grid) {
        int row = grid.length;
        int col = grid[0].length;
        int result = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] != 0) {
                    // for grid[i - 1][j]
                    if (i - 1 < 0) {
                        result++;
                    } else {
                        if (grid[i - 1][j] == 0) {
                            result++;
                        }
                    }
                    // for grid[i + 1][j]
                    if (i + 1 >= row) {
                        result++;
                    } else {
                        if (grid[i + 1][j] == 0) {
                            result++;
                        }
                    }
                    // for grid[i][j - 1]
                    if (j - 1 < 0) {
                        result++;
                    } else {
                        if (grid[i][j - 1] == 0) {
                            result++;
                        }
                    }
                    // for grid[i][j + 1]
                    if (j + 1 >= col) {
                        result++;
                    } else {
                        if (grid[i][j + 1] == 0) {
                            result++;
                        }
                    }
                }
            }
        }
        return result;
    }
    /**
     * this is reference solution to this question, which count the number of
     * island points and down and right neighbors, then 4 * island - 2 * neighbors
     * to get the result.
     * @param grid the two dimensional array representing the island.
     * @return the perimeter of the island.
     */
    public static int solutionRef(int[][] grid) {
        int island = 0;
        int neighbors = 0;
        int row = grid.length;
        int col = grid[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (grid[i][j] == 1) {
                    island++;
                    if (i + 1 < row && grid[i + 1][j] == 1) {
                        neighbors++;
                    }
                    if (j + 1 < col && grid[i][j + 1] == 1) {
                        neighbors++;
                    }
                }
            }
        }
        return island * 4 - neighbors * 2;
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] grid = {{0,1,0,0}, {1,1,1,0}, {0,1,0,0}, {1,1,0,0}};
        int result = IslandPerimeter.solutionRef(grid);
        System.out.println(result);
    }

}
