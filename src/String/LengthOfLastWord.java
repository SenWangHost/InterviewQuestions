/**
 *
 */
package String;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 *
 * For example,
 * Given s = "Hello World",
 * return 5.
 * @author SenWang
 *
 */
public class LengthOfLastWord {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return the length of the last word in the input string.
     */
    public static int solution(String s) {
        String str = "x " + s;
        String[] array = str.split(" +");
        if (array.length == 1) {
            return 0;
        }
        String last = array[array.length - 1];
        return last.length();
    }
    /**
     * This is one reference solution, which is much faster.
     * @param s the input string to be considered.
     * @return the length of the last word in the input string.
     */
    public static int solutionRef(String s) {
        s = s.trim();
        int lastIndex = s.lastIndexOf(' ') + 1;
        return s.length() - lastIndex;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "Hello World   ";
        int result = LengthOfLastWord.solution(test);
        System.out.println(result);
    }

}
