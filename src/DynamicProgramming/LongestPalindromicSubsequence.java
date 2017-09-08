/**
 *
 */
package DynamicProgramming;

/**
 * Given a string s, find the longest palindromic subsequence's length in s.
 * You may assume that the maximum length of s is 1000.
 * Example 1:
 * Input:
 * "bbbab"
 * Output:
 * 4
 * One possible longest palindromic subsequence is "bbbb".
 * Example 2:
 * Input:
 * "cbbd"
 * Output:
 * 2
 * One possible longest palindromic subsequence is "bb".
 * @author SenWang
 *
 */
public class LongestPalindromicSubsequence {
    /**
     * This is the my own solution to this question, which uses dynamic programming.
     * @param s the input string to be considered.
     * @return the length of lonest palindromic subsequence.
     */
    public static int solution(String s) {
        int[][] dp = new int[s.length()][s.length()];
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
            for (int j = i - 1; j >= 0; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i - 1][j + 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i- 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[s.length() - 1][0];
    }
    /**
     * This is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "bbbab";
        System.out.println(LongestPalindromicSubsequence.solution(test));
    }

}
