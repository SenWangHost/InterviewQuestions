/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a binary search tree (BST) with duplicates, f
 * ind all the mode(s) (the most frequently occurred element) in the given BST.
 * Assume a BST is defined as follows:
 * The left subtree of a node contains only nodes with keys less than or equal to the node's key.
 * The right subtree of a node contains only nodes with keys greater than or equal to the node's key.
 * Both the left and right subtrees must also be binary search trees.
 * For example:
 * Given BST [1,null,2,2],
 *      1
 *       \
 *        2
 *       /
 *      2
 * return [2].
 * Note: If a tree has more than one mode, you can return them in any order.
 * Follow up: Could you do that without using any extra space? (Assume that the implicit stack space incurred due
 * to recursion does not count).
 * @author SenWang
 *
 */
public class FindModeInBST {
    /**
     * This is my own iterative solution to this question.
     * @param root the root node of this tree.
     * @return an integer array containing the modes.
     */
    public static int[] solution(TreeNode root) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        if (root == null) {
            return new int[0];
        }
        int maxFre = 0;
        stack.push(root);
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (map.containsKey(curr.val)) {
                map.put(curr.val, map.get(curr.val) + 1);
                maxFre = Math.max(maxFre, map.get(curr.val));
            } else {
                map.put(curr.val, 1);
                maxFre = Math.max(maxFre, 1);
            }
            if (curr.right != null) {
                stack.push(curr.right);
            }
            if (curr.left != null) {
                stack.push(curr.left);
            }
        }
        Set<Integer> key = map.keySet();
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = key.iterator();
        while (iter.hasNext()) {
            int value = iter.next();
            if (map.get(value) == maxFre) {
                result.add(value);
            }
        }
        int[] temp = new int[result.size()];
        for (int i = 0; i < result.size(); i++) {
            temp[i] = result.get(i);
        }
        return temp;
    }
    /**
     * This is the global variables need for the reference solution.
     */
    private static Integer prev = null;
    private static int count = 1;
    private static int max = 0;
    /**
     * This is the reference solution to this question without using hashmap function.
     * @param root the root node of this tree.
     * @return an integer array containing the modes.
     */
    public static int[] solutionRef(TreeNode root) {
        if (root == null) {
            return new int[0];
        }
        List<Integer> list = new ArrayList<Integer>();
        traverse(root, list);
        int[] result = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            result[i] = list.get(i);
        }
        return result;
    }
    /**
     * This is the recursive helper function to traverse the tree
     * and count the frequency of each element.
     * @param root the root node of this tree.
     * @param list the list containing all the modes.
     */
    private static void traverse(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        traverse(root.left, list);
        if (prev != null) {
            if (prev == root.val) {
                count++;
            } else {
                count = 1;
            }
        }
        if (count > max) {
            max = count;
            list.clear();
            list.add(root.val);
        } else if (count == max) {
            list.add(root.val);
        }
        prev = root.val;
        traverse(root.right, list);
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
        root.left = new TreeNode(5);
        root.right = new TreeNode(8);
        root.left.left = new TreeNode(4);
        root.right.left = new TreeNode(8);
        root.right.right = new TreeNode(9);
        int[] result = FindModeInBST.solution(root);
        for (int num : result) {
            System.out.println(num);
        }
    }

}
