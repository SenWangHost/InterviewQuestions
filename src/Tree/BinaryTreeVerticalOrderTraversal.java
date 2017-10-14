/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values. (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 * Examples:
 * Given binary tree [3,9,20,null,null,15,7],
   3
  /\
 /  \
 9  20
    /\
   /  \
  15   7
return its vertical order traversal as:
[
  [9],
  [3,15],
  [20],
  [7]
]
Given binary tree [3,9,8,4,0,1,7],
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
return its vertical order traversal as:
[
  [4],
  [9],
  [3,0,1],
  [8],
  [7]
]
Given binary tree [3,9,8,4,0,1,7,null,null,null,2,5] (0's right child is 2 and 1's left child is 5),
     3
    /\
   /  \
   9   8
  /\  /\
 /  \/  \
 4  01   7
    /\
   /  \
   5   2
return its vertical order traversal as:
[
  [4],
  [9,5],
  [3,0,1],
  [8,2],
  [7]
]
 * @author SenWang
 *
 */
public class BinaryTreeVerticalOrderTraversal {
    /**
     * this is my own solution to this question.
     */
    public static List<List<Integer>> solution(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        Deque<TreeNode> nodeQueue = new ArrayDeque<TreeNode>();
        Deque<Integer> indexQueue = new ArrayDeque<Integer>();
        nodeQueue.offer(root);
        indexQueue.offer(0);
        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        while (!nodeQueue.isEmpty()) {
            int size = nodeQueue.size();
            while (size > 0) {
                TreeNode curr = nodeQueue.poll();
                size--;
                int index = indexQueue.poll();
                if (map.get(index) == null) {
                    map.put(index, new ArrayList<Integer>());
                }
                map.get(index).add(curr.val);
                min = Math.min(min, index);
                max = Math.max(max, index);
                if (curr.left != null) {
                    nodeQueue.offer(curr.left);
                    indexQueue.offer(index - 1);
                }
                if (curr.right != null) {
                    nodeQueue.offer(curr.right);
                    indexQueue.offer(index + 1);
                }
            }

        }
        for (int i = min; i <= max; i++) {
            result.add(map.get(i));
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeNode root = new TreeNode(3);
        root.left = new TreeNode(9);
        root.right = new TreeNode(8);
        root.right.left = new TreeNode(1);
        root.right.right = new TreeNode(7);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(0);
        List<List<Integer>> result = solution(root);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
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
