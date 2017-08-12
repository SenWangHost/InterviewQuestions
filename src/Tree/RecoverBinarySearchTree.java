/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Two elements of a binary search tree (BST) are swapped by mistake.
 * Recover the tree without changing its structure.
 * Note:
 * A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
 * @author SenWang
 *
 */
public class RecoverBinarySearchTree {
    /**
     * This is the iterative solution to this question.
     * @param root the root node of this tree.
     */
    public static void solution(TreeNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode temp = root;
        while (temp != null) {
            stack.push(temp);
            temp = temp.left;
        }
        TreeNode first = null;
        TreeNode second = null;
        TreeNode prev = null;
        while (!stack.isEmpty()) {
            TreeNode curr = stack.pop();
            if (prev != null) {
                if (first == null && prev.val >= curr.val) {
                    first = prev;
                }
                if (first != null && prev.val >= curr.val) {
                    second = curr;
                }
            }
            TreeNode right = curr.right;
            while (right != null) {
                stack.push(right);
                right = right.left;
            }
            prev = curr;
        }
        // swap back the values
        if (first != null && second != null) {
            int val1 = first.val;
            int val2 = second.val;
            first.val = val2;
            second.val = val1;
        }
    }
    /**
     * This is the recursive solution to this question, which
     * uses the same algorithm as the iterative solution shown above.
     * @param root the root node of this tree.
     */
    public static void solution2(TreeNode root) {
        TreeNode[] mistake = new TreeNode[3];
        solutionRec(root, mistake);
        int val1 = mistake[0].val;
        int val2 = mistake[1].val;
        mistake[0].val = val2;
        mistake[1].val = val1;
    }
    /**
     * This is recursive helper function for this question.
     * @param root the root node of this tree.
     * @param prev the parent node of the current node.
     * @param array a two-size array containing the mistakenly swapped nodes.
     */
    private static void solutionRec(TreeNode root, TreeNode[] array) {
        if (root == null) {
            return;
        }
        solutionRec(root.left, array);
        if (array[2] != null) {
            if (array[0] == null && array[2].val >= root.val) {
                array[0] = array[2];
            }
            if (array[0] != null && array[2].val >= root.val) {
                array[1] = root;
            }
        }
        array[2] = root;
        solutionRec(root.right, array);
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
        root.left = new TreeNode(2);
        root.right = new TreeNode(5);
        root.left.left = new TreeNode(6);
        root.left.right = new TreeNode(3);
        root.right.right = new TreeNode(1);
        RecoverBinarySearchTree.solution2(root);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.right.val);
    }
}
