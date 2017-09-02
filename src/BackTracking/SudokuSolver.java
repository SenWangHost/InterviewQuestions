/**
 *
 */
package BackTracking;

/**
 * Write a program to solve a Sudoku puzzle by filling the empty cells.
 * Empty cells are indicated by the character '.'.
 * You may assume that there will be only one unique solution.
 * @author SenWang
 *
 */
public class SudokuSolver {
    /**
     * This is my own solution to this question, which uses backtracking.
     * @param board two-dimensional char array representing the board.
     */
    public static void solution(char[][] board) {
        backTrack(board);
    }
    /**
     * This is the bakc track helper function for this solution above.
     * @param board the two-dimnesional char board.
     */
    private static boolean backTrack(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < 9; k++) {
                        char input = (char) ('1' + k);
                        if (validInput(board, i, j, input)) {
                            board[i][j] = input;
                            if (backTrack(board)) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * This is the helper function for valid a input at certain position.
     * @param board the two-dimensional char array represening the board.
     * @param rIndex the row index of current point.
     * @param cIndex the column index of the current point.
     * @param input the char input.
     * @return true if this input is valid, false otherwise.
     */
    private static boolean validInput(char[][] board, int rIndex, int cIndex, char input) {
        // valid the row
        char[] row = board[rIndex];
        for (char c : row) {
            if (c == input) {
                return false;
            }
        }
        // valid the column
        for (int i = 0; i < board.length; i++) {
            if (input == board[i][cIndex]) {
                return false;
            }
        }
        // valid the square
        int rSquare = rIndex / 3;
        int cSquare = cIndex / 3;
        for (int i = rSquare * 3; i < rSquare * 3 + 3; i++) {
            for (int j = cSquare * 3; j < cSquare * 3 + 3; j++) {
                if (input == board[i][j]) {
                    return false;
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
        char[][] board = {{'5','3','.','.','7','.','.','.','.'},
                          {'6','.','.','1','9','5','.','.','.'},
                          {'.','9','8','.','.','.','.','6','.'},
                          {'8','.','.','.','6','.','.','.','3'},
                          {'4','.','.','8','.','3','.','.','1'},
                          {'7','.','.','.','2','.','.','.','6'},
                          {'.','6','.','.','.','.','2','8','.'},
                          {'.','.','.','4','1','9','.','.','5'},
                          {'.','.','.','.','.','8','.','7','9'}
        };
        // System.out.println(validInput(board, 0, 2, '9'));
        SudokuSolver.solution(board);
        for (int i = 0; i < 9; i++) {
            System.out.print("[");
            for (int j = 0; j < 9; j++) {
                System.out.print(board[i][j] + ",");
            }
            System.out.print("]");
            System.out.println("");
        }
    }

}
