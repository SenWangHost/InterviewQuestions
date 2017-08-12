/**
 *
 */
package String;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * For example,
 * "A man, a plan, a canal: Panama" is a palindrome.
 * "race a car" is not a palindrome.
 * Note:
 * Have you consider that the string might be empty? This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 * @author SenWang
 *
 */
public class ValidPalindrome {
    /**
     * This is my own solution to this question.
     * @param s the input string to be checked.
     * @return true if it is a valid palindrome, false otherwise.
     */
    public static boolean solution(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        s = s.toLowerCase();
        StringBuilder string = new StringBuilder("");
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp >= 'a' && temp <= 'z') {
                string.append(temp);
            }
            if (temp >= '0' && temp <= '9') {
                string.append(temp);
            }
        }
        System.out.println(string.toString());
        if (string.toString().equals(string.reverse().toString())) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * This is one of the reference solutions that use two pointers
     * solution without cleaning the white space and special characters.
     * @param s the input string to be checked.
     * @return true if it is a valid palindrome, false otherwise.
     */
    public static boolean solutionRef(String s) {
        if (s == null) {
            return false;
        }
        if (s.length() == 0) {
            return true;
        }
        int start = 0;
        int end = s.length() - 1;
        while (start <= end) {
            char head = s.charAt(start);
            char tail = s.charAt(end);
            if (!Character.isLetterOrDigit(head)) {
                start++;
            } else if (!Character.isLetterOrDigit(tail)) {
                end--;
            } else {
                if (Character.toLowerCase(head) != Character.toLowerCase(tail)) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "0P";
        boolean result = ValidPalindrome.solution(test);
        System.out.println(result);
    }
}
