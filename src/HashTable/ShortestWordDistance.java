/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a list of words and two words word1 and word2, return the shortest distance between these two words in the list.
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 * @author SenWang
 *
 */
public class ShortestWordDistance {
    /**
     * this is my own solution to this question.
     */
    public static int solution(String[] words, String word1, String word2) {
        List<Integer> indexList1 = new ArrayList<Integer>();
        List<Integer> indexList2 = new ArrayList<Integer>();
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1)) {
                indexList1.add(i);
            }
            if (words[i].equals(word2)) {
                indexList2.add(i);
            }
        }
        int result = Integer.MAX_VALUE;
        for (int index1 : indexList1) {
            for (int index2 : indexList2) {
                result = Math.min(result, Math.abs(index1 - index2));
            }
        }
        return result;
    }
    /**
     * the reference solution uses the same idea as mine, but cleaner code
     */
    public static int solutionRef(String[] words, String word1, String word2) {
        int p1 = -1, p2 = -1, min = Integer.MAX_VALUE;
        for (int i = 0; i < words.length; i++) {
            if (words[i].equals(word1))
                p1 = i;

            if (words[i].equals(word2))
                p2 = i;

            if (p1 != -1 && p2 != -1)
                min = Math.min(min, Math.abs(p1 - p2));
        }
        return min;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
