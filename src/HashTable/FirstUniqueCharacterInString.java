/**
 *
 */
package HashTable;

/**
 * Given a string, find the first non-repeating character in it and return it's index.
 * If it doesn't exist, return -1.
 *
 * Examples:
 * s = "leetcode"
 * return 0.
 *
 * s = "loveleetcode",
 * return 2.
 * Note: You may assume the string contain only lowercase letters.
 * @author SenWang
 *
 */
public class FirstUniqueCharacterInString {
    /**
     * this is my own solution to this question, which uses hashmap to keep track of
     * frenquency of each word.
     */
    public static int solution(String s) {
        int[] map = new int[26];
        char[] array = s.toCharArray();
        for (char c : array) {
            map[c - 'a']++;
        }
        for (int i = 0; i < array.length; i++) {
            if (map[array[i] - 'a'] == 1) {
                return i;
            }
        }
        return -1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
