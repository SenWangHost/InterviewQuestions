/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell, where "adjacent" cells are
 * those horizontally or vertically neighboring. The same letter cell may not be used more than once in a word.
 *
 * For example,
 * Given words = ["oath","pea","eat","rain"] and board =
 * [
 *  ['o','a','a','n'],
 *  ['e','t','a','e'],
 *  ['i','h','k','r'],
 *  ['i','f','l','v']
 * ]
 * Return ["eat","oath"].
 * Note:
 * You may assume that all inputs are consist of lowercase letters a-z.
 * click to show hint.
 * You would need to optimize your backtracking to pass the larger test. Could you stop backtracking earlier?
 * If the current candidate does not exist in all words' prefix, you could stop backtracking immediately.
 * What kind of data structure could answer such query efficiently? Does a hash table work? Why or why not?
 * How about a Trie? If you would like to learn how to implement a basic trie, please work on this problem:
 * Implement Trie (Prefix Tree) first.
 * @author SenWang
 *
 */
public class WordSearchTwo {
    /**
     * this is my own solution to this question.
     * @param board the two dimensional array reprensenting the board.
     * @param word the array of words to be searched from
     * @return a list of word that exists in the board.
     */
    public static List<String> solution(char[][] board, String[] words) {
        Trie trie = new Trie();
        for (String word : words) {
            trie.insert(word);
        }
        List<String> result = new ArrayList<String>();
        StringBuilder temp = new StringBuilder();
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                backTrack(board, temp, result, i, j, row, col, trie);
            }
        }
        return result;
    }
    /**
     * this is the recursive backtracking helper function to the solution above.
     * @param board the two dimensional array representing the board.
     * @param temp the temp word constrcuted from the board.
     * @param result
     * @param rowIndex the current index in the row.
     * @param colIndex the current index in the column.
     * @param row the number of rows of the board.
     * @parma col the number of columns of the board.
     * @param trie the prefix tree storing the words.
     */
    public static void backTrack(char[][] board, StringBuilder temp, List<String> result, int rowIndex,
                                            int colIndex, int row, int col, Trie trie) {
        if (rowIndex < 0 || rowIndex >= row) {
            return;
        }
        if (colIndex < 0 || colIndex >= col) {
            return;
        }
        char curr = board[rowIndex][colIndex];
        temp.append(curr);
        board[rowIndex][colIndex] ^= 256;
        boolean[] res = trie.contain(temp.toString());
        // System.out.println(res[0] + " " + res[1]);
        if (res[0] && res[1]) {
            if (!result.contains(temp.toString())) {
                result.add(temp.toString());
            }
        }
        if (res[0]) {
            //System.out.println(temp.toString());
            backTrack(board, temp, result, rowIndex - 1, colIndex, row, col, trie);
            backTrack(board, temp, result, rowIndex + 1, colIndex, row, col, trie);
            backTrack(board, temp, result, rowIndex, colIndex - 1, row, col, trie);
            backTrack(board, temp, result, rowIndex, colIndex + 1, row, col, trie);
        }
        board[rowIndex][colIndex] ^= 256;
        temp.deleteCharAt(temp.length() - 1);
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
         * the method to check whether the prefix is in the trie
         * and wether it is a word.
         * @param prefix the input prefix to be checked
         * @return two boolean value indicating whether it is in the trie and whether
         * it is a word.
         */
        public boolean[] contain(String prefix) {
            boolean[] result = new boolean[2];
            Node temp = root;
            int index = 0;
            while (index < prefix.length()) {
                char curr = prefix.charAt(index);
                Node[] next = temp.next;
                if (curr - 'a' < 0 || curr - 'a' >= 26) {
                    return result;
                }
                if (next[curr - 'a'] == null) {
                    return result;
                }
                temp = next[curr - 'a'];
                index++;
            }
            result[0] = true;
            result[1] = temp.end;
            return result;
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
     * The following reference solution has the same idea but modifications to increase
     * the efficiency of this algorithm.
     */
    /**
     * this is the reference solution to this question above.
     * @param board the two dimensional array reprensenting the board.
     * @param word the array of words to be searched from
     * @return a list of word that exists in the board.
     */
    public static List<String> solutionRef(char[][] board, String[] words) {
        List<String> result = new ArrayList<>();
        TrieNode root = buildTrie(words);
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                dfs (board, i, j, root, result);
            }
        }
        return result;
    }
    /**
     * the recursive helper function to backtracking.
     * @param board
     * @param i
     * @param j
     * @param p
     * @param res
     */
    private static void dfs(char[][] board, int i, int j, TrieNode p, List<String> res) {
        char c = board[i][j];
        if (c == '#' || p.next[c - 'a'] == null) {
            return;
        }
        p = p.next[c - 'a'];
        if (p.word != null) {   // found one
            res.add(p.word);
            p.word = null;     // de-duplicate
        }

        board[i][j] = '#';
        if (i > 0) {
            dfs(board, i - 1, j ,p, res);
        }
        if (j > 0) {
            dfs(board, i, j - 1, p, res);
        }
        if (i < board.length - 1) {
            dfs(board, i + 1, j, p, res);
        }
        if (j < board[0].length - 1)  {
            dfs(board, i, j + 1, p, res);
        }
        board[i][j] = c;
    }
    /**
     * the method to build a trie directly from an array of words
     * @param an array of words for building the trie
     * @return the root nodeo of the trie
     */
    private static TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String word : words) {
            TrieNode temp = root;
            for (char c : word.toCharArray()) {
                int i = c - 'a';
                if (temp.next[i] == null) {
                    temp.next[i] = new TrieNode();
                }
                temp = temp.next[i];
           }
           temp.word = word;
        }
        return root;
    }
    /**
     * this is reference implementation of trie node
     */
    private static class TrieNode {
        /**
         * the link to next node
         */
        TrieNode[] next = new TrieNode[26];
        /**
         * the field indicating it is a word.
         */
        String word;
    }
    /**
     * this is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        char[][] board = {{'o', 'a', 'a', 'n'}, {'e', 't', 'a', 'e'}, {'i', 'h', 'k', 'r'}, {'i', 'f', 'l', 'v'}};
        // char[][] board2 = {{'a', 'b'}, {'a', 'a'}};
        String[] words = {"oath","pea","eat","rain"};
        List<String> result = WordSearchTwo.solution(board, words);
        for (String word : result) {
            System.out.println(word);
        }
    }

}
