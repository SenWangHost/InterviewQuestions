/**
 *
 */
package HashTable;

/**
 * Given a string, sort it in decreasing order based on the frequency of characters.
 *
 * Example 1:
 * Input:
 * "tree"
 * Output:
 * "eert"
 * Explanation:
 * 'e' appears twice while 'r' and 't' both appear once.
 * So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
 *
 * Example 2:
 * Input:
 * "cccaaa"
 * Output:
 * "cccaaa"
 * Explanation:
 * Both 'c' and 'a' appear three times, so "aaaccc" is also a valid answer.
 * Note that "cacaca" is incorrect, as the same characters must be together.
 *
 * Example 3:
 * Input:
 * "Aabb"
 * Output:
 * "bbAa"
 * Explanation:
 * "bbaA" is also a valid answer, but "Aabb" is incorrect.
 * Note that 'A' and 'a' are treated as two different characters.
 * @author SenWang
 *
 */
public class SortCharactersByFrequency {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return the string after sorting.
     */
    public static String solution(String s) {
       int[] table = new int[256];
       char[] array = s.toCharArray();
       int maxFre = 0;
       for (char c : array) {
           table[c]++;
           maxFre = Math.max(maxFre, table[c]);
       }
       StringBuilder result = new StringBuilder();
       while (maxFre > 0) {
           for (int i = 0; i < 256; i++) {
               char curr = (char) i;
               int fre = table[i];
               if (fre == maxFre) {
                   for (int j = 0; j < fre; j++) {
                       result.append(curr);
                   }
               }
           }
           maxFre--;
       }
       return result.toString();
    }
    /**
     * The reference solution uses bucket sort, my solution needs subtle modifications
     * to include bucket sort and increase the efficiency.
     * @param s the input string to be considered.
     * @return the string after sorting.
     */
    public static String solution2(String s) {
        int[] table = new int[256];
        char[] array = s.toCharArray();
        int maxFre = 0;
        for (char c : array) {
            table[c]++;
            maxFre = Math.max(maxFre, table[c]);
        }
        StringBuilder[] bucket = new StringBuilder[maxFre + 1];
        for (int i = 0; i < 256; i++) {
            int fre = table[i];
            if (bucket[fre] == null) {
                bucket[fre] = new StringBuilder();
            }
            for (int j = 0; j < fre; j++) {
                bucket[fre].append((char) i);
            }
        }
        StringBuilder result = new StringBuilder();
        for (int i = maxFre; i >= 1; i--) {
            if (bucket[i] != null) {
                result.append(bucket[i]);
            }
        }
        return result.toString();
    }
    /**
     * the reference solution has the same idea(using bucket sort) as solution2.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "aaaccc";
        String result = SortCharactersByFrequency.solution2(test);
        System.out.println(result);
    }

}
