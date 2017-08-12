/**
 *
 */
package String;

/**
 * Write a function that takes a string as input and returns the string reversed.
 * Example:
 * Given s = "hello", return "olleh".
 * @author SenWang
 *
 */
public class ReverseString {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return the reversed string.
     */
    public static String solution(String s) {
        if (s == null) {
            return null;
        }
        StringBuilder result = new StringBuilder(s);
        return result.reverse().toString();
    }
    /**
     * This is one of the reference solution of this question, which
     * uses two pointers and swap the characters between beginning and ending.
     * @param s the input string to be considered.
     * @return the reversed string.
     */
    public static String solutionRef(String s) {
        if (s == null) {
            return null;
        }
        char[] result = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char temp = result[end];
            result[end] = result[start];
            result[start] = temp;
            start++;
            end--;
        }
        return new String(result);
    }
    /**
     * This is one of the reference solution, which uses swapping, but the
     * swapping is based on xor bit operation.
     * @param s the input string to be considered.
     * @return the reversed string.
     */
    public static String solutionRef2(String s) {
        if (s == null) {
            return null;
        }
        char[] result = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            result[start] = (char) (result[start] ^ result[end]);
            result[end] = (char) (result[start] ^ result[end]);
            result[start] = (char) (result[start] ^ result[end]);
            start++;
            end--;
        }
        return new String(result);
    }
    /**
     * This is one of the reference solution based on recursively divide and
     * reverse the string.
     * @param s the input string to be considered.
     * @return the reversed string.
     */
    public static String solutionRef3(String s) {
        if (s == null) {
            return null;
        }
        if (s.length() <= 1) {
            return s;
        }
        String left = s.substring(0, s.length() / 2);
        String right = s.substring(s.length() / 2, s.length());
        return solutionRef3(left) + solutionRef3(right);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "hello";
        String result = ReverseString.solutionRef(test);
        System.out.println(result);
    }

}
