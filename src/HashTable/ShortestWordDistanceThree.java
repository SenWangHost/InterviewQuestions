/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now word1 could be the same as word2.
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * word1 and word2 may be the same and they represent two individual words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “makes”, word2 = “coding”, return 1.
 * Given word1 = "makes", word2 = "makes", return 3.
 *
 * Note:
 * You may assume word1 and word2 are both in the list.
 * @author SenWang
 *
 */
public class ShortestWordDistanceThree {
    /**
     * this is my own solution to this question.
     */
    public static int solution(String[] words, String word1, String word2) {
        if (word1.equals(word2)) {
            List<Integer> list = new ArrayList<Integer>();
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    list.add(i);
                }
            }
            if (list.size() == 1) {
                return list.get(0);
            } else {
                return list.get(1) - list.get(0);
            }
        } else {
            int p1 = -1;
            int p2 = -1;
            int result = Integer.MAX_VALUE;
            for (int i = 0; i < words.length; i++) {
                if (words[i].equals(word1)) {
                    p1 = i;
                }
                if (words[i].equals(word2)) {
                    p2 = i;
                }
                if (p1 != -1 && p2 != -1) {
                    result = Math.min(result, Math.abs(p1 - p2));
                }
            }
            return result;
        }
    }
    /**
     * the reference solution has the same idea as mine, but the code is much more simpler.
     */
    public static int solutionRef(String[] words, String word1, String word2) {
        if (words == null || words.length == 0) return 0;
        int i1 = -words.length;  //here is to guarantee mindistance will be greater than the word.length
        int i2 = words.length;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (!word1.equals(word2)) {
                if (words[i].equals(word1)) i1 = i;
                if (words[i].equals(word2)) i2 = i;
                min = Math.min(min, Math.abs(i1 - i2)); //so we don't have to check if (i1 != -1 && i2 != -1 in other solutions)
            } else {
                if (words[i].equals(word1)) {  //this the question on how to find the shortest distance of indices of the word
                    min = Math.min(min, Math.abs(i - i1));  //you can change to i - i1, it is also correct
                    i1 = i;  // update the i1 with current i for incoming distance checking
                }
            }
        }
        return min;
    }
    /**
     * This is test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
