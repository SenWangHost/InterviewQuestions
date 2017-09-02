/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Follow up for N-Queens problem.
 * Now, instead outputting board configurations, return the total number of distinct solutions.
 * @author SenWang
 *
 */
public class NQueensTwo {
    /**
     * This is my own solution to this question.
     * @param n the size of the board.
     * @return the total number of distinct solutions to this question.
     */
    public static int solution(int n) {
        if (n <= 0) {
            return 0;
        }
        int[] count = new int[1];
        backTrack(new ArrayList<Integer>(), count, n);
        return count[0];
    }
    /**
     * This is the recursive backTrack helper function to the solution above.
     * @param temp the temep list for storing the results.
     * @param count one size array for recording the result.
     * @param n the size of the board.
     */
    private static void backTrack(List<Integer> temp, int[] count, int n) {
        if (temp.size() == n) {
            count[0]++;
            return;
        }
        for (int i = 0; i < n; i++) {
            int row = temp.size();
            int col = i;
            if (validInput(temp, row, col)) {
                temp.add(i);
                backTrack(temp, count, n);
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
     * This is one of the reference solution to this question, which uses boolean array
     * to valid the input instead of checking the positions.
     * @param n the size of the board.
     * @return the total number of distinct solutions to this question.
     */
    public static int solutionRef(int n) {
        if (n <= 0) {
            return 0;
        }
        boolean[] cols = new boolean[n];
        boolean[] dia1 = new boolean[2 * n];
        boolean[] dia2 = new boolean[2 * n];
        int[] count = new int[1];
        backTrackRef(0, cols, dia1, dia2, count, n);
        return count[0];
    }
    /**
     * This is the backtrack helper function to this reference solution.
     * @param row the row number for current inserting.
     * @param cols the boolean array for validing the column.
     * @param dia1 the boolean array for validing the diagonal.
     * @param dia2 the boolean array for validing the diagonal.
     * @param count the one-size array for updating the count.
     */
    private static void backTrackRef(int row, boolean[] cols, boolean[] dia1, boolean[] dia2, int[] count, int n) {
        if (row == n) {
            count[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            int index1 = row + col;
            int index2 = row - col + n;
            if (cols[col] || dia1[index1] || dia2[index2]) {
                continue;
            }
            cols[col] = true;
            dia1[index1] = true;
            dia2[index2] = true;
            backTrackRef(row + 1, cols, dia1, dia2, count, n);
            cols[col] = false;
            dia1[index1] = false;
            dia2[index2] = false;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NQueensTwo.solutionRef(4));
    }

}
