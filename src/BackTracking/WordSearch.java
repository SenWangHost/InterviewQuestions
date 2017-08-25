/**
 *
 */
package BackTracking;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once.
 * For example,
 * Given board =
 * [
 *  ['A','B','C','E'],
 *  ['S','F','C','S'],
 *  ['A','D','E','E']
 * ]
 * word = "ABCCED", -> returns true,
 * word = "SEE", -> returns true,
 * word = "ABCB", -> returns false.
 * @author SenWang
 *
 */
public class WordSearch {
    /**
     * This ismy own solution to this question.
     * @param board the character board for searching the word
     * @param word the word to be searched
     * @return true if the word exists in the board, false otherwise.
     */
    public static boolean solution(char[][] board, String word) {
        if (word == null || board == null || word.length() == 0) {
            return false;
        }
        char[] w = word.toCharArray();
        int row = board.length;
        int col = board[0].length;
        int index = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (solutionRec(board, w, i, j, row, col, index)) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This is the recursive helper function to the solution above.
     */
    private static boolean solutionRec(char[][] board, char[] word, int rowIndex, int colIndex, int row, int col,
                                     int index) {
        if (index == word.length) {
            return true;
        }
        if (rowIndex < 0 || rowIndex == row) {
            return false;
        }
        if (colIndex < 0 || colIndex == col) {
            return false;
        }

        // System.out.println(board[rowIndex][colIndex]);
        if (board[rowIndex][colIndex] != word[index]) {
            return false;
        } else {
            board[rowIndex][colIndex] ^= 256;
            boolean path1 = solutionRec(board, word, rowIndex - 1, colIndex, row, col, index + 1);
            boolean path2 = solutionRec(board, word, rowIndex, colIndex - 1, row, col, index + 1);
            boolean path3 = solutionRec(board, word, rowIndex + 1, colIndex, row, col, index + 1);
            boolean path4 = solutionRec(board, word, rowIndex, colIndex + 1, row, col, index + 1);
            board[rowIndex][colIndex] ^= 256;
            return path1 || path2 || path3 || path4;
        }
    }
    /**
     * the referecen solution has the same idea and code is very similar to the solution above.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = {{'A', 'B', 'C', 'E'}, {'S', 'F', 'C', 'S'}, {'A', 'D', 'E','E'}};
        // char[][] board2 = {{'C', 'A', 'A'}, {'A', 'A', 'A'}, {'B', 'C', 'D'}};
        String word = "AAB";
        boolean result = WordSearch.solution(board, word);
        System.out.println(result);
    }

}
