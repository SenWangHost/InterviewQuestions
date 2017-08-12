/**
 *
 */
package String;

/**
 * Given two words word1 and word2, find the minimum number of steps required to make word1 and word2 the same,
 * where in each step you can delete one character in either string.
 *
 * Example 1:
 * Input: "sea", "eat"
 * Output: 2
 * Explanation: You need one step to make "sea" to "ea" and another step to make "eat" to "ea".
 * Note:
 * 1. The length of given words won't exceed 500.
 * 2. Characters in given words can only be lower-case letters.
 * @author SenWang
 *
 */
public class DeleteOperationsForTwoStrings {
    /**
     * This is one of the reference solution to this question, which uses
     * recursion to find the longest common subsequence and use two dimensional
     * array to memorize some of recursive call's results.
     * @param word1 the first word to be considered.
     * @param word2 the second word to be considered.
     * @return the number of delete operations to make two words become equal
     */
    public static int solutionRef(String word1, String word2) {
        int[][] memo = new int[word1.length() + 1][word1.length() + 1];
        return word1.length() + word2.length() - 2 * lcs(word1, word2, word1.length(), word2.length(), memo);
    }
    /**
     * This is the helper function to get the longest common subsequence
     * by recursion method.
     * @param s1 the first word to be considered.
     * @param s2 the second word to be considered.
     * @param m the length of the first word.
     * @param n the length of the second word.
     * @param memo the 2-d memo array for storing recursive results.
     * @return the length of the longest common subsequence.
     */
    private static int lcs(String s1, String s2, int m, int n, int[][] memo) {
        if (m == 0 || n == 0) {
            return 0;
        }
        if (memo[m][n] > 0) {
            return memo[m][n];
        }
        if (s1.charAt(m - 1) == s2.charAt(n - 1)) {
            memo[m][n] = 1 + lcs(s1, s2, m - 1, n - 1, memo);
        } else {
            memo[m][n] = Math.max(lcs(s1, s2, m - 1, n, memo), lcs(s1, s2, m, n - 1, memo));
        }
        return memo[m][n];
    }
    /**
     * This is another reference solution, which uses dynamic programming to get
     * the longest common subsequence.
     * @param word1 the first word to be considered.
     * @param word2 the second word to be considered.
     * @return the number of delete operations to make two words become equal
     */
    public static int solutionRef2(String word1, String word2) {
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        for (int i = 0; i <= word1.length(); i++) {
            for (int j = 0; j <= word2.length(); j++) {
                if (i == 0 || j == 0)
                    continue;
                if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                else
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
            }
        }
        return word1.length() + word2.length() - 2 * dp[word1.length()][word2.length()];
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String word1 = "seae";
        String word2 = "eatf";
        int result = DeleteOperationsForTwoStrings.solutionRef(word1, word2);
        System.out.println(result);
    }

}
