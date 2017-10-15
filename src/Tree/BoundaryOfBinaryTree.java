/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return the values of its boundary in anti-clockwise direction starting from root.
 * Boundary includes left boundary, leaves, and right boundary in order without duplicate nodes.
 * Left boundary is defined as the path from root to the left-most node. Right boundary is defined as the
 * path from root to the right-most node. If the root doesn't have left subtree or right subtree, then
 * the root itself is left boundary or right boundary. Note this definition only applies to the input binary
 * tree, and not applies to any subtrees.
 * The left-most node is defined as a leaf node you could reach when you always firstly travel to the
 * left subtree if exists. If not, travel to the right subtree. Repeat until you reach a leaf node.
 * The right-most node is also defined by the same way with left and right exchanged.
 *
 * Example 1
 * Input:
 *     1
 *      \
 *       2
 *      / \
 *     3   4
 * Ouput:
 * [1, 3, 4, 2]
 * Explanation:
 * The root doesn't have left subtree, so the root itself is left boundary.
 * The leaves are node 3 and 4.
 * The right boundary are node 1,2,4. Note the anti-clockwise direction means you should output reversed right boundary.
 * So order them in anti-clockwise without duplicates and we have [1,3,4,2].
 *
 *
 * Example 2
 * Input:
 *          ____1_____
 *         /          \
 *        2            3
 *       / \          /
 *      4   5        6
 *     / \  / \
 *    7   8 9  10
 * Ouput:
 * [1,2,4,7,8,9,10,6,3]
 * Explanation:
 * The left boundary are node 1,2,4. (4 is the left-most node according to definition)
 * The leaves are node 4,7,8,9,10.
 * The right boundary are node 1,3,6,10. (10 is the right-most node).
 * So order them in anti-clockwise without duplicate nodes we have [1,2,4,7,8,9,10,6,3].
 * @author SenWang
 *
 */
public class BoundaryOfBinaryTree {
    /**
     * this is my own solution
     */
    public static List<Integer> solution(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        if (root == null) {
            return result;
        }
        // get the left boundary
        result.add(root.val);
        TreeNode leftNode = root.left;
        while (leftNode != null) {
            result.add(leftNode.val);
            if (leftNode.left != null) {
                leftNode = leftNode.left;
            } else if (leftNode.right != null){
                leftNode = leftNode.right;
            } else {
                break;
            }
        }
        // System.out.println(result);
        List<Integer> leaves = new ArrayList<Integer>();
        getLeaves(root, leaves);
        // System.out.println(leaves);
        for (int num : leaves) {
            if (!result.contains(num)) {
                result.add(num);
            }
        }
        // get the right boundary
        List<Integer> right = new ArrayList<Integer>();
        TreeNode rightNode = root.right;
        while (rightNode != null) {
            right.add(rightNode.val);
            if (rightNode.right != null) {
                rightNode = rightNode.right;
            } else if (rightNode.left != null) {
                rightNode = rightNode.left;
            } else {
                break;
            }
        }
        // System.out.println(right);
        for (int i = right.size() - 1; i >= 0; i--) {
            if (!result.contains(right.get(i))) {
                result.add(right.get(i));
            }
        }
        return result;
    }
    /**
     * the helper function to traverse to get all leave nodes
     */
    public static void getLeaves(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        getLeaves(root.left, list);
        if (root.left == null && root.right == null) {
            list.add(root.val);
        }
        getLeaves(root.right, list);
    }
    /**
     * THis is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.right = new TreeNode(5);
        root.left.right.left = new TreeNode(7);
        root.left.right.right = new TreeNode(8);
        root.right.left = new TreeNode(6);
        root.right.left.left = new TreeNode(9);
        root.right.left.right = new TreeNode(10);
        List<Integer> result = solution(root);
        System.out.println(result);
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
}
