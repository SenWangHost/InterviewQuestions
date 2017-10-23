/**
 *
 */
package Tree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * You are given an integer array nums and you have to return a new counts array.
 * The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].
 * Example:
 * Given nums = [5, 2, 6, 1]
 * To the right of 5 there are 2 smaller elements (2 and 1).
 * To the right of 2 there is only 1 smaller element (1).
 * To the right of 6 there is 1 smaller element (1).
 * To the right of 1 there is 0 smaller element.
 * Return the array [2, 1, 1, 0].
 * @author SenWang
 *
 */
public class CountOfSmallerNumbersAfterItself {
    /**
     * this is one of the reference solution to this question, whcih maintain s sorted array
     * and use binary search to find the inserted index.
     */
    public static List<Integer> solution(int[] nums) {
        Integer[] result = new Integer[nums.length];
        List<Integer> sorted = new ArrayList<Integer>();
        for (int i = nums.length - 1; i >= 0; i--) {
            int index = findIndex(sorted, nums[i]);
            result[i] = index;
            sorted.add(index, nums[i]);
        }
        return Arrays.asList(result);
    }
    /**
     * the helper function for finding the index to insert in the sorted array
     */
    private static int findIndex(List<Integer> sorted, int target) {
        if (sorted.size() == 0) {
            return 0;
        }
        int n = sorted.size();
        if (sorted.get(n - 1) <= target) {
            return n;
        }
        if (sorted.get(0) >= target) {
            return 0;
        }
        int start = 0;
        int end = n - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (sorted.get(mid) < target) {
                start = mid + 1;
            } else {
                end = mid;
            }
        }
        if (sorted.get(start) >= target) return start;
        return end;
    }
    /**
     * this is another reference solution to this question, which uses binary tree insertion.
     */
    public static List<Integer> solutionRef(int[] nums) {
        Integer[] result = new Integer[nums.length];
        if (nums == null || nums.length == 0) {
            return Arrays.asList(result);
        }
        TreeNode root = null;
        for (int i = nums.length - 1; i >= 0; i--) {
            root = insert(root, nums[i], result, i, 0);
        }
        return Arrays.asList(result);
    }
    /**
     * the helper function to insert as the binary search tree and also count the smaller value.
     */
    private static TreeNode insert(TreeNode root, int val, Integer[] result, int index, int preSum) {
        if (root == null) {
            root = new TreeNode(val, 0);
            result[index] = preSum;
        } else if (root.val > val) {
            root.smaller++;
            root.left = insert(root.left, val, result, index, preSum);
        } else {
            root.right = insert(root.right, val, result, index, root.smaller + preSum + (root.val < val ? 1 : 0));
        }
        return root;
    }
    /**
     * the definition for tree node
     */
    private static class TreeNode {
        /**
         * field for value
         */
        private int val;
        /**
         * field for smaller count
         */
        private int smaller;
        /**
         * the reference to the left node
         */
        private TreeNode left;
        /**
         * the reference to the right node
         */
        private TreeNode right;
        /**
         * the constructor for tree node
         */
        private TreeNode(int val, int smaller) {
            this.val = val;
            this.smaller = smaller;
            left = null;
            right = null;
        }
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {5, 2, 6, 1};
        List<Integer> result = solution(nums);
        System.out.println(result);
    }

}
