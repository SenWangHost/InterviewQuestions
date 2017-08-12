/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Given an array where elements are sorted in ascending order, convert it to a height balanced BST.
 * @author SenWang
 *
 */
public class ConvertSortedArrayToBST {
    /**
     * This is my own solution to this question. This is the accetable
     * recursive solution.
     * @param nums the sorted array of numbers to be converted.
     * @return the root node of the tree that is converted.
     */
    public static TreeNode solution(int[] nums) {
        if (nums.length == 0) {
            return null;
        }
        if (nums.length == 1) {
            return new TreeNode(nums[0]);
        }
        int mid = nums.length / 2;
        TreeNode root = new TreeNode(nums[mid]);
        int[] left = Arrays.copyOfRange(nums, 0, mid);
        int[] right = Arrays.copyOfRange(nums, mid + 1, nums.length);
        root.left = solution(left);
        root.right = solution(right);
        return root;
    }
    /**
     * This is the iterative solution to this question. It is very similar to doing a tree inorder traversal,
     * I use three stacks - nodeStack stores the node I am going to process next, and leftIndexStack and
     * rightIndexStack store the range where this node need to read from the nums.
     * @param nums the sorted array of numbers to be converted.
     * @return the root node of the tree that is converted.
     */
    public static TreeNode solution2(int[] nums) {
        int length = nums.length;
        if (length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(0);
        Deque<TreeNode> nodeStack = new ArrayDeque<TreeNode>();
        nodeStack.push(root);
        Deque<Integer> leftIndexStack = new ArrayDeque<Integer>();
        leftIndexStack.push(0);
        Deque<Integer> rightIndexStack = new ArrayDeque<Integer>();
        rightIndexStack.push(length - 1);
        while (!nodeStack.isEmpty()) {
            TreeNode curr = nodeStack.pop();
            int left = leftIndexStack.pop();
            int right = rightIndexStack.pop();
            int mid = left + (right - left) / 2;
            curr.val = nums[mid];
            if (left < mid) {
                curr.left = new TreeNode(0);
                nodeStack.push(curr.left);
                leftIndexStack.push(left);
                rightIndexStack.push(mid - 1);
            }
            if (right >= mid + 1) {
                curr.right = new TreeNode(0);
                nodeStack.push(curr.right);
                leftIndexStack.push(mid + 1);
                rightIndexStack.push(right);
            }
        }
        return root;
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
        int[] nums = {0, 1, 2, 3, 4, 5};
        TreeNode result = ConvertSortedArrayToBST.solution2(nums);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.left.right.val);
        System.out.println(result.right.val);
        System.out.println(result.right.left.val);
        System.out.println(result.right.right.val);
    }
}
