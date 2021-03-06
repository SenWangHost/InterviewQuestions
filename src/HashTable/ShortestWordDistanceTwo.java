/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * This is a follow up of Shortest Word Distance. The only difference is now you are given the list of
 * words and your method will be called repeatedly many times with different parameters.
 * How would you optimize it?
 * Design a class which receives a list of words in the constructor, and implements a method that takes
 * two words word1 and word2 and return the shortest distance between these two words in the list.
 *
 * For example,
 * Assume that words = ["practice", "makes", "perfect", "coding", "makes"].
 * Given word1 = “coding”, word2 = “practice”, return 3.
 * Given word1 = "makes", word2 = "coding", return 1.
 *
 * Note:
 * You may assume that word1 does not equal to word2, and word1 and word2 are both in the list.
 * @author SenWang
 *
 */
public class ShortestWordDistanceTwo {
    /**
     * This is my own solution to this question.
     */
    public static class WordDistance {
        /**
         * field for the solution
         */
        private static Map<String, List<Integer>> map;
        /**
         * the constructor for the solution
         */
        public WordDistance(String[] words) {
            map = new HashMap<String, List<Integer>>();
            for (int i = 0; i < words.length; i++) {
                if (!map.containsKey(words[i])) {
                    map.put(words[i], new ArrayList<Integer>());
                }
                map.get(words[i]).add(i);
            }
        }
        /**
         * the method for calculating the shortest distance.
         */
        public int shorest(String word1, String word2) {
            List<Integer> list1 = map.get(word1);
            List<Integer> list2 = map.get(word2);
            int result = Integer.MAX_VALUE;
            for (int index1 : list1) {
                for (int index2 : list2) {
                    result = Math.min(result, Math.abs(index1 - index2));
                }
            }
            return result;
        }
    }
    /**
     * the reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
