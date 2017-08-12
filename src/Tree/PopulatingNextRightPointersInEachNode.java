/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a binary tree
 * struct TreeLinkNode {
 *    TreeLinkNode *left;
 *    TreeLinkNode *right;
 *    TreeLinkNode *next;
 * }
 * Populate each next pointer to point to its next right node. If there is no next right node,
 * the next pointer should be set to NULL.
 * Initially, all next pointers are set to NULL.
 * Note:
 * 1. You may only use constant extra space.
 * 2. You may assume that it is a perfect binary tree (ie, all leaves are at the same level,
 * and every parent has two children).
 * For example,
 * Given the following perfect binary tree,
 *          1
 *        /   \
 *       2     3
 *     /  \   /  \
 *    4    5 6    7
 * After calling your function, the tree should look like:
 *          1 -> NULL
 *        /  \
 *       2 -> 3 -> NULL
 *      / \  / \
 *     4->5->6->7 -> NULL
 * @author SenWang
 *
 */
public class PopulatingNextRightPointersInEachNode {
    /**
     * This is the iterative solution to this question.
     * which uses level order traversal.
     * @param root the root node of this tree.
     * @return the root node of this tree after populating.
     */
    public static void solution(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        Deque<TreeLinkNode> queue = new ArrayDeque<TreeLinkNode>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeLinkNode first = queue.poll();
                size--;
                TreeLinkNode second = null;
                if (size != 0) {
                    second = queue.peek();
                }
                first.next = second;
                if (first.left != null) {
                    queue.offer(first.left);
                }
                if (first.right != null) {
                    queue.offer(first.right);
                }
            }
        }
    }
    /**
     * This is the recursive solution to this question.
     * @param root the root node of this tree.
     * @return the root node of this tree after populating.
     */
    public static void solution2(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        RecLink1(root);
        RecLink2(root.left, root.right);
    }
    /**
     * This is the recursive helper function to link left to right.
     * @param root the root node of this tree.
     */
    private static void RecLink1(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left == null && root.right == null) {
            return;
        }
        root.left.next = root.right;
        RecLink1(root.left);
        RecLink1(root.right);
    }
    /**
     * This is the recursive helper function to link intermediate node
     * @param left the left child of the parent.
     * @param right the right child of the parent.
     */
    private static void RecLink2(TreeLinkNode left, TreeLinkNode right) {
        if (left == null && right == null) {
            return;
        }
        if (left.right == null && right.left == null) {
            return;
        }
        left.right.next = right.left;
        RecLink2(left.left, left.right);
        RecLink2(left.right, right.left);
        RecLink2(right.left, right.right);
    }
    /**
     * This is another recursive solution to this question.
     * @param root the root node of this tree.
     * @return the root node of this tree after populating.
     */
    public static void solution3(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        if (root.left != null) {
            root.left.next = root.right;
            if (root.next != null) {
                root.right.next = root.next.left;
            }
        }
        solution3(root.left);
        solution3(root.right);
    }
    /**
     * This is the iterative reference solution to this question.
     * @param root the root node of this tree.
     * @return the root node of this tree after populating.
     */
    public static void solutionRef(TreeLinkNode root) {
        TreeLinkNode levelStart = root;
        while (levelStart != null) {
            TreeLinkNode curr = levelStart;
            while (curr != null) {
                if (curr.left != null) {
                    curr.left.next = curr.right;
                }
                if (curr.right != null && curr.next != null) {
                    curr.right.next = curr.next.left;
                }
                curr = curr.next;
            }
            levelStart = levelStart.left;
        }
    }
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeLinkNode {
        /**
         * The field for storing the integer.
         */
        private int val;
        /**
         * The left reference to another tree node.
         */
        private TreeLinkNode left;
        /**
         * The right reference to another tree node.
         */
        private TreeLinkNode right;
        /**
         * Thee next reeference to anothe tree node.
         */
        private TreeLinkNode next;
        /**
         * The constructor for the tree node
         * @param x the integer value to be stored into the tree node.
         */
        private TreeLinkNode(int x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.left = new TreeLinkNode(6);
        root.right.right = new TreeLinkNode(7);
        PopulatingNextRightPointersInEachNode.solutionRef(root);
        System.out.println(root.next);
        System.out.println(root.left.next.val);
        System.out.println(root.right.next);
        System.out.println(root.left.left.next.val);
        System.out.println(root.left.right.next.val);
        System.out.println(root.right.left.next.val);
        System.out.println(root.right.right.next);
    }

}
