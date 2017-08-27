/**
 *
 */
package HashTable;

/**
 * Given two strings s and t, write a function to determine if t is an anagram of s.
 * For example,
 * s = "anagram", t = "nagaram", return true.
 * s = "rat", t = "car", return false.
 * Note:
 * You may assume the string contains only lowercase alphabets.
 * Follow up:
 * What if the inputs contain unicode characters? How would you adapt your solution to such case?
 * @author SenWang
 *
 */
public class ValidAnagram {
    /**
     * This is my own solution to this question, which uses array
     * to represent the hash table
     * @param s the first string to be considered.
     * @param t the second string to be considered.
     * @return true if two strings are anagram, false otherwise
     */
    public static boolean solution(String s, String t) {
        if (s == null || t == null) {
            return false;
        }
        if (s.length() != t.length()) {
            return false;
        }
        int[] table = new int[26];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        for (int i = 0; i < s.length(); i++) {
            int sIndex = sArr[i] - 'a';
            int tIndex = tArr[i] - 'a';
            table[sIndex]++;
            table[tIndex]--;
        }
        for (int num : table) {
            if (num != 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * the reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this solution above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String s = "rat";
        String t = "car";
        boolean result = ValidAnagram.solution(s, t);
        System.out.println(result);
    }

}
