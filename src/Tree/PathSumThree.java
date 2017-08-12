/**
 *
 */
package Tree;

import java.util.HashMap;
import java.util.Map;

/**
 * You are given a binary tree in which each node contains an integer value.
 * Find the number of paths that sum to a given value.
 * The path does not need to start or end at the root or a leaf, but it must go downwards
 * (traveling only from parent nodes to child nodes).
 * The tree has no more than 1,000 nodes and the values are in the range -1,000,000 to 1,000,000.
 * Example:root = [10,5,-3,3,2,null,11,3,-2,null,1], sum = 8
 *            10
 *           /  \
 *          5   -3
 *         / \    \
 *        3   2   11
 *       / \   \
 *      3  -2   1
 * Return 3. The paths that sum to 8 are:
 * 1.  5 -> 3
 * 2.  5 -> 2 -> 1
 * 3. -3 -> 11
 * @author senwang
 *
 */
public class PathSumThree {
	/**
	 * This is the recursive solution to this question.
	 * This alogorithm is the same as one of the reference solution on leetcodes,
	 * the runtime complexity would be O(n^2) in the worst case and O(nlog(n)) in the average case.
	 * @param root the root node of this tree.
	 * @param sum the specific sum for find the path.
	 * @return the number of path that has exact sum.
	 */
	public static int solution(TreeNode root, int sum) {
		if (root == null) {
			return 0;
		}
		int countNode = countPathNode(root, sum);
		return countNode + solution(root.left, sum) + solution(root.right, sum);
	}
	/**
	 * This is the recursive helper function to find possible paths
	 * starting from this node.
	 * @param node the starting node of the path.
	 * @param sum the path for finding the path.
	 */
	private static int countPathNode(TreeNode node, int sum) {
		if (node == null) {
			return 0;
		}
		int count = 0;
		if (node.val == sum) {
			count = 1;
		}
		return count + countPathNode(node.left, sum - node.val) + countPathNode(node.right, sum - node.val);
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
     * This is the reference solution to this question, which uses hashmap
     * to store the currSum and its frequency. The detailed explanation is on
     * leetcode, it is pretty hard to understand.
	 * @param root the root node of this tree.
	 * @param sum the specific sum for find the path.
	 * @return the number of path that has exact sum.
     */
    public static int solutionRef(TreeNode root, int sum) {
    	Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    	map.put(0, 1);
    	return solutionRefHelper(root, 0, sum, map);
    }
    /**
     * This is the recursive helper function for the reference solution above.
     * @param root the root node of this tree.
     * @param currSum the current Sum from root to this node.
     * @param target the target sum that we should find.
     * @param map the hashmap for storing sum and frequencies.
     * @return the number of path that has exact sum.
     */
    private static int solutionRefHelper(TreeNode root, int currSum, int target, Map<Integer, Integer> map) {
    	if (root == null) {
    		return 0;
    	}
    	currSum += root.val;
    	int result = map.getOrDefault(currSum - target, 0);
    	map.put(currSum, map.getOrDefault(currSum, 0) + 1);
    	result += solutionRefHelper(root.left, currSum, target, map) + solutionRefHelper(root.right, currSum, target, map);
    	map.put(currSum, map.get(currSum) - 1);
    	return result;
    }
	/**
	 * This is the test function for this question.
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		TreeNode root = new TreeNode(10);
		root.left = new TreeNode(5);
		root.right = new TreeNode(-3);
		root.left.left = new TreeNode(3);
		root.left.right = new TreeNode(2);
		root.left.left.left = new TreeNode(3);
		root.left.left.right = new TreeNode(-2);
		root.left.right.right = new TreeNode(1);
		root.right.right = new TreeNode(11);
		System.out.println(countPathNode(root.right, 8));
		int result = PathSumThree.solutionRef(root, 8);
		System.out.println(result);
	}
}
