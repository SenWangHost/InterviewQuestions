/**
 *
 */
package String;

/**
 * The count-and-say sequence is the sequence of integers with the first five terms as following:
 * 1.     1
 * 2.     11
 * 3.     21
 * 4.     1211
 * 5.     111221
 *
 * 1 is read off as "one 1" or 11.
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth term of the count-and-say sequence.
 * Note: Each term of the sequence of integers will be represented as a string.
 * Example 1:
 * Input: 1
 * Output: "1"
 *
 * Example 2:
 * Input: 4
 * Output: "1211"
 * @author SenWang
 *
 */
public class CountAndSay {
    /**
     * this is my own solution to this question.
     */
    public static String solution(int n) {
        String result = "1";
        while (n > 1) {
            result = convertPrev(result);
            n--;
        }
        return result;
    }
    /**
     * convert the previous string to current string.
     */
    private static String convertPrev(String s) {
        int count = 1;
        char c = s.charAt(0);
        String result = "";
        for (int i = 1; i < s.length(); i++) {
            if (c == s.charAt(i)) {
                count++;
            } else {
                result += count;
                result += c;
                count = 1;
                c = s.charAt(i);
            }
        }
        result += count;
        result += c;
        return result;
    }
    /**
     * this is the reference solution.
     */
    public static String solutionRef(int n) {
        String result = "1";
        while (n > 1) {
            result = convert(result);
            n--;
        }
        return result;
    }
    /**
     * this is the reference solution to this question, which has
     * the same idea as mine.
     */
    private static String convert(String s) {
        StringBuilder result = new StringBuilder("");
        int i = 0;
        int count = 0;
        while (i < s.length()) {
            while (i + count < s.length() && s.charAt(i) == s.charAt(i + count)) {
                count++;
            }
            result.append(count).append(s.charAt(i));
            i += count;
            count = 0;
        }
        return result.toString();
    }
    /**
     * this is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String test = "111221";
//        System.out.println(convertPrev(test));
        System.out.println(solution(7));
    }

}
