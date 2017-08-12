/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 * For example:
 * Given binary tree [3,9,20,null,null,15,7],
 *        3
 *       / \
 *      9  20
 *        /  \
 *       15   7
 * return its zigzag level order traversal as:
 * [
 *  [3],
 *  [20,9],
 *  [15,7]
 * ]
 * @author SenWang
 *
 */
public class BinaryTreeZigZagLevelOrderTraversal {
    /**
     * This is the iterative solution to this question, which uses
     * breadth first search algorithm.
     * @param root the root node of this tree.
     * @return a two-dimensional array containing the traversal.
     */
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> queue = new ArrayDeque<TreeNode>();
        if (root == null) {
            return result;
        }
        queue.offer(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<Integer>();
            while (size > 0) {
                TreeNode curr = queue.poll();
                size--;
                if (level % 2 == 0) {
                    list.add(curr.val);
                } else {
                    list.add(0, curr.val);
                }
                if (curr.left != null) {
                    queue.offer(curr.left);
                }
                if (curr.right != null) {
                    queue.offer(curr.right);
                }
            }
            result.add(list);
            level++;
        }
        return result;
    }
    /**
     * This is another iterative solution, which uses depth first search
     * algorithm.
     * @param root the root node of this tree.
     * @return a two-dimensional array containing the traversal.
     */
    public static List<List<Integer>> solution2(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        Deque<Integer> levelStack = new ArrayDeque<Integer>();
        if (root == null) {
            return result;
        }
        nodeStack.push(root);
        levelStack.push(0);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int level = levelStack.pop();
            if (level >= result.size()) {
                result.add(new ArrayList<Integer>());
            }
            List<Integer> temp = result.get(level);
            if (level % 2 == 0) {
                temp.add(curr.val);
            } else {
                temp.add(0, curr.val);
            }
            if (curr.right != null) {
                nodeStack.push(curr.right);
                levelStack.push(level + 1);
            }
            if (curr.left != null) {
                nodeStack.push(curr.left);
                levelStack.push(level + 1);
            }
        }
        return result;
    }
    /**
     * This is the recursive solution to this question, which also
     * uses depth first search algorithm.
     * @param root the root node of this tree.
     * @return a two-dimensional array containing the traversal.
     */
    public static List<List<Integer>> solution3(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        solutionRec(root, 0, result);
        return result;
    }
    /**
     * This is the recursive helper function for this question.
     * @param root the root node of this tree.
     * @param level the level the current node is at.
     * @param list a two-dimensional array containing the traversal.
     */
    private static void solutionRec(TreeNode root, int level, List<List<Integer>> list) {
        if (root == null) {
            return;
        }
        if (level >= list.size()) {
            list.add(new ArrayList<Integer>());
        }
        if (level < list.size()) {
            List<Integer> temp = list.get(level);
            if (level % 2 == 0) {
                temp.add(root.val);
            } else {
                temp.add(0, root.val);
            }
        }
        solutionRec(root.left, level + 1, list);
        solutionRec(root.right, level + 1, list);
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
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(20);
        root.right.left = new TreeNode(15);
        root.right.right = new TreeNode(7);
        List<List<Integer>> result = BinaryTreeZigZagLevelOrderTraversal.solution3(root);
        for (int i = 0; i < result.size(); i++) {
            System.out.print("[");
            List<Integer> temp = result.get(i);
            for (int j = 0; j < temp.size(); j++) {
                System.out.print(temp.get(j) + ", ");
            }
            System.out.print("]");
            System.out.println("");
        }
    }

}
