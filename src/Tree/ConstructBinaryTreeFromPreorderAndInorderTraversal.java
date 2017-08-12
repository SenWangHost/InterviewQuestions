/**
 *
 */
package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @author senwang
 *
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {
	/**
	 * This is the reference recursive solution to this question.
	 * @param preorder the preorder traversal results for a tree.
	 * @param inorder the inorder traversal results for a tree.
	 * @return the root node of the constructed binary tree.
	 */
	public static TreeNode solution(int[] preorder, int[] inorder) {
		return solutionRec(0, 0, inorder.length - 1, preorder, inorder);
	}
	/**
	 * This is recursive helper function for the solution above.
	 * @param preIndex the index for tracking the element in the preorder array.
	 * @param inStart the index for the starting range of searching in inorder array.
	 * @param inEnd the index for the ending range of searching in inorder array.
	 * @param preorder the preorder traversal array.
	 * @param inorder the inorder traversal array.
	 * @return the tree node constructed by the picking the element.
	 */
	private static TreeNode solutionRec(int preStart, int inStart, int inEnd, int[] preorder, int[] inorder) {
		if (preStart >= preorder.length || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = 0;
		// search the current root val in the inorder array.
		for (int i = inStart; i <= inEnd; i++) {
			if (inorder[i] == root.val) {
				index = i;
			}
		}
		root.left = solutionRec(preStart + 1, inStart, index - 1, preorder, inorder);
		root.right = solutionRec(preStart + index - inStart + 1, index + 1, inEnd, preorder, inorder);
		return root;
	}
	/**
	 * This is one optimized solution for the recursive solution above, which simply
	 * convert the inorder array to a hashmap to make the search constant time.
	 * @param preorder the preorder traversal results for a tree.
	 * @param inorder the inorder traversal results for a tree.
	 * @return the root node of the constructed binary tree.
	 */
	public static TreeNode solution2(int[] preorder, int[] inorder) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for (int i = 0; i < inorder.length; i++) {
			map.put(inorder[i], i);
		}
		return solutionRec2(0, 0, inorder.length - 1, preorder, map);
	}
	/**
	 * This is recursive helper function for the solution above.
	 * @param preIndex the index for tracking the element in the preorder array.
	 * @param inStart the index for the starting range of searching in inorder array.
	 * @param inEnd the index for the ending range of searching in inorder array.
	 * @param preorder the preorder traversal array.
	 * @param inorder the inorder traversal array.
	 * @return the tree node constructed by the picking the element.
	 */
	private static TreeNode solutionRec2(int preStart, int inStart, int inEnd, int[] preorder, Map<Integer, Integer> map) {
		if (preStart >= preorder.length || inStart > inEnd) {
			return null;
		}
		TreeNode root = new TreeNode(preorder[preStart]);
		int index = map.get(root.val);
		root.left = solutionRec2(preStart + 1, inStart, index - 1, preorder, map);
		root.right = solutionRec2(preStart + index - inStart + 1, index + 1, inEnd, preorder, map);
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
		int[] preorder = {7, 10, 4, 3, 1, 2, 8, 11};
		int[] inorder = {4, 10, 3, 1, 7, 11, 8, 2};
		TreeNode root = ConstructBinaryTreeFromPreorderAndInorderTraversal.solution2(preorder, inorder);
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
