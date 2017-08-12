/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * You need to construct a string consists of parenthesis and integers from a binary tree with the preorder traversing way.
 * The null node needs to be represented by empty parenthesis pair "()".
 * And you need to omit all the empty parenthesis pairs that don't affect the one-to-one mapping relationship between
 * the string and the original binary tree.
 *
 * Example 1:
 * Input: Binary tree: [1,2,3,4]
 *     1
 *   /   \
 *  2     3
 * /
 * 4
 * Output: "1(2(4))(3)"
 * Explanation: Originallay it needs to be "1(2(4)())(3()())",
 * but you need to omit all the unnecessary empty parenthesis pairs.
 * And it will be "1(2(4))(3)".
 *
 * Example 2:
 * Input: Binary tree: [1,2,3,null,4]
 *     1
 *   /   \
 *  2     3
 *   \
 *    4
 * Output: "1(2()(4))(3)"
 * Explanation: Almost the same as the first example,
 * except we can't omit the first parenthesis pair to break the one-to-one mapping relationship between the input and
 * the output.
 * @author SenWang
 *
 */
public class ConstructStringFromBinaryTree {
    /**
     * This is my own solution to this question. This solution is aceptable
     * @param t the root of the tree node to be converted.
     * @return the string constructed from the tree data.
     */
    public static String solution(TreeNode t) {
        if (t == null) {
            return "";
        }
        if (t.left == null && t.right == null) {
            return Integer.toString(t.val);
        } else if (t.left == null && t.right != null) {
            StringBuilder result = new StringBuilder(Integer.toString(t.val));
            result.append("()");
            result.append("(");
            result.append(solution(t.right));
            result.append(")");
            return result.toString();
        } else if (t.left != null && t.right == null) {
            StringBuilder result = new StringBuilder(Integer.toString(t.val));
            result.append("(");
            result.append(solution(t.left));
            result.append(")");
            return result.toString();
        } else {
            StringBuilder result = new StringBuilder(Integer.toString(t.val));
            result.append("(");
            result.append(solution(t.left));
            result.append(")");
            result.append("(");
            result.append(solution(t.right));
            result.append(")");
            return result.toString();
        }
    }
    /**
     * This is the reference solution that use stack and hashset to
     * achieve the iterative method on the tree. there is a detailed animation
     * on this algorithm on leetcode.
     * @param t the root of the tree node to be converted.
     * @return the string constructed from the tree data.
     */
    public static String solutionRef(TreeNode t) {
        if (t == null) {
            return "";
        }
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        Set<TreeNode> visited = new HashSet<TreeNode>();
        stack.push(t);
        StringBuilder result = new StringBuilder("");
        while (!stack.isEmpty()) {
            TreeNode curr = stack.peek();
            if (visited.contains(curr)) {
                stack.pop();
                result.append(")");
            } else {
                visited.add(curr);
                result.append("(" + curr.val);
                if (curr.left == null && curr.right != null) {
                    result.append("()");
                }
                if (curr.right != null) {
                    stack.push(curr.right);
                }
                if (curr.left != null) {
                    stack.push(curr.left);
                }
            }
        }
        return result.toString().substring(1, result.length() - 1);
    }
    /**
     * This is the tree node class for constructing the tree.
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
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        // root.right = new TreeNode(3);
        root.left.right = new TreeNode(4);
        root.left.left = new TreeNode(3);
        String result = ConstructStringFromBinaryTree.solutionRef(root);
        System.out.println(result);
    }
}
