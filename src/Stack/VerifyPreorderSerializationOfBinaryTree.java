/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * One way to serialize a binary tree is to use pre-order traversal. When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #.
 *          _9_
 *         /   \
 *        3     2
 *       / \   / \
 *      4   1  #  6
 *     / \ / \   / \
 *    # # # #   # #
 * For example, the above binary tree can be serialized to the string "9,3,4,#,#,1,#,#,2,#,6,#,#",
 * where # represents a null node.
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 * Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 *
 * Example 1:
 * "9,3,4,#,#,1,#,#,2,#,6,#,#"
 * Return true
 *
 * Example 2:
 * "1,#"
 * Return false
 *
 * Example 3:
 * "9,#,#,1"
 * Return false
 * @author SenWang
 *
 */
public class VerifyPreorderSerializationOfBinaryTree {
    /**
     * this is the reference solution to this question, which makes use of concepts of indegree and outdegree
     * of a tree node.
     */
    public static boolean solution(String preorder) {
        if (preorder == null) {
            return false;
        }
        String[] array = preorder.split(",");
        int degree = -1;
        for (String str : array) {
            degree++;
            if (degree > 0) {
                return false;
            }
            if (!str.equals("#")) {
                degree -= 2;
            }
        }
        return degree == 0;
    }
    /**
     * this is another solution to this question.
     */
    public static boolean solution2(String preorder) {
        if (preorder == null || preorder.length() == 0) {
            return false;
        }
        String[] array = preorder.split(",");
        Deque<String> stack = new ArrayDeque<>();
        for (String str : array) {
            while (str.equals("#") && !stack.isEmpty() && stack.peek().equals("#")) {
                stack.pop();
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
            stack.push(str);
        }
        return stack.size() == 1 && stack.peek().equals("#");
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
