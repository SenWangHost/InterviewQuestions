/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given the root of a tree, you are asked to find the most frequent subtree sum.
 * The subtree sum of a node is defined as the sum of all the node values formed by the subtree rooted at
 * that node (including the node itself). So what is the most frequent subtree sum value? If there is a tie,
 * return all the values with the highest frequency in any order.
 * Examples 1
 * Input:
 *       5
 *     /  \
 *    2   -3
 * return [2, -3, 4], since all the values happen only once, return all of them in any order.
 * Examples 2
 * Input:
 *       5
 *     /  \
 *    2   -5
 * return [2], since 2 happens twice, however -5 only occur once.
 * Note: You may assume the sum of values in any subtree is in the range of 32-bit signed integer.
 * @author senwang
 *
 */
public class MostFrequentSubtreeSum {
	/**
	 * This is the recursive solution to this question.
	 * @param root the root node of this tree.
	 * @return the integer array containing the most frequent subtree sum.
	 */
	public static int[] solution(TreeNode root) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		List<Integer> list = new ArrayList<Integer>();
		int[] maxFre = new int[1];
		solutionRec(root, maxFre, list, map);
		int[] result = new int[list.size()];
		for (int i = 0; i < list.size(); i++) {
			result[i] = list.get(i);
		}
		return result;
	}
	/**
	 * This is recursive helper function to the solution above.
	 * @param root the root node of this tree.
	 * @param max the one-size array for updating the max frequency encountered.
	 * @param list the list for storing the sum which has the max frequency.
	 * @param map the hash map for storing sum and frequency.
	 */
	private static int solutionRec(TreeNode root, int[] max, List<Integer> list, Map<Integer, Integer> map) {
		if (root == null) {
			return 0;
		}
		int sumNode = root.val + solutionRec(root.left, max, list, map) + solutionRec(root.right, max, list, map);
		map.put(sumNode, map.getOrDefault(sumNode, 0) + 1);
		int fre = map.get(sumNode);
		if (fre > max[0]) {
			max[0] = fre;
			list.clear();
			list.add(sumNode);
		} else if (fre == max[0]){
			list.add(sumNode);
		}
		return sumNode;
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
		TreeNode root = new TreeNode(5);
		root.left = new TreeNode(2);
		root.right = new TreeNode(-3);
		int[] result = MostFrequentSubtreeSum.solution(root);
		for (int num : result) {
			System.out.println(num);
		}
	}

}
