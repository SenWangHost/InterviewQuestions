/**
 *
 */
package String;

/**
 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
 *
 * Example:
 * Input: "babad"
 * Output: "bab"
 * Note: "aba" is also a valid answer.
 *
 * Example:
 * Input: "cbbd"
 * Output: "bb"
 * @author SenWang
 *
 */
public class LongestPalindromicSubstring {
    /**
     * This is my own solution to this question. This solution is
     * acceptable but runs slow.
     * @param the input string to be considered.
     * @return the longest palindrome substring.
     */
    public static String solution(String s) {
        String result = "";
        int length = 0;
        int start = 0;
        int end = s.length() - 1;
        while (start < s.length() && start <= end) {
            int i = start;
            int j = end;
            boolean palindrome = true;
            while (i <= j) {
                if (s.charAt(i) != s.charAt(j)) {
                    palindrome = false;
                    end--;
                    break;
                }
                i++;
                j--;
            }
            if (palindrome) {
                String sub = s.substring(start, end + 1);
                if (sub.length() > length) {
                    length = sub.length();
                    result = sub;
                }
                start++;
                end = s.length() - 1;
            } else {
                continue;
            }
        }
        return result;
    }
    /**
     * This is one of the reference solution to this question, which use
     * the expand the center method.
     * @param s the input string to be considered.
     * @return the longest palindrome substring.
     */
    public static String solutionRef(String s) {
        int start = 0;
        int end = 0;
        for (int i = 0; i < s.length(); i++) {
            // the odd length of palindrome string.
            int len1 = expandAroundCenter(s, i, i);
            int len2 = expandAroundCenter(s, i, i + 1);
            int len = Math.max(len1, len2);
            if (len > end - start) {
                start = i - (len - 1) / 2;
                end = i + len / 2;
            }
        }
        return s.substring(start, end + 1);
    }
    /**
     * This is the helper function to expand around center
     * and checks whether it is a palindrome.
     * @param s the input string to be considered
     * @param left the left limit of expansion.
     * @param right the right limit of expansion.
     * @return the length of palindrome
     */
    private static int expandAroundCenter(String s, int left, int right) {
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            left--;
            right++;
        }
        return right - left - 1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "cbbd";
        String result = LongestPalindromicSubstring.solutionRef(test);
        System.out.println(result);
    }

}
