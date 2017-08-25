/**
 *
 */
package Trie;

/**
 * Design a data structure that supports the following two operations:
 *
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or ..
 * A . means it can represent any one letter.
 *
 * For example:
 * addWord("bad")
 * addWord("dad")
 * addWord("mad")
 * search("pad") -> false
 * search("bad") -> true
 * search(".ad") -> true
 * search("b..") -> true
 * Note:
 * You may assume that all words are consist of lowercase letters a-z.
 * @author SenWang
 *
 */
public class AddAndSearchWord {
    /**
     * this is my own implementation for word dictionary
     * @author SenWang
     */
    public static class WordDictionary {
        /**
         * this is the root node for word dictionary
         */
        private Node root;
        /**
         * this is the constructor for the word dictionary
         */
        public WordDictionary() {
            root = new Node('\0');
        }
        /**
         * the method to add the word into the dictionary
         * @param word the word to be added into the dictionary
         */
        public void add(String word) {
            Node temp = root;
            for (int i = 0; i < word.length(); i++) {
                Node[] array = temp.next;
                if (array[word.charAt(i) - 'a'] == null) {
                    array[word.charAt(i) - 'a'] = new Node(word.charAt(i));
                }
                temp = array[word.charAt(i) - 'a'];
            }
            temp.end = true;
        }
        /**
         * the method to check whether the word is in the dictionary.
         * @param word the word to be searched in the tree.
         * @return true if word is in the trie, false otherwise.
         */
        public boolean search(String word) {
            return backTrack(word, 0, root);
        }
        /**
         * this is the back track helper function to the search method above.
         * @param word the input word to be searched.
         * @param index the index for tracking the character.
         * @param node the
         */
        private static boolean backTrack(String word, int index, Node node) {
            if (index == word.length()) {
                return node.end;
            }
            if (word.charAt(index) != '.') {
                return node.next[word.charAt(index) - 'a'] != null && backTrack(word, index + 1, node.next[word.charAt(index) - 'a']);
            } else {
                for (Node temp : node.next) {
                    if (temp != null) {
                        if (backTrack(word, index + 1, temp)) {
                            return true;
                        }
                    }
                }
            }
            return false;
        }
    }

    /**
     * This is the definition for the trie node.
     * @author SenWang
     */
    private static class Node {
        /**
         * the field for storing the character.
         */
        @SuppressWarnings("unused")
        private char value;
        /**
         * the boolean indicates whether a word ends at this node.
         */
        private boolean end;
        /**
         * the array for storing possible 26 nodes
         */
        private Node[] next;
        /**
         * the constructor for the node
         * @param input the input character to be stored in the node.
         */
        private Node(char input) {
            value = input;
            end = false;
            next = new Node[26];
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        WordDictionary test = new WordDictionary();
        test.add("bus");
        test.add("day");
        test.add("mad");
        System.out.println(test.search("pad"));
        System.out.println(test.search("bad"));
        System.out.println(test.search("..d"));
        System.out.println(test.search("b.."));
    }

}
