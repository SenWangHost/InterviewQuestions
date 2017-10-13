/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * You need to construct a binary tree from a string consisting of parenthesis and integers.
 * The whole input represents a binary tree. It contains an integer followed by zero, one or two pairs of
 * parenthesis. The integer represents the root's value and a pair of parenthesis contains
 * a child binary tree with the same structure.
 * You always start to construct the left child node of the parent first if it exists.
 *
 * Example:
 * Input: "4(2(3)(1))(6(5))"
 * Output: return the tree root node representing the following tree:
 *          4
 *        /   \
 *       2     6
 *      / \   /
 *     3   1 5
 * Note:
 * There will only be '(', ')', '-' and '0' ~ '9' in the input string.
 * An empty tree is represented by "" instead of "()".
 * @author SenWang
 *
 */
public class ConstructBinaryTreeFromString {
    /**
     * this is my own solution to this question, this solution is fast but complicated.
     */
    public static TreeNode solution(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        s = "(" + s + ")";
        TreeNode root = null;
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        int index = 0;
        while (index < s.length()) {
            char c = s.charAt(index);
            if (c == '(') {
                index++;
                StringBuilder temp = new StringBuilder("");
                while (index < s.length() && (s.charAt(index) != '(' && s.charAt(index) != ')')) {
                    temp.append(s.charAt(index));
                    index++;
                }
                // System.out.println(temp.toString());
                int val = Integer.parseInt(temp.toString());
                TreeNode newNode = new TreeNode(val);
                if (stack.isEmpty()) {
                    root = newNode;
                    stack.push(root);
                } else {
                    TreeNode parent = stack.peek();
                    if (parent.left == null) {
                        parent.left = newNode;
                    } else {
                        parent.right = newNode;
                    }
                    stack.push(newNode);
                }
            } else if (c == ')') {
                stack.pop();
                index++;
            }
        }
        return root;

    }
    /**
     * this is reference recursive solution
     */
    public static TreeNode solutionRef(String s) {
        if (s == null || s.length() == 0) {
            return null;
        }
        // index for left parenthesis and right parenthesis
        int leftP = 0;
        int rightP = 0;
        while (rightP < s.length() && (Character.isDigit(s.charAt(rightP)) || s.charAt(rightP) == '-')) {
            rightP++;
        }
        TreeNode root = new TreeNode(Integer.parseInt(s.substring(leftP, rightP)));

        // recursive construct the left child
        if (rightP < s.length()) {
            leftP = rightP;
            int count = 1;
            while (rightP + 1 < s.length() && count != 0) {
                rightP++;
                if (s.charAt(rightP) == ')') {
                    count--;
                }
                if (s.charAt(rightP) == '(') {
                    count++;
                }
            }
            root.left = solutionRef(s.substring(leftP + 1, rightP));
        }
        // take care of right child
        if (rightP < s.length()) {
            root.right = solutionRef(s.substring(rightP + 1, s.length() - 1));
        }
        return root;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "4(2(3)(1))(6(5))";
        TreeNode root = solution(test);
        System.out.println(root.val);
        System.out.println(root.left.val);
        System.out.println(root.right.val);
        System.out.println(root.left.left.val);
        System.out.println(root.left.right.val);
        System.out.println(root.right.left.val);
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
