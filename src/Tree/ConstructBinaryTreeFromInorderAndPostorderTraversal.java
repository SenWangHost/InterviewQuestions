/**
 *
 */
package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author SenWang
 *
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {
	/**
	 * This is the recursive solution to this question.
	 * @param inorder the in order traversal traversal array of this tree.
	 * @param postorder the post order traversal array of this tree.
	 * @return the root node of the constructed tree.
	 */
	public static TreeNode solution(int[] inorder, int[] postorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return solutionRec(postorder.length - 1, 0, inorder.length - 1, map, postorder);
	}
	/**
	 * This is the recursive helper function for the solution above.
	 * @param postIndex the index for tracking element in the post order array.
	 * @param inStart the starting range for searching element in the in order array.
	 * @param inEnd the ending range for searching element in the in order array.
	 * @param map the hashmap that converted from the in order array.
	 * @param postorder the array of postorder traversal.
	 * @return the node constructed from those two traversal.
	 */
	private static TreeNode solutionRec(int postIndex, int inStart, int inEnd, Map<Integer, Integer> map, int[] postorder) {
		if (postIndex < 0 || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(postorder[postIndex]);
		int index = map.get(root.val);
		root.left = solutionRec(postIndex - (inEnd - index + 1), inStart, index - 1, map, postorder);
		root.right = solutionRec(postIndex - 1, index + 1, inEnd, map, postorder);
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
		int[] inorder = {4, 10, 3, 1, 7, 11, 8, 2};
		int[] postorder = {4, 1, 3, 10, 11, 8, 2, 7};
		TreeNode root = ConstructBinaryTreeFromInorderAndPostorderTraversal.solution(inorder, postorder);
		System.out.println(root.val);
		System.out.println(root.left.val);
		System.out.println(root.right.val);
		System.out.println(root.left.left.val);
		System.out.println(root.left.right.val);
		System.out.println(root.left.right.right.val);
		System.out.println(root.right.left.val);
		System.out.println(root.right.left.left.val);
	}
}
