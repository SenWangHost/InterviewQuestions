/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The n-queens puzzle is the problem of placing n queens on an n×n chessboard such
 * that no two queens attack each other.
 *
 * Given an integer n, return all distinct solutions to the n-queens puzzle.
 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.'
 * both indicate a queen and an empty space respectively.
 *
 * For example,
 * There exist two distinct solutions to the 4-queens puzzle:
 * [
 *  [".Q..",  // Solution 1
 *   "...Q",
 *   "Q...",
 *   "..Q."],
 *  ["..Q.",  // Solution 2
 *   "Q...",
 *   "...Q",
 *   ".Q.."]
 * ]
 * @author SenWang
 *
 */
public class NQueens {
    /**
     * This is my own solution to this question, which uses backtracking.
     * @param n the size of the board.
     * @return distinct solution represented by the list of string.
     */
    public static List<List<String>> solution(int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), n);
//        for (List<Integer> list : result) {
//            System.out.println(list);
//        }
        List<List<String>> res = new ArrayList<List<String>>();
        for (List<Integer> list : result) {
            List<String> str = convert(list);
            res.add(str);
        }
        return res;
    }
    /**
     * This is private helper function for backtracking solution.
     * @param result the two-dimensional list for storing the results.
     * @param temp the temporary list for storing one set of results.
     * @param n the size of the board
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> temp, int n) {
        if (temp.size() == n) {
            result.add(new ArrayList<Integer>(temp));
        }
        for (int i = 0; i < n; i++) {
            int row = temp.size();
            int col = i;
            if (validInput(temp, row, col)) {
                temp.add(i);
                backTrack(result, temp, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
    /**
     * This is private helper function for validating the input.
     * @param temp the temporary list storing the results.
     * @param input the input col position of next queen.
     * @return true if this is a valid position, false otherwise.
     */
    private static boolean validInput(List<Integer> list, int row, int col) {
        if (list.size() == 0) {
            return true;
        }
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == col) {
                return false;
            }
            if (list.get(i) + i == row + col) {
                return false;
            }
            if (i - list.get(i) == row - col) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is private helper function to convert integer result to string result.
     * @param list the list of integer result.
     * @return strResult the list of string result.
     */
    private static List<String> convert(List<Integer> list) {
        List<String> result = new ArrayList<String>();
        for (int i = 0; i < list.size(); i++) {
            StringBuilder temp = new StringBuilder();
            for (int j = 0; j < list.size(); j++) {
                if (j == list.get(i)) {
                    temp.append("Q");
                } else {
                    temp.append(".");
                }
            }
            result.add(temp.toString());
        }
        return result;
    }
    /**
     * This is the reference solution to this question, which also backTrack
     * algorithm but construct the string directly.
     * @param n the size of the board.
     * @return distinct solution represented by the list of string.
     */
    public static List<List<String>> solutionRef(int n) {
        char[][] board = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                board[i][j] = '.';
            }
        }
        List<List<String>> result = new ArrayList<List<String>>();
        backTrackRef(board, 0, result);
        return result;
    }
    /**
     * This is the backTrack helper function for the reference solution.
     * @param board
     * @param colIndex
     * @param res
     */
    private static void backTrackRef(char[][] board, int colIndex, List<List<String>> res) {
        if(colIndex == board.length) {
            res.add(construct(board));
            return;
        }

        for(int i = 0; i < board.length; i++) {
            if(validate(board, i, colIndex)) {
                board[i][colIndex] = 'Q';
                backTrackRef(board, colIndex + 1, res);
                board[i][colIndex] = '.';
            }
        }
    }
    /**
     * This is the function to validate a input for a board.
     * @param board
     * @param x
     * @param y
     * @return
     */
    private static boolean validate(char[][] board, int x, int y) {
        for(int i = 0; i < board.length; i++) {
            for(int j = 0; j < y; j++) {
                if(board[i][j] == 'Q' && (x + j == y + i || x + y == i + j || x == i))
                    return false;
            }
        }

        return true;
    }
    /**
     * This is the helper function to construct the string solution.
     * @param board
     * @return
     */
    private static List<String> construct(char[][] board) {
        List<String> res = new ArrayList<String>();
        for(int i = 0; i < board.length; i++) {
            String s = new String(board[i]);
            res.add(s);
        }
        return res;
    }
    /**
     * This is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<String>> result = NQueens.solution(4);
        for (List<String> list : result) {
            System.out.println(list);
        }
    }

}
