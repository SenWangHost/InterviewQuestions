/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so that it can be
 * stored in a file or memory buffer, or transmitted across a network connection link to be reconstructed later
 * in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree. There is no restriction on how your
 * serialization/deserialization algorithm should work. You just need to ensure that a binary search tree can
 * be serialized to a string and this string can be deserialized to the original tree structure.
 *
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize
 * algorithms should be stateless.
 * @author SenWang
 *
 */
public class SerializeAndDeserializeBST {
    /**
     * This is my own recursive solution to this question, which
     * uses preorder traversal.
     * This is the serialize function.
     * @param root the root node of this tree.
     * @return the string representation of the tree.
     */
    public static String solution_serialize(TreeNode root) {
        if (root == null) {
            return "";
        }
        StringBuilder result = new StringBuilder("");
        solutionRec(root, result);
        return result.toString();
    }
    /**
     * This is the private recursive helper function to this question.
     * @param root the root node of this tree.
     * @param str the string builder for containing the result
     */
    private static void solutionRec(TreeNode root, StringBuilder str) {
        if (root == null) {
            return;
        }
        str.append(Integer.toString(root.val));
        str.append(",");
        solutionRec(root.left, str);
        solutionRec(root.right, str);
    }
    /**
     * This is my own iterative solution to this question, this
     * is the deserialize function.
     * @param data the string representation of the tree.
     * @return the original tree structure.
     */
    public static TreeNode solution_deseralize(String data) {
        if (data == "") {
        	return null;
        }
        String[] array = data.split(",");
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 0; i < array.length; i++) {
        	list.add(Integer.parseInt(array[i]));
        }
        TreeNode root = null;
        for (int num : list) {
        	root = insert(root, num);
        }
        return root;
    }
    /**
     * This is recursive helper function to insert an element into the binary
     * search tree.
     * @param root the root node of this tree.
     * @param ele the integer element to be inserted into the tree.
     */
    private static TreeNode insert(TreeNode root, int ele) {
    	if (root == null) {
    		root = new TreeNode(ele);
    		return root;
    	}
    	if (ele > root.val) {
    		root.right = insert(root.right, ele);
    		return root;
    	} else {
    		root.left = insert(root.left, ele);
    		return root;
    	}
    }
    /**
     * The reference solution has the same idea as mine.
     */
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeNode {
        /**
         * The field for storing the integer.
         */
        private int val;
        /**
         * The left reference to another tree node.
         */
        private TreeNode left;
        /**
         * The right reference to another tree node.
         */
        private TreeNode right;
        /**
         * The constructor for the tree node
         * @param x the integer value to be stored into the tree node.
         */
        private TreeNode(int x) {
            val = x;
            left = null;
            right = null;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(84);
        root.left = new TreeNode(41);
        root.right = new TreeNode(96);
        root.right.right = new TreeNode(98);
        root.left.left = new TreeNode(24);
        root.left.right = new TreeNode(50);
        root.left.left.left = new TreeNode(13);
        root.left.left.right = new TreeNode(37);
        System.out.println(SerializeAndDeserializeBST.solution_serialize(root));
        String data = SerializeAndDeserializeBST.solution_serialize(root);
        TreeNode result = SerializeAndDeserializeBST.solution_deseralize(data);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.right.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.left.left.left.val);
        System.out.println(result.left.left.right.val);
    }

}