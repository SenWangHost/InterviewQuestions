/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 * For example:
 * Given the below binary tree and sum = 22
 *            5
 *           / \
 *          4   8
 *         /   / \
 *        11  13  4
 *       /  \    / \
 *      7    2  5   1
 * return
 * [
 *  [5,4,11,2],
 *  [5,8,4,5]
 * ]
 * @author senwang
 *
 */
public class PathSumTwo {
	/**
	 * This is the iterative solution to this question.
	 * @param root the root node of this tree.
	 * @param sum the sum of nodes to find the path.
	 * @return a two dimensional array containing the path results.
	 */
	public static List<List<Integer>> solution(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
		Deque<List<Integer>> pathStack = new ArrayDeque<List<Integer>>();
		Deque<Integer> sumStack = new ArrayDeque<Integer>();
		nodeStack.push(root);
		List<Integer> path = new ArrayList<Integer>();
		path.add(root.val);
		pathStack.push(path);
		sumStack.push(root.val);
		while (!nodeStack.isEmpty()) {
			TreeNode curr = nodeStack.pop();
			List<Integer> currPath = pathStack.pop();
			int currSum = sumStack.pop();
			if (currSum > sum) {
				continue;
			}
			if (currSum == sum && curr.left == null && curr.right == null) {
				result.add(currPath);
			}
			if (curr.right != null) {
				nodeStack.push(curr.right);
				List<Integer> rightPath = new ArrayList<Integer>(currPath);
				rightPath.add(curr.right.val);
				pathStack.push(rightPath);
				sumStack.push(currSum + curr.right.val);
			}
			if (curr.left != null) {
				nodeStack.push(curr.left);
				List<Integer> leftPath = new ArrayList<Integer>(currPath);
				leftPath.add(curr.left.val);
				pathStack.push(leftPath);
				sumStack.push(currSum + curr.left.val);
			}
		}
		return result;
	}
	/**
	 * This is the recursive solution to this question, which also
	 * uses depth first search algorithm.
	 * @param root the root node of this tree.
	 * @param sum the sum of nodes to find the path.
	 * @return a two dimensional array containing the path results.
	 */
	public static List<List<Integer>> solution2(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		solutionRec(root, new ArrayList<Integer>(),result, sum);
		return result;
	}
	/**
	 * This is the recursive helper function for the solution above.
	 * @param root the root node of this tree.
	 * @param result the two dimensional list for containing the results.
	 * @param sum the sum for finding the path.
	 */
	private static void solutionRec(TreeNode root, List<Integer> path, List<List<Integer>> result, int sum) {
		if (root == null) {
			return;
		}
		path.add(root.val);
		if (root.val == sum && root.left == null && root.right == null) {
			result.add(path);
			return;
		}
		List<Integer> leftPath = new ArrayList<Integer>(path);
		List<Integer> rightPath = new ArrayList<Integer>(path);
		solutionRec(root.left, leftPath, result, sum - root.val);
		solutionRec(root.right, rightPath, result, sum - root.val);
	}
	/**
	 * This is the similar iterative solution to the first solution, but use
	 * the wrapper class instead of three stacks.
	 * @param root the root node of this tree.
	 * @param sum the sum of nodes to find the path.
	 * @return a two dimensional array containing the path results.
	 */
	public static List<List<Integer>> solution3(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		if (root == null) {
			return result;
		}
		List<Integer> init = new ArrayList<Integer>();
		init.add(root.val);
		Node start = new Node(root, init, root.val);
		Deque<Node> stack = new ArrayDeque<Node>();
		stack.push(start);
		while (!stack.isEmpty()) {
			Node curr = stack.pop();
			TreeNode tNode = curr.treeNode;
			List<Integer> path = curr.path;
			int currSum = curr.sum;
			if (currSum == sum && tNode.left == null && tNode.right == null) {
				result.add(path);
			}
			if (tNode.right != null) {
				List<Integer> right = new ArrayList<Integer>(path);
				right.add(tNode.right.val);
				Node rightNode = new Node(tNode.right, right, currSum + tNode.right.val);
				stack.push(rightNode);
			}
			if (tNode.left != null) {
				List<Integer> left = new ArrayList<Integer>(path);
				left.add(tNode.left.val);
				Node leftNode = new Node(tNode.left, left, currSum + tNode.left.val);
				stack.push(leftNode);
			}
		}
		return result;
	}
	/**
	 * This is the wrapper class for the solution above.
	 * @author senwang
	 */
	private static class Node {
		/**
		 * The field for storing tree node.
		 */
		private TreeNode treeNode;
		/**
		 * The field for storing path list.
		 */
		private List<Integer> path;
		/**
		 * The field for storing the sum of the path.
		 */
		private int sum;
		/**
		 * The constructor for the warpper class.
		 * @param node the treenode for storing
		 * @param list the list path for storing.
		 * @param sumVal the sum value for storing.
		 */
		private Node(TreeNode node, List<Integer> list, int sumVal) {
			treeNode = node;
			path = list;
			sum = sumVal;
		}
	}
	/**
	 * This is one reference solution that uses array instead of list
	 * to remember the path. In this way, we don't have copy arraylist each time for
	 * storing the path for each node.
	 * @param root the root node of this tree.
	 * @param sum the sum of nodes to find the path.
	 * @return a two dimensional array containing the path results.
	 */
	public static List<List<Integer>> solutionRef(TreeNode root, int sum) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
		int[] pathStorage = new int[2000];
		solutionRefHelper(root, 0, pathStorage, result, sum);
		return result;
	}
	/**
	 * This is the recursive helper function for the reference solution above.
	 * @param root the root node of this tree.
	 * @param index the index for putting node value into path storage.
	 * @param storage the integer for storing the path.
	 * @param result the two dimensional result for final result.
	 */
	private static void solutionRefHelper(TreeNode root, int index, int[] storage, List<List<Integer>> list, int sum) {
		if (root == null) {
			return;
		}
		storage[index] = root.val;
		if (root.val == sum && root.left == null && root.right == null) {
			List<Integer> temp = new ArrayList<Integer>();
			for (int i = 0; i <= index; i++) {
				temp.add(storage[i]);
			}
			list.add(temp);
			return;
		}
		solutionRefHelper(root.left, index + 1, storage, list, sum - root.val);
		solutionRefHelper(root.right, index + 1, storage, list, sum - root.val);
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
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(4);
		root.right = new TreeNode(8);
		root.left.left = new TreeNode(11);
		root.left.left.left = new TreeNode(7);
		root.left.left.right = new TreeNode(2);
		root.right.left = new TreeNode(13);
		root.right.right = new TreeNode(4);
		root.right.right.left = new TreeNode(5);
		root.right.right.right = new TreeNode(1);
		List<List<Integer>> result = PathSumTwo.solutionRef(root, 22);
		for (int i = 0; i < result.size(); i++) {
			System.out.print("[");
			List<Integer> list = result.get(i);
			for (int j = 0; j < list.size(); j++) {
				System.out.print(list.get(j));
				System.out.print(", ");
			}
			System.out.print("]");
			System.out.println("");
		}
	}

}
