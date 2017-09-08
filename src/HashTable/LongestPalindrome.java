/**
 *
 */
package HashTable;

/**
 * Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes
 * that can be built with those letters.
 * This is case sensitive, for example "Aa" is not considered a palindrome here.
 * Note:
 * Assume the length of given string will not exceed 1,010.
 *
 * Example:
 * Input:
 * "abccccdd"
 * Output:
 * 7
 * Explanation:
 * One longest palindrome that can be built is "dccaccd", whose length is 7.
 * @author SenWang
 *
 */
public class LongestPalindrome {
    /**
     * This is my own solution to this question, which uses frequencies to construct
     * the palindrome.
     * @param s the string input to be considered.
     * @return the length of longest palindromes.
     */
    public static int solution(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] table = new int[52];
        char[] array = s.toCharArray();
        for (char c : array) {
            if (c >= 'a' && c <= 'z') {
                table[c - 'a']++;
            }
            if (c >= 'A' && c <= 'Z') {
                table[c - 'A' + 26]++;
            }
        }
        int result = 0;
        boolean middle = false;
        for (int fre : table) {
            if (fre == 1 && !middle) {
                result += 1;
                middle = true;
            } else if (fre != 1 && fre % 2 == 1) {
                if (middle) {
                    result += fre - 1;
                } else {
                    result += fre;
                    middle = true;
                }
            } else if (fre % 2 == 0) {
                result += fre;
            }
        }
        return result;
    }
    /**
     * This is one of the referece solution to this question, which I think the idea is clear
     * @param s the string input to be considered.
     * @return the length of longest palindromes.
     */
    public static int solutionRef(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int[] lower = new int[26];
        int[] upper = new int[26];
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) <= 'z') {
                lower[s.charAt(i) - 'a']++;
            } else {
                upper[s.charAt(i) - 'A']++;
            }
        }
        int result = 0;
        for (int i = 0; i < 26; i++) {
            result += lower[i] / 2 * 2;
            result += upper[i] / 2 * 2;
        }
        if (result == s.length()) {
            return result;
        } else {
            return result + 1;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "bananas";
        int result = LongestPalindrome.solution(test);
        System.out.println(result);
    }

}
