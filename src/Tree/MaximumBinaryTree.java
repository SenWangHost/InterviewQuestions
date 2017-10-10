/**
 *
 */
package Tree;

/**
 * Given an integer array with no duplicates. A maximum tree building on this array is defined as follow:
 * The root is the maximum number in the array.
 * The left subtree is the maximum tree constructed from left part subarray divided by the maximum number.
 * The right subtree is the maximum tree constructed from right part subarray divided by the maximum number.
 * Construct the maximum tree by the given array and output the root node of this tree.
 * Example 1:
 * Input: [3,2,1,6,0,5]
 * Output: return the tree root node representing the following tree:
 *       6
 *     /   \
 *    3     5
 *     \    /
 *      2  0
 *       \
 *        1
 * Note:
 * The size of the given array will be in the range [1,1000].
 * @author SenWang
 *
 */
public class MaximumBinaryTree {
    /**
     * this is my own solution to this question.
     */
    public static TreeNode solution(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper(null, nums);
    }
    /**
     * the helper function
     */
    private static TreeNode helper(TreeNode node, int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int middle = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                middle = i;
            }
        }
        node = new TreeNode(max);
        int[] left = new int[middle];
        int[] right = new int[nums.length - middle - 1];
        System.arraycopy(nums, 0, left, 0, left.length);
        System.arraycopy(nums, middle + 1, right, 0, right.length);
//        System.out.println(Arrays.toString(left));
//        System.out.println(Arrays.toString(right));
        node.left = helper(node.left, left);
        node.right = helper(node.right, right);
        return node;
    }
    /**
     * this is my another solution to this question, try to erase the array copy part.
     */
    public static TreeNode solution2(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }
        return helper2(null, nums, 0, nums.length - 1);
    }
    /**
     * this is the helper function
     */
    private static TreeNode helper2(TreeNode node, int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = Integer.MIN_VALUE;
        int middle = 0;
        for(int i = start; i <= end; i++) {
            if (nums[i] >= max) {
                max = nums[i];
                middle = i;
            }
        }
        node = new TreeNode(max);
        node.left = helper2(node.left, nums, start, middle - 1);
        node.right = helper2(node.right, nums, middle + 1, end);
        return node;
    }
    /**
     * the reference solution uses the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {3, 2, 1, 6, 0, 5};
        TreeNode root = solution2(nums);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.left.right.right.val);
        System.out.println(root.right.val);
        System.out.println(root.right.left.val);
        System.out.println(root.right.right);
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
