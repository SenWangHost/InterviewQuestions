package Trie;
import java.util.ArrayList;
import java.util.List;

/**
 *
 */

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * @author SenWang
 *
 */
public class Trie {
    /**
     * this is my implementation for prefix tree.
     * @author SenWang
     */
    public static class MyTrie {
        /**
         * the field for root node
         */
        private Node root;
        /**
         * the constructor for the prefix tree
         */
        public MyTrie() {
            root = new Node('\0');
        }
        /**
         * the method to insert a word into the tree.
         * @param word the word to be inserted
         */
        public void insert(String word) {
            int index = 0;
            Node temp = root;
            while (index < word.length()) {
                List<Node> list = temp.list;
                boolean contain = false;
                for (Node next : list) {
                    if (next.currChar == word.charAt(index)) {
                        temp = next;
                        index++;
                        contain = true;
                        break;
                    }
                }
                if (!contain) {
                    Node newNode = new Node(word.charAt(index));
                    list.add(newNode);
                    temp = newNode;
                    index++;
                }
            }
            temp.end = true;
        }
        /**
         * the method to seearch a word in the prefix tree.
         * @param word the input word to be searched.
         * @return true if this word exists in the tree, false otherwise.
         */
        public boolean search(String word) {
            int index = 0;
            Node temp = root;
            while (index < word.length()) {
                List<Node> list = temp.list;
                boolean contain = false;
                for (Node node : list) {
                    if (node.currChar == word.charAt(index)) {
                        temp = node;
                        index++;
                        contain = true;
                        break;
                    }
                }
                if (!contain) {
                    return false;
                }
            }
            if (!temp.end) {
                return false;
            }
            return true;
        }
        /**
         * the method to determine if there is any word in this trie
         * starts with a specific prefix.
         * @param prefix the prefix to be determined.
         * @return true any word in the trie starts with the prefix, false otherwise.
         */
        public boolean startsWith(String prefix) {
            int index = 0;
            Node temp = root;
            while (index < prefix.length()) {
                List<Node> list = temp.list;
                boolean contain = false;
                for (Node node : list) {
                    if (node.currChar == prefix.charAt(index)) {
                        temp = node;
                        index++;
                        contain = true;
                        break;
                    }
                }
                if (!contain) {
                    return false;
                }
            }
            return true;
        }
    }
    /**
     * This is node definition for prefix tree
     * @author SenWang
     */
    private static class Node {
        /**
         * the field for storing the character
         */
        private char currChar;
        /**
         * a list containg possible number of nodes
         */
        private List<Node> list;
        /**
         * boolean value indicate whether this is ending character
         * for a word.
         */
        private boolean end;
        /**
         * the constructor for the prefix tree node
         * @param char input character for storage
         */
        private Node(char input) {
            currChar = input;
            list = new ArrayList<Node>();
            end = false;
        }
    }
    /**
     * This is the reference implementation for trie
     * @author SenWang
     */
    public static class MyTrieRef {
        /**
         * the field for root of the tree
         */
        private NodeRef root;
        /**
         * the constructor for the prefix tree
         */
        public MyTrieRef() {
            root = new NodeRef('\0');
        }
        /**
         * the method to insert a word into the tree.
         * @param word the word to be inserted
         */
        public void insert(String word) {
            NodeRef temp = root;
            for (int i = 0; i < word.length(); i++) {
                NodeRef[] array = temp.array;
                if (array[word.charAt(i) - 'a'] == null) {
                    array[word.charAt(i) - 'a'] = new NodeRef(word.charAt(i));
                }
                temp = array[word.charAt(i) - 'a'];
            }
            temp.end = true;
        }
        /**
         * the method to seearch a word in the prefix tree.
         * @param word the input word to be searched.
         * @return true if this word exists in the tree, false otherwise.
         */
        public boolean search(String word) {
            NodeRef temp = root;
            for (int i = 0; i < word.length(); i++) {
                NodeRef[] array = temp.array;
                if (array[word.charAt(i) - 'a'] == null) {
                    return false;
                }
                temp = array[word.charAt(i) - 'a'];
            }
            return temp.end;
        }
        /**
         * the method to determine if there is any word in this trie
         * starts with a specific prefix.
         * @param prefix the prefix to be determined.
         * @return true any word in the trie starts with the prefix, false otherwise.
         */
        public boolean startsWith(String prefix) {
            NodeRef temp = root;
            for (int i = 0; i < prefix.length(); i++) {
                NodeRef[] array = temp.array;
                if (array[prefix.charAt(i) - 'a'] == null) {
                    return false;
                }
                temp = array[prefix.charAt(i) - 'a'];
            }
            return true;
        }
    }
    /**
     * This is for the reference solution, which the nodes are stored
     * in an array size with 26.
     * @author SenWang
     */
    private static class NodeRef {
        /**
         * the field for storing the character
         */
        @SuppressWarnings("unused")
        private char currChar;
        /**
         * the boolean indicating whether this is the end
         * of one character.
         */
        private boolean end;
        /**
         * array with size 26 for possible next nodes
         */
        private NodeRef[] array;
        /**
         * the constructor for the reference node
         * @param input the input character to be stored in the node
         */
        private NodeRef(char input) {
            currChar = input;
            end = false;
            array = new NodeRef[26];
        }

    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        MyTrie trie = new MyTrie();
        trie.insert("apple");
        trie.insert("swift");
        trie.insert("swing");
        System.out.println(trie.search("swi"));
        System.out.println(trie.startsWith("swi"));
        trie.insert("app");
        trie.insert("swi");
        System.out.println(trie.search("app"));
        System.out.println(trie.search("swi"));
    }

}
