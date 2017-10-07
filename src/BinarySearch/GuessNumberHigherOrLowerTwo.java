/**
 *
 */
package BinarySearch;

/**
 * We are playing the Guess Game. The game is as follows:
 * I pick a number from 1 to n. You have to guess which number I picked.
 * Every time you guess wrong, I'll tell you whether the number I picked is higher or lower.
 * However, when you guess a particular number x, and you guess wrong, you pay $x.
 *  You win the game when you guess the number I picked.
 *
 *  Example:
 *  n = 10, I pick 8.
 *  First round:  You guess 5, I tell you that it's higher. You pay $5.
 *  Second round: You guess 7, I tell you that it's higher. You pay $7.
 *  Third round:  You guess 9, I tell you that it's lower. You pay $9.
 *  Game over. 8 is the number I picked.
 *  You end up paying $5 + $7 + $9 = $21.
 *  Given a particular n ≥ 1, find out how much money you need to have to guarantee a win.
 * @author SenWang
 *
 */
public class GuessNumberHigherOrLowerTwo {
    /**
     * this is reference solution to this question, which uses
     * dp to solve the question.
     */
    public static int solution(int n) {
        int[][] table = new int[n + 1][n + 1];
        return DP(table, 1, n);
    }
    /**
     * this is the helper function to solve the question.
     */
    private static int DP(int[][] table, int start, int end) {
        if(start >= end) {
            return 0;
        }
        if(table[start][end] != 0) {
            return table[start][end];
        }
        int res = Integer.MAX_VALUE;
        for(int x = start; x <= end; x++){
            int tmp = x + Math.max(DP(table, start, x - 1), DP(table, x + 1, end));
            res = Math.min(res, tmp);
        }
        table[start][end] = res;
        return res;
    }
    /**
     * this is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solution(5));
    }

}
