/**
 *
 */
package String;

/**
 * Given a string, your task is to count how many palindromic substrings in this string.
 * The substrings with different start indexes or end indexes are counted as different substrings even
 * they consist of same characters.
 *
 * Example 1:
 * Input: "abc"
 * Output: 3
 * Explanation: Three palindromic strings: "a", "b", "c".
 *
 * Example 2:
 * Input: "aaa"
 * Output: 6
 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
 * Note:
 * The input string length won't exceed 1000.
 * @author SenWang
 *
 */
public class PalindromicSubstrings {
    /**
     * This is my own solution to this question. This solution is correct
     * but its efficiency is pretty bad, which is not acceptable
     * @param s the input string to be checked.
     * @return the total number of palindromic substrings.
     */
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = s.length();
        int range = 2;
        while (range <= s.length()) {
            for (int i = 0; i <= s.length() - range; i++) {
                StringBuilder str = new StringBuilder("");
                for (int j = i; j < i + range; j++) {
                    str.append(s.charAt(j));
                }
                if (str.toString().equals(str.reverse().toString())) {
                    result++;
                }
            }
            range++;
        }
        return result;
    }
    /**
     * This is the reference solution to this question, which start from
     * each character in the string and check the extend string for odd
     * and even length, if it is palindrome, then increase the count.
     * @param s the input string to be checked.
     * @return the total number of palindromic substrings.
     */
    public static int solutionRef(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int result = 0;
        for (int i = 0; i < s.length(); i++) {
            result += countExtendPalindrome(s, i, i); // the odd length
            result += countExtendPalindrome(s, i, i + 1); // the even length
        }
        return result;
    }
    /**
     * This is the helper function to check whether the extend string
     * is a palindrome.
     * @param s the input string to be considered
     * @param left the left limit of the extend string.
     * @param right the right limit of the extend string.
     * @return the number of palindrome in the extend string.
     */
    private static int countExtendPalindrome(String s, int left, int right) {
        int count = 0;
        while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            count++;
            left--;
            right++;
        }
        return count;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "aaaa";
        int result = PalindromicSubstrings.solutionRef(test);
        System.out.println(result);
    }

}
