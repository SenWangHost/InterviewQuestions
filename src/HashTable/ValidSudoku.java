/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 * @author SenWang
 *
 */
public class ValidSudoku {
    /**
     * This is my own solution to this question. This solution is naive and
     * is simply based on the three rules of the sudoku game.
     * @param a two dimensional matrix representing the sudoku board.
     * @return true if it is a valid sudoku board, false otherwise.
     */
    public static boolean solution(char[][] board) {
        int rowLength = board[0].length;
        int colLength = board.length;
        for (int i = 0; i < colLength; i++) {
            char[] row = board[i];
            if (!checkRow(row)) {
                System.out.println("rowCheck");
                return false;
            }
        }
        for (int j = 0; j < rowLength; j++) {
            if (!checkCol(board, j)) {
                System.out.println("colCheck");
                return false;
            }
        }
        if (!checkBlock(board)) {
            System.out.println("blockCheck");
            return false;
        }
        return true;
    }
    /**
     * This is the helper function to check one row in the borad.
     * @param row an array containing the borad of one row.
     * @return true if this row is valid, false otherwise.
     */
    private static boolean checkRow(char[] row) {
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < row.length; i++) {
            if (row[i] != '.') {
                if (set.contains(row[i])) {
                    System.out.println("rowCheck");
                    return false;
                } else {
                    set.add(row[i]);
                }
            }
        }
        return true;
    }
    /**
     * This is the helper function to check each column of the board.
     * @param board the two dimensional array representing the board.
     * @param col the index of the col.
     * @return true if this column valid, false otherwise.
     */
    private static boolean checkCol(char[][] board, int col) {
        int height = board.length;
        Set<Character> set = new HashSet<Character>();
        for (int i = 0; i < height; i++) {
            if (board[i][col] != '.') {
                if (set.contains(board[i][col])) {
                    System.out.println("colCheck");
                    return false;
                } else {
                    set.add(board[i][col]);
                }
            }
        }
        return true;
    }
    /**
     * This is the private helper function to check the 3 * 3 block
     * for the sudoku board.
     * @param board the two dimensional array representing the board.
     * @return true if the blocks are all valid, false otherwise.
     */
    private static boolean checkBlock(char[][] board) {
        Set<Character> set = new HashSet<Character>();
        for (int row = 0; row < 9; row += 3) {
            for (int col = 0; col < 9; col += 3) {
                set.clear();
                for (int i = row; i < row + 3; i++) {
                    for (int j = col; j < col + 3; j++) {
                        if (board[i][j] != '.') {
                            if (set.contains(board[i][j])) {
                                System.out.println("blockCheck");
                                return false;
                            } else {
                                set.add(board[i][j]);
                            }
                        }
                    }
                }
            }
        }
        return true;
    }
    /**
     * This is my another solution to this question, which uses hashmap to
     * track the number and its board coordinates and block coordinates.
     * @param a two dimensional matrix representing the sudoku board.
     * @return true if it is a valid sudoku board, false otherwise.
     */
    public static boolean solution2(char[][] board) {
        Map<Character, List<int[]>> map = new HashMap<Character, List<int[]>>();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] != '.') {
                    // construct the coordinate array for the element.
                    int[] coor = new int[4];
                    coor[0] = i;
                    coor[1] = j;
                    coor[2] = i / 3;
                    coor[3] = j / 3;
                    if (map.containsKey(board[i][j])) {
                        List<int[]> list = map.get(board[i][j]);
                        for (int[] temp : list) {
                            for (int k = 0; k < 2; k++) {
                                if (k <= 1 && temp[k] == coor[k]) {
                                    return false;
                                }
                            }
                            if (temp[2] == coor[2] && temp[3] == coor[3]) {
                                return false;
                            }
                        }
                        list.add(coor);
                        map.put(board[i][j], list);
                    } else {
                        List<int[]> temp = new ArrayList<int[]>();
                        temp.add(coor);
                        map.put(board[i][j], temp);
                    }
                }
            }
        }
        return true;
    }
    /**
     * This is one of the reference solution to this question, which
     * uses helper function to check the validity of part of board by only
     * passing the parameters into the functions.
     * @param board the two dimensional array representing the board.
     * @return true if the blocks are all valid, false otherwise.
     */
    public static boolean solutionRef(char[][] board) {
        for (int i = 0; i < 9; i++) {
            // check the row
            if (!isPartialValid(board, 0, i, 8, i)) {
                return false;
            }
            // check the column
            if (!isPartialValid(board, i, 0, i, 8)) {
                return false;
            }
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (!isPartialValid(board, i * 3, j * 3, i * 3 + 2, j * 3 + 2)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * This is the helper function for this solution above, which
     * checks the validity of part of the region denoted by (x1, y1), (x2, y2).
     * @param board the two dimensional array representing the board.
     * @param x1 the first x coordinate.
     * @param y1 the first y coordinate.
     * @param x2 the second x coordinate.
     * @param y2 the second y coordinate.
     * @return true if this partial region is valid, false otherwise.
     */
    private static boolean isPartialValid(char[][] board, int x1, int y1, int x2, int y2) {
        Set<Character> set = new HashSet<Character>();
        for (int row = x1; row <= x2; row++) {
            for (int col = y1; col <= y2; col++) {
                if (board[row][col] != '.') {
                    if (set.contains(board[row][col])) {
                        return false;
                    } else {
                        set.add(board[row][col]);
                    }
                }
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[] row1 = {'.', '8', '7', '6', '5', '4', '3', '2', '1'};
        char[] row2 = {'2', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row3 = {'3', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row4 = {'4', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row5 = {'5', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row6 = {'6', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row7 = {'7', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row8 = {'8', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[] row9 = {'9', '.', '.', '.', '.', '.', '.', '.', '.'};
        char[][] board = {row1, row2, row3, row4, row5, row6, row7, row8, row9};
        System.out.println(ValidSudoku.solution2(board));
    }

}
