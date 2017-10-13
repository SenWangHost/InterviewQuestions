/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given an array of numbers, verify whether it is the correct preorder traversal sequence of a binary search tree.
 * You may assume each number in the sequence is unique.
 * Follow up:
 * Could you do it using only constant space complexity?
 * @author SenWang
 *
 */
public class VerifyPreorderSequenceInBST {
    /**
     * this is my own solution to this question. However, this is a slow solution.
     */
    public static boolean solution(int[] preorder) {
        if (preorder == null || preorder.length == 0) {
            return true;
        }
        return helper(preorder, 0, preorder.length - 1);
    }
    /**
     * this is the helper function
     */
    private static boolean helper(int[] preorder, int start, int end) {
        if (start >= end) {
            return true;
        }
        int root = preorder[start];
        int right = -1;
        for (int i = start + 1; i <= end; i++) {
            if (right == -1 && preorder[i] > root) {
                right = i;
            }
            if (right != -1 && preorder[i] < root) {
                return false;
            }
        }
        if (right == -1) {
            return helper(preorder, start + 1, end);
        } else {
            return helper(preorder, start + 1, right - 1) && helper(preorder, right, end);
        }
    }
    /**
     * this is the reference solution to this question.
     */
    public static boolean solutionRef(int[] preorder) {
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int low = Integer.MIN_VALUE;
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            // in the left subtree
            while (!stack.isEmpty() && num > stack.peek()) {
                low = stack.pop();
            }
            stack.push(num);
        }
        return true;
    }
    /**
     * this is another reference solution to this question.
     */
    public static boolean solutionRef2(int[] preorder) {
        int low = Integer.MIN_VALUE;
        int index = -1;
        for (int num : preorder) {
            if (num < low) {
                return false;
            }
            while (index != -1 && num > preorder[index]) {
                low = preorder[index];
                index--;
            }
            index++;
            preorder[index] = num;
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2,1};
        System.out.println(solutionRef(test));
    }

}
