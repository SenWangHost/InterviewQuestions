/**
 *
 */
package String;

/**
 * Given a word, you need to judge whether the usage of capitals in it is right or not.
 * We define the usage of capitals in a word to be right when one of the following cases holds:
 * All letters in this word are capitals, like "USA".
 * All letters in this word are not capitals, like "leetcode".
 * Only the first letter in this word is capital if it has more than one letter, like "Google".
 * Otherwise, we define that this word doesn't use capitals in a right way.
 *
 * Example 1:
 * Input: "USA"
 * Output: True
 *
 * Example 2:
 * Input: "FlaG"
 * Output: False
 *
 * Note: The input will be a non-empty word consisting of uppercase and lowercase latin letters.
 * @author SenWang
 *
 */
public class DetectCapital {
    /**
     * This is my own solution to this question.
     * @param word the input word to be considered.
     * @return true if this word has correct usage of the capitals, false otherwise.
     */
    public static boolean solution(String word) {
        int count = 0;
        for (int i = 0; i < word.length(); i++) {
            char temp = word.charAt(i);
            if (temp >= 'A' && temp <= 'Z') {
                count++;
            }
        }
        if (count == word.length()) {
            return true;
        } else {
            if (count == 0) {
                return true;
            } else if (count == 1 && word.charAt(0) >= 'A' && word.charAt(0) <= 'Z') {
                return true;
            }
        }
        return false;
    }
    /**
     * This is one of the reference solution to this question, which
     * makes use of built-in string method.
     * @param word the input word to be considered.
     * @return true if this word has correct usage of the capitals, false otherwise.
     */
    public static boolean solutionRef(String word) {
        if (word.length() < 2) {
            return true;
        }
        if (word.toUpperCase().equals(word)) {
            return true;
        }
        if (word.substring(1).toLowerCase().equals(word.substring(1))) {
            return true;
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "FlaG";
        boolean result = DetectCapital.solution(test);
        System.out.println(result);
    }

}
