/**
 *
 */
package String;

/**
 * Given a string and an integer k, you need to reverse the first k characters for every 2k characters counting from
 * the start of the string. If there are less than k characters left, reverse all of them.
 * If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and
 * left the other as original.
 *
 * Example:
 * Input: s = "abcdefg", k = 2
 * Output: "bacdfeg"
 * Restrictions:
 * The string consists of lower English letters only.
 * Length of the given string and k will in the range [1, 10000]
 * @author SenWang
 *
 */
public class ReverseStringTwo {
    /**
     * This is my own solution to this question. The idea is to use
     * to two pointers to keep track of sub string that needs to be
     * reversed.
     * @param s string to be considered.
     * @param k the number of characters to be reversed.
     * @return the reversed string.
     */
    public static String solution(String s, int k) {
        if (s == null || s.length() <= 1) {
            return s;
        }
        if (k >= s.length()) {
            return new StringBuilder(s).reverse().toString();
        }
        int start = 0;
        int end = 2 * k;
        StringBuilder result = new StringBuilder("");
        while (start < s.length()) {
            if (end < s.length()) {
                String firstHalf = s.substring(start, (start + end) / 2);
                String secondHalf = s.substring((start + end) / 2, end);
                result.append(new StringBuilder(firstHalf).reverse());
                result.append(secondHalf);
            } else {
                int remainNum = s.length() - start;
                if (remainNum < k) {
                    result.append(new StringBuilder(s.substring(start, s.length())).reverse());
                } else {
                    String sub = s.substring(start, start + k);
                    String remain = s.substring(start + k, s.length());
                    result.append(new StringBuilder(sub).reverse());
                    result.append(remain);
                }
            }
            start += 2 * k;
            end += 2 * k;
        }
        return result.toString();
    }
    /**
     * This is reference solution to this question, which is based
     * on the same idea but uses helper function to reverse the subString.
     * @param s string to be considered.
     * @param k the number of characters to be reversed.
     * @return the reversed string.
     */
    public static String solutionRef(String s, int k) {
        if (s == null) {
            return null;
        }
        char[] array = s.toCharArray();
        int len = array.length;
        int start = 0;
        while (start < len) {
            int end = Math.min(start + k - 1, len - 1);
            reverseSub(array, start, end);
            start += 2 * k;
        }
        return new String(array);
    }
    /**
     * This is the helper function to reverse the substring in a
     * char array.
     * @param array the char array to be considered.
     * @param start the start index of sub string.
     * @param end the end index of sub string.
     */
    private static void reverseSub(char[] array, int start, int end) {
        while (start < end) {
            char temp = array[end];
            array[end] = array[start];
            array[start] = temp;
            start++;
            end--;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "abcdefg";
        String result = ReverseStringTwo.solution(test, 8);
        System.out.println(result);
    }

}
