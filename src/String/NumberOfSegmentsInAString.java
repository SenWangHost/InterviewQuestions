/**
 *
 */
package String;

/**
 * Count the number of segments in a string, where a segment is defined to be a contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 *
 * Example:
 * Input: "Hello, my name is John"
 * Output: 5
 * @author SenWang
 *
 */
public class NumberOfSegmentsInAString {
    /**
     * This is my own solution to this question.
     * @param s the input string to be checked.
     * @return the number of segments in the string.
     */
    public static int solution(String s) {
        if (s.length() == 0) {
            return 0;
        }
        int index = 0;
        int count = 0;
        while (index < s.length()) {
            if (s.charAt(index) != ' ') {
                count++;
                while (index < s.length() && s.charAt(index) != ' ') {
                    index++;
                }
            } else {
                index++;
            }
        }
        return count;
    }
    /**
     * This is one of the reference solutions that uses split function
     * in a smart way.
     * @param s the input string to be checked.
     * @return the number of segments in the string.
     */
    public static int solutionRef(String s) {
        return ("x " + s).split(" +").length - 1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "   Hello,   my   name   is   John   ";
        int result = NumberOfSegmentsInAString.solution(test);
        System.out.println(result);
    }

}
