/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits so
 * that it can be stored in a file or memory buffer, or transmitted across a network connection link
 * to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary tree. There is no restriction on how
 * your serialization/deserialization algorithm should work. You just need to ensure that a binary tree
 * can be serialized to a string and this string can be deserialized to the original tree structure.
 * For example, you may serialize the following tree
 *      1
 *     / \
 *    2   3
 *       / \
 *      4   5
 *  as "[1,2,3,null,null,4,5]", just the same as how LeetCode OJ serializes a binary tree.
 *  You do not necessarily need to follow this format, so please be creative and come up with different approaches yourself.
 *  Note: Do not use class member/global/static variables to store states.
 *  Your serialize and deserialize algorithms should be stateless.
 * @author senwang
 *
 */
public class SerializeAndDeserializeBinaryTree {
	/**
	 * This is iterative serialize solution to this question, which
	 * uses breadth first search algorithm.
	 * @param root the root node of this tree.
	 * @return the string data represented by the tree.
	 */
	public static String solution_serialize(TreeNode root) {
		StringBuilder result = new StringBuilder("");
		if (root == null) {
		    return result.toString();
		}
		Queue<TreeNode> queue = new LinkedList<TreeNode>();
		queue.offer(root);
		while (!queue.isEmpty()) {
		    int size = queue.size();
		    while (size > 0) {
		        TreeNode curr = queue.poll();
		        size--;
		        if (curr == null) {
		            result.append("n");
		            result.append(",");
		            continue;
		        } else {
		            result.append(curr.val);
		            result.append(",");
		        }
		        queue.offer(curr.left);
		        queue.offer(curr.right);
		    }
		}
		return result.toString();
	}
	/**
	 * This is iterative de-serialize solution to this question. This solution uses reversed
	 * breadth first search algorithm.
	 * @param data the string representation of this tree.
	 * @return the root node of this tree.
	 */
	public static TreeNode solution_deserialize(String data) {
	    if (data.equals("")) {
	        return null;
	    }
	    String[] array = data.split(",");
	    Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
	    TreeNode root = new TreeNode(Integer.parseInt(array[0]));
	    queue.offer(root);
	    int index = 1;
	    while (index < array.length) {
	        TreeNode parent = queue.poll();
	        if (!array[index].equals("n")) {
	            parent.left = new TreeNode(Integer.parseInt(array[index]));
	            queue.offer(parent.left);
	        }
	        index++;
	        if (!array[index].equals("n")) {
	            parent.right = new TreeNode(Integer.parseInt(array[index]));
	            queue.offer(parent.right);
	        }
	        index++;
	    }
	    return root;
	}
	/**
	 * This is another iterative serialize solution, which uses depth first search algorithm.
     * @param root the root node of this tree.
     * @return the string data represented by the tree.
	 */
	public static String solution2_serialize(TreeNode root) {
	    StringBuilder result = new StringBuilder();
	    TreeNode temp = root;
	    Deque<TreeNode> stack = new LinkedList<TreeNode>();
	    while (temp != null || !stack.isEmpty()) {
	        if (temp != null) {
	            result.append(String.valueOf(temp.val));
	            result.append(",");
	            stack.push(temp);
	            temp = temp.left;
	        }
	        else {
	            result.append("n");
	            result.append(",");
	            temp = stack.pop();
	            temp = temp.right;
	        }
	    }
	    return result.toString();
	}
	/**
	 * This is another iterative de-serialize solution, which uses reverse
	 * depth first search algorithm.
     * @param data the string representation of this tree.
     * @return the root node of this tree.
	 */
	public static TreeNode solution2_deserialize(String data) {
	    if (data.length() == 0) {
	        return null;
	    }
	    Deque<TreeNode> stack = new LinkedList<TreeNode>();
	    String[] array = data.split(",");
	    TreeNode root = new TreeNode(Integer.parseInt(array[0]));
	    TreeNode temp = root;
	    stack.push(temp);
	    int index = 1;
	    int length = array.length;
	    while (index < length) {
	        System.out.println(index);
	        while (index < length && !array[index].equals("n")) {
	            temp.left = new TreeNode(Integer.parseInt(array[index]));
	            temp = temp.left;
	            stack.push(temp);
	            index++;
	        }
	        while (index < length && array[index].equals("n")) {
	            temp = stack.pop();
	            index++;
	        }
	        if (index < length) {
	            temp.right = new TreeNode(Integer.parseInt(array[index]));
	            temp = temp.right;
	            stack.push(temp);
	            index++;
	        }
	    }
	    return root;
	}
	/**
	 * This is the recursive serialize solution, which also uses depth first search algorithm.
     * @param root the root node of this tree.
     * @return the string data represented by the tree.
	 */
	public static String solution3_serialize(TreeNode root) {
	    StringBuilder result = new StringBuilder("");
	    solution3SerializeRec(root, result);
	    return result.toString();
	}
	/**
	 * This is the recursive helper function for the above solution.
	 * @param root the root node of this tree.
	 * @param str the string builder for storing the constructed string.
	 */
	private static void solution3SerializeRec(TreeNode root, StringBuilder str) {
	    if (root == null) {
	        str.append("n");
	        str.append(",");
	        return;
	    }
	    str.append(root.val);
	    str.append(",");
	    solution3SerializeRec(root.left, str);
	    solution3SerializeRec(root.right, str);
	}
	/**
	 * This is the recursive de-serialize solution to this question, which
	 * uses depth first search.
     * @param data the string representation of this tree.
     * @return the root node of this tree.
	 */
	public static TreeNode solution3_deserialize(String data) {
	    String[] array = data.split(",");
	    int[] index = new int[1];
	    return solution3DeserializeRec(index, array);
	}
	/**
	 * This is the recursive helper function for the solution above.
     * @param index the one size array for updating the index.
     * @param array the string array containing the traversal results.
     * @return the root node of this tree.
	 */
	private static TreeNode solution3DeserializeRec(int[] index, String[] array) {
	    if (array[index[0]].equals("n")) {
	        index[0]++;
	        return null;
	    }
	    TreeNode root = new TreeNode(Integer.parseInt(array[index[0]]));
	    index[0]++;
	    root.left = solution3DeserializeRec(index, array);
	    root.right = solution3DeserializeRec(index, array);
	    return root;
	}
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
	    TreeNode root = new TreeNode(1);
	    root.left = new TreeNode(2);
	    root.right = new TreeNode(3);
	    root.right.left = new TreeNode(4);
	    root.right.right = new TreeNode(5);
//	    root.right.left.left = new TreeNode(3);
//	    root.right.left.right = new TreeNode(1);
	    String str = SerializeAndDeserializeBinaryTree.solution3_serialize(root);
	    System.out.println(str);
	    TreeNode result = SerializeAndDeserializeBinaryTree.solution3_deserialize(str);
	    System.out.println(result.val);
	    System.out.println(result.left.val);
	    System.out.println(result.right.val);
	    System.out.println(result.right.left.val);
	    System.out.println(result.right.right.val);
//	    System.out.println(result.right.left.left.val);
//	    System.out.println(result.right.left.right.val);
	}
}
