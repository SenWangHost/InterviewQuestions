/**
 *
 */
package String;

/**
 * Given a string, you need to reverse the order of characters in each word within a sentence while
 * still preserving whitespace and initial word order.
 *
 * Example 1:
 * Input: "Let's take LeetCode contest"
 * Output: "s'teL ekat edoCteeL tsetnoc"
 * Note: In the string, each word is separated by single space and there will not be any extra space in the string.
 * @author SenWang
 *
 */
public class ReverseWordsInAStringThree {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return the string contains reversed words.
     */
    public static String solution(String s) {
        String[] array = s.split(" ");
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < array.length; i++) {
            StringBuilder temp = new StringBuilder(array[i]).reverse();
            if (i != array.length - 1) {
                temp.append(" ");
            }
            result.append(temp);
        }
        return result.toString();
    }
    /**
     * This is the one of the reference solutions, which doesn't use predefined split and reverse function.
     * Instead, write the split and reverse function by ourselves.
     */
    /**
     * This is one of the reference solutions, which uses word to store the word found in the string
     * and append it to the result.
     * @param s the input string to be considered.
     * @return the string contains reversed words.
     */
    public static String solutionRef(String s) {
        StringBuilder result = new StringBuilder("");
        StringBuilder word = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != ' ') {
                word.append(s.charAt(i));
            } else {
                result.append(word.reverse());
                result.append(' ');
                word.setLength(0);
            }
        }
        result.append(word.reverse());
        return result.toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "Let's take Leetcode contest";
        String result = ReverseWordsInAStringThree.solutionRef(test);
        System.out.println(result);
    }

}
