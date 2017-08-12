/**
 *
 */
package String;

/**
 * Given a non-empty string check if it can be constructed by taking a substring of it and
 * appending multiple copies of the substring together.
 * You may assume the given string consists of lower case English letters only and its length will not exceed 10000.
 *
 * Example 1:
 * Input: "abab"
 * Output: True
 * Explanation: It's the substring "ab" twice.
 *
 * Example 2:
 * Input: "aba"
 * Output: False
 *
 * Example 3:
 * Input: "abcabcabcabc"
 * Output: True
 * Explanation: It's the substring "abc" four times. (And the substring "abcabc" twice.)
 * @author SenWang
 *
 */
public class RepeatedSubstringPattern {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return true if it can be constructed by substring, false otherwise.
     */
    public static boolean solution(String s) {
        if (s.length() == 1) {
            return false;
        }
        int multiple = 2;
        while (multiple <= s.length()) {
            if (s.length() % multiple == 0) {
                int subLength = s.length() / multiple;
                String sub = s.substring(0, subLength);
                StringBuilder comp = new StringBuilder("");
                for (int i = 0; i < multiple; i++) {
                    comp.append(sub);
                }
                if (comp.toString().equals(s)) {
                    return true;
                }
            }
            multiple++;
        }
        return false;
    }
    /**
     * This is one of the reference solution to this question. The idea is the
     * same as mine, the substring length has to be divisor of the input string
     * length. but more compact code.
     * @param s the input string to be considered.
     * @return true if it can be constructed by substring, false otherwise.
     */
    public static boolean solutionRef(String s) {
        int l = s.length();
        for (int i = l / 2; i > 0; i--) {
            if (l % i == 0) {
                String substr = s.substring(0, i);
                int j = i;
                while (j < l) {
                    if (!s.substring(j, j + i).equals(substr)) {
                        break;
                    } else {
                        j += i;
                    }
                }
                if (j == l) {
                    return true;
                }
            }
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "abcabcabc";
        boolean result = RepeatedSubstringPattern.solution(test);
        System.out.println(result);
    }

}
