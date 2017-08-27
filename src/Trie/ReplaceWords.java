/**
 *
 */
package Trie;

import java.util.ArrayList;
import java.util.List;

/**
 * In English, we have a concept called root, which can be followed by some other words to form another
 * longer word - let's call this word successor. For example, the root an, followed by other, which can
 * form another word another.
 *
 * Now, given a dictionary consisting of many roots and a sentence. You need to replace all the successor
 * in the sentence with the root forming it. If a successor has many roots can form it, replace it with
 * the root with the shortest length.
 *
 * You need to output the sentence after the replacement.
 *
 * Example 1:
 * Input: dict = ["cat", "bat", "rat"]
 * sentence = "the cattle was rattled by the battery"
 * Output: "the cat was rat by the bat"
 *
 * Note:
 * The input will only have lower-case letters.
 * 1 <= dict words number <= 1000
 * 1 <= sentence words number <= 1000
 * 1 <= root length <= 100
 * 1 <= sentence words length <= 1000
 * @author SenWang
 *
 */
public class ReplaceWords {
    /**
     * This is my own solution to this question, which uses prefix
     * tree and store the words in the sentence in the trie.
     * @param dict the dictionary which has many roots
     * @param sentence the sentence to be modified.
     * @return the sentence after modification.
     */
    public static String solution(List<String> dict, String sentence) {
        String[] array = sentence.split(" ");
        Trie trie = new Trie();
        for (String str : dict) {
            trie.insert(str);
        }
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < array.length; i++) {
            array[i] = trie.getShorestPrefix(array[i]);
            result.append(array[i]);
            if (i != array.length - 1) {
                result.append(" ");
            }
        }
        return result.toString();
    }
    /**
     * this is the implementation of trie.
     * @author SenWang
     */
    public static class Trie {
        /**
         * the field for the root
         */
        private Node root;
        /**
         * the constructor for trie
         */
        public Trie() {
            root = new Node('\0');
        }
        /**
         * the method to insert a word into the trie
         * @param word the word to be inserted into the trie
         */
        public void insert(String word) {
            Node temp = root;
            int index = 0;
            while (index < word.length()) {
                Node[] next = temp.next;
                if (next[word.charAt(index) - 'a'] == null) {
                    next[word.charAt(index) - 'a'] = new Node(word.charAt(index));
                }
                temp = next[word.charAt(index) - 'a'];
                index++;
            }
            temp.end = true;
        }
        /**
         * the method to get the shortest prefix based on input word
         * @param word the word to be searched in the prefix tree.
         * @return the shorest prefix, if it doesn't exist, return the original word
         */
        public String getShorestPrefix(String word) {
            Node temp = root;
            int index = 0;
            StringBuilder result = new StringBuilder();
            while (index < word.length()) {
                char curr = word.charAt(index);
                Node[] array = temp.next;
                if (array[curr - 'a'] == null) {
                    return word;
                }
                temp = array[curr - 'a'];
                result.append(curr);
                index++;
                if (temp.end) {
                    return result.toString();
                }
            }
            return result.toString();
        }
    }
    /**
     * This is the implementation of trie node.
     * @author SenWang
     */
    private static class Node {
        /**
         * the field for storing character
         */
        @SuppressWarnings("unused")
        private char value;
        /**
         * the field for storing link to next node
         */
        private Node[] next;
        /**
         * the boolean value indicates whether this is
         * an end of a word
         */
        private boolean end;
        /**
         * the constructor for the node
         * @param input the input character to be stored
         */
        private Node(char input) {
            value = input;
            next = new Node[26];
            end = false;
        }
    }
    /**
     * the reference solution has the same idea as my solution,
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<String> dict = new ArrayList<String>();
        dict.add("cat");
        dict.add("bat");
        dict.add("rat");
        String sentence = "the cattle was rattled by the battery";
        String result = ReplaceWords.solution(dict, sentence);
        System.out.println(result);
    }

}
