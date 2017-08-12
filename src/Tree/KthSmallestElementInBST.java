/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary search tree, write a function kthSmallest to find the kth smallest element in it.
 * Note:
 * You may assume k is always valid, 1 ? k ? BST's total elements.
 * Follow up:
 * What if the BST is modified (insert/delete operations) often and you need to find the kth smallest frequently?
 * How would you optimize the kthSmallest routine?
 * @author SenWang
 *
 */
public class KthSmallestElementInBST {
    /**
     * This is recursive solution to this question, which in order
     * traversal the tree and get the kth smallest element.
     * @param root the root node of the tree.
     * @param k the kth smallest element.
     * @return the kth smallest element in the tree.
     */
    public static int solution(TreeNode root, int k) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        int count = 0;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            count++;
            if (count == k) {
                return curr.val;
            }
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
        }
        return root.val;
    }
    /**
     * This is the recursive function to this question, the algorithm
     * is the same as the above solution.
     * @param root the root node of the tree.
     * @param k the kth smallest element.
     * @return the kth smallest element in the tree.
     */
    public static int solution2(TreeNode root, int k) {
        List<Integer> result = new ArrayList<Integer>();
        solutionRec(root, result, k);
        return result.get(result.size() - 1);
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param root the root node of the tree.
     * @param list the list containing the traversal result.
     */
    private static void solutionRec(TreeNode root, List<Integer> list, int k) {
        if (root == null) {
            return;
        }
        if (list.size() >= k) {
            return;
        }
        solutionRec(root.left, list, k);
        if (list.size() < k) {
            list.add(root.val);
        }
        solutionRec(root.right, list, k);

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
        TreeNode root = new TreeNode(8);
        root.left = new TreeNode(4);
        root.right = new TreeNode(9);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.right.right = new TreeNode(10);
        int result = KthSmallestElementInBST.solution2(root, 3);
        System.out.println(result);
    }
}
