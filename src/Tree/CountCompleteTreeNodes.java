/**
 *
 */
package Tree;

/**
 * Given a complete binary tree, count the number of nodes.
 * Definition of a complete binary tree from Wikipedia:
 * In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last
 * level are as far left as possible. It can have between 1 and 2^h nodes inclusive at the last level h.
 * @author SenWang
 *
 */
public class CountCompleteTreeNodes {
    /**
     * This is one recursive solution to this question, which
     * seems likes an O(n) solution, but actually has vast improvement over
     * its efficiency.
     * @param root the root node of this tree.
     * @return the number of nodes in the tree.
     */
    public static int solutionRef(TreeNode root) {
        if (root == null) {
            return 0;
        }
        TreeNode leftNode = root;
        TreeNode rightNode = root;
        int height = 0;
        while (rightNode != null) {
            leftNode = leftNode.left;
            rightNode = rightNode.right;
            height++;
        }
        if (leftNode == null) {
            return (1 << height) - 1;
        }
        return 1 + solutionRef(root.left) + solutionRef(root.right);
    }
    /**
     * This is another reference solution to this question, which is based on
     * two steps:
     * (1) Firstly, we need to find the height of the binary tree and count the nodes above the last level.
     * (2) Then we should find a way to count the nodes on the last level.
     * Here I used a kind of binary search. We define the "midNode" of the last level as a node following
     * the path "root->left->right->right->...->last level".
     * If midNode is null, then it means we should count the nodes on the last level in the left subtree.
     * If midNode is not null, then we add half of the last level nodes to our result and then count the nodes on
     * the last level in the right subtree.
     * Of course I used some stop condition to make the code more efficient,
     * e.g. when a tree has height 1, it means it only has 3 cases: 1. has right son; 2. only has left son; 3. has no son.
     */
    public static int solutionRef2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.left == null) {
            return 1;
        }
        int height = 0;
        int nodesSum = 0;
        TreeNode curr = root;
        while(curr.left != null) {
            nodesSum += (1<<height);
            height++;
            curr = curr.left;
        }
        return nodesSum + countLastLevel(root, height);
    }
    /**
     * This is recursive helper function to this question, which counts
     * the number of nodes in the last level.
     * @param root the root node of this tree.
     * @param height the height of this tree.
     * @param the number of nodes in the last level of this tree.
     */
    private static int countLastLevel(TreeNode root, int height) {
        if (height == 1) {
            if (root.right != null) {
                return 2;
            } else if (root.left != null) {
                return 1;
            } else {
                return 0;
            }
        }
        TreeNode minNode = root.left;
        int currHeight = 1;
        while (currHeight < height) {
            currHeight++;
            minNode = minNode.right;
        }
        if (minNode == null) {
            return countLastLevel(root.left, height - 1);
        } else {
            // add half number of nodes in the last level and proceed to the right subtree.
            return 1 << (height - 1) + countLastLevel(root.right, height - 1);
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
        @SuppressWarnings("unused")
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
        root.left = new TreeNode(1);
        root.right = new TreeNode(1);
        root.left.left = new TreeNode(1);
        root.left.right = new TreeNode(1);
        int result = CountCompleteTreeNodes.solutionRef(root);
        System.out.println(result);
    }
}
