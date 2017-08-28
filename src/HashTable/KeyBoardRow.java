/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a List of words, return the words that can be typed using letters of alphabet on only one row's
 * of American keyboard like the image below.
 *
 * Example 1:
 * Input: ["Hello", "Alaska", "Dad", "Peace"]
 * Output: ["Alaska", "Dad"]
 * Note:
 * You may use one character in the keyboard more than once.
 * You may assume the input string will only contain letters of alphabet.
 * @author SenWang
 *
 */
public class KeyBoardRow {
    /**
     * this is my own solution to this question, which simply uses hash
     * set to store all the letters in one keyboard row.
     * @param words the array of string to be considered.
     * @return an array of string containing the results.
     */
    public static String[] solution(String[] words) {
        String str1 = "qwertyuiop";
        String str2 = "asdfghjkl";
        String str3 = "zxcvbnm";
        int[] table = new int[26];
        for (int i = 0; i < 26; i++) {
            char temp = (char) ('a' + i);
            if (str1.indexOf(temp) != -1) {
                table[i] = 1;
            } else if (str2.indexOf(temp) != -1) {
                table[i] = 2;
            } else if (str3.indexOf(temp) != -1) {
                table[i] = 3;
            }
        }
        List<String> result = new ArrayList<String>();
        for (String word : words) {
            char[] array = word.toLowerCase().toCharArray();
            int value = 0;
            boolean isRow = true;
            for (char c : array) {
                if (value == 0) {
                    value = table[c - 'a'];
                } else {
                    if (table[c - 'a'] != value) {
                        isRow = false;
                        break;
                    }
                }
            }
            if (isRow) {
                result.add(word);
            }
        }
        return result.toArray(new String[0]);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] words = {"Hello", "Alaska", "Dad", "Peace"};
        String[] result = KeyBoardRow.solution(words);
        for (String word : result) {
            System.out.println(word);
        }
    }

}
