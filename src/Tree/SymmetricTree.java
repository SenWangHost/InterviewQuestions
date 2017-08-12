/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).
 * For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
 *        1
 *       / \
 *      2   2
 *     / \ / \
 *    3  4 4  3
 * But the following [1,2,2,null,3,null,3] is not:
 *        1
 *       / \
 *      2   2
 *       \   \
 *        3    3
 * Note:
 * Bonus points if you could solve it both recursively and iteratively.
 * @author SenWang
 *
 */
public class SymmetricTree {
    /**
     * This is iterative solution to this question, which
     * uses breadth first search algorithm.
     * @param root the root node of one tree.
     * @return true if this tree is symmetric, false otherwise.
     */
    public static boolean solution(TreeNode root) {
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return true;
        }
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (curr.left != null) {
                    list1.add(Integer.toString(curr.left.val));
                    list2.add(0, Integer.toString(curr.left.val));
                    queue.offer(curr.left);
                } else {
                    list1.add("#");
                    list2.add(0, "#");
                }
                if (curr.right != null) {
                    list1.add(Integer.toString(curr.right.val));
                    list2.add(0, Integer.toString(curr.right.val));
                    queue.offer(curr.right);
                } else {
                    list1.add("#");
                    list2.add(0, "#");
                }
            }
            for (int i = 0; i < list1.size(); i++) {
                if (!list1.get(i).equals(list2.get(i))) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * This is another solution to this question, which uses
     * invert and equal function to check the symmetry.
     * @param root the root node of one tree.
     * @return true if this tree is symmetric, false otherwise.
     */
    public static boolean solution2(TreeNode root) {
        TreeNode invert = invertTree(root);
        return sameTree(invert, root);
    }
    /**
     * This is the helper function to invert the tree.
     * @param root the root node of the tree.
     * @return the root node of the inverted tree.
     */
    private static TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode result = new TreeNode(root.val);
        TreeNode left = root.left;
        TreeNode right = root.right;
        result.left = invertTree(right);
        result.right = invertTree(left);
        return result;
    }
    /**
     * This is the helper function to check whether two
     * trees are identical.
     * @param t1 the root node of the first tree.
     * @param t2 the root node of the second tree.
     * @return true if two trees are identical, false otherwise.
     */
    private static boolean sameTree(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && sameTree(t1.left, t2.left) && sameTree(t1.right, t2.right);
    }
    /**
     * This is the reference recursive solution to this question.
     * The straight forward explanation is on leetcode.
     * @param root the root node of one tree.
     * @return true if this tree is symmetric, false otherwise.
     */
    public static boolean solutionRef(TreeNode root) {
        return solutionRec(root, root);
    }
    /**
     * This is the recursive helper function for checking
     * the symmetry.
     * @param t1 the root node of the first input tree.
     * @param t2 the root node of the second input tree.
     * @return true if this tree is symmetrical, false otherwise.
     */
    private static boolean solutionRec(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && solutionRec(t1.left, t2.right) && solutionRec(t1.right, t2.left);
    }
    /**
     * This is reference iterative solution to this question, which uses
     * breadth first search algorithm but with some modifications.
     * The detailed explanation is on the leetcode.
     * @param root the root node of one tree.
     * @return true if this tree is symmetric, false otherwise.
     */
    public static boolean solutionRef2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node1 = queue.poll();
            TreeNode node2 = queue.poll();
            if (node1 == null && node2 == null) {
                continue;
            }
            if (node1 == null || node2 == null) {
                return false;
            }
            if (node1.val != node2.val) {
                return false;
            }
            queue.offer(node1.left);
            queue.offer(node2.right);
            queue.offer(node1.right);
            queue.offer(node2.left);
        }
        return true;
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
        TreeNode root = new TreeNode(4);
        root.left = new TreeNode(57);
        root.right = new TreeNode(57);
        root.left.left = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.right.left = new TreeNode(4);
        root.right.right = new TreeNode(3);
        boolean result = SymmetricTree.solution2(root);
        System.out.println(result);
    }
}
