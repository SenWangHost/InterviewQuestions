/**
 *
 */
package Array;

import java.util.HashSet;
import java.util.Set;

/**
 * According to the Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * Given a board with m by n cells, each cell has an initial state live (1) or dead (0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four
 * rules (taken from the above Wikipedia article):
 *
 * Any live cell with fewer than two live neighbors dies, as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population..
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * Write a function to compute the next state (after one update) of the board given its current state.
 *
 * Follow up:
 * 1. Could you solve it in-place? Remember that the board needs to be updated at the same time:
 * You cannot update some cells first and then use their updated values to update other cells.
 * 2. In this question, we represent the board using a 2D array. In principle, the board is infinite,
 * which would cause problems when the active area encroaches the border of the array.
 * How would you address these problems?
 * @author SenWang
 *
 */
public class GameOfLife {
    /**
     * this is my own solution to this question, but it uses extra space.
     */
    public static void solution(int[][] board) {
        int row = board.length;
        int col = board[0].length;
        Set<String> toLive = new HashSet<String>();
        Set<String> toDeath = new HashSet<String>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = countLive(i, j, board);
                if (lives < 2 || lives > 3) {
                    toDeath.add(i + "a" + j);
                } else if (lives == 3 && board[i][j] == 0) {
                    toLive.add(i + "a" + j);
                }
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (board[i][j] == 1 && toDeath.contains(i + "a" + j)) {
                    board[i][j] = 0;
                }
                if (board[i][j] == 0 && toLive.contains(i + "a" + j)) {
                    board[i][j] = 1;
                }
            }
        }
    }
    /**
     * the helper function to check number of live neightbor of a cell
     */
    public static int countLive(int x, int y, int[][] matrix) {
        int count = 0;
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++) {
                if (i != x || j != y) {
                    if ((i >= 0 && i < row) && (j >= 0 && j < col)) {
                        if (matrix[i][j] == 1) {
                            count++;
                        }
                    }
                }
            }
        }
        return count;
    }
    /**
     * this is the reference solution to this question, which uses two bits to store the first state
     * and the second state.
     */
    public static void solutionRef(int[][] board) {
        if (board == null || board.length == 0) {
            return;
        }
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                int lives = countLiveNeighbor(i, j, board);
                // In the beginning, every 2nd bit is 0;
                // So we only need to care about when will the 2nd bit become 1.
                if (board[i][j] == 1 && lives >= 2 && lives <= 3) {
                    board[i][j] = 3; // make the second bit 1: 01 ----> 11
                }
                if (board[i][j] == 0 && lives == 3) {
                    board[i][j] = 2; // make the second bit 1: 00 -----> 10
                }
            }
        }
        // get the next state
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] >>= 1;
            }
        }
    }
    /**
     * this is the helper method to count the live neighbor
     */
    private static int countLiveNeighbor(int x, int y, int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        int count = 0;
        for (int i = Math.max(0, x - 1); i <= Math.min(x + 1, row - 1); i++) {
            for (int j = Math.max(0, y - 1); j <= Math.min(y + 1, col - 1); j++) {
                count += matrix[i][j] & 1;
            }
        }
        count -= matrix[x][y] & 1;
        return count;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
