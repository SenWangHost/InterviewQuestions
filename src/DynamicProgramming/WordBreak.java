/**
 *
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
 * You may assume the dictionary does not contain duplicate words.
 *
 * For example, given
 * s = "leetcode",
 * dict = ["leet", "code"].
 * Return true because "leetcode" can be segmented as "leet code".
 * UPDATE (2017/1/4):
 * The wordDict parameter had been changed to a list of strings (instead of a set of strings).
 * Please reload the code definition to get the latest changes.
 * @author SenWang
 *
 */
public class WordBreak {
    /**
     * This is my own solution to this question, which uses dynamic programming.
     * @param s the input string to be considered.
     * @param wordDict the list of string representing the word dictionary.
     * @return true if the word can be constructed from the dictionary.
     */
    public static boolean solutionRef(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;
        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                if (word.length() <= i) {
                    if (dp[i - word.length()] && s.substring(i - word.length(), i).equals(word)) {
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length()];
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "abb";
        List<String> wordDict = new ArrayList<String>();
        wordDict.add("a");
        wordDict.add("b");
        wordDict.add("bbb");
        wordDict.add("bbbb");
        System.out.println(WordBreak.solutionRef(s, wordDict));
    }

}
