/**
 *
 */
package Tree;


/**
 * Given a root node reference of a BST and a key, delete the node with the given key in the BST.
 * Return the root node reference (possibly updated) of the BST.
 *
 * Basically, the deletion can be divided into two stages:
 * Search for a node to remove.
 * If the node is found, delete the node.
 * Note: Time complexity should be O(height of tree).
 *
 * Example:
 * root = [5,3,6,2,4,null,7]
 * key = 3
 *     5
 *    / \
 *   3   6
 *  / \   \
 * 2   4   7
 * Given key to delete is 3. So we find the node with value 3 and delete it.
 * One valid answer is [5,4,6,2,null,null,7], shown in the following BST.
 *
 *   5
 *  / \
 * 4   6
 * /     \
 * 2       7
 * Another valid answer is [5,2,6,null,4,null,7].
 *    5
 *   / \
 *   2   6
 *    \   \
 *     4   7
 * @author SenWang
 *
 */
public class DeleteNodeInBST {
    /**
     * This is my own solution to this question.
     * @param root the root of the tree
     * @param key the integer key for searching the deleted node
     * @return the root of the tree after deletion.
     */
    public static TreeNode solution(TreeNode root, int key) {
        if (root == null) {
            return root;
        }
        // search for the node to be deleted.
        TreeNode prev = root;
        TreeNode curr = root;
        boolean isLeftChild = true;
        while (curr != null && curr.val != key) {
            prev = curr;
            if (key < curr.val) {
                curr = curr.left;
                isLeftChild = true;
            } else {
                curr = curr.right;
                isLeftChild = false;
            }
        }
        // the key is not in the tree, do nothing and return
        // the original tree.
        if (curr == null) {
            return root;
        }
        // if the node to be deleted is a leaf
        if (curr.left == null && curr.right == null) {
            if (curr == root) {
                root = null;
                return root;
            } else {
                if (isLeftChild) {
                    prev.left = null;
                } else {
                    prev.right = null;
                }
                return root;
            }
        }
        // if the node to be deleted has one left child
        else if (curr.left != null && curr.right == null) {
            if (curr == root) {
                root = curr.left;
                return root;
            } else {
                if (isLeftChild) {
                    prev.left = curr.left;
                } else {
                    prev.right = curr.left;
                }
                return root;
            }
        }
        // if the node to be deleted has one right child
        else if (curr.left == null && curr.right != null) {
            if (curr == root) {
                root = curr.right;
                return root;
            } else {
                if (isLeftChild) {
                    prev.left = curr.right;
                } else {
                    prev.right = curr.right;
                }
                return root;
            }
        }
        // if the node to be deleted has two children.
        // find the successor and replace the node to be deleted
        // with the successor.
        else {
            TreeNode successor = getSuccessor(curr);
            if (curr == root) {
                root = successor;
            } else {
                if (isLeftChild) {
                    prev.left = successor;
                } else {
                    prev.right = successor;
                }
            }
            successor.left = curr.left;
            return root;
        }
    }
    /**
     * This is the helper function to get the successor of a certain
     * node
     * @param node the tree node to be deleted.
     * @return the successor node.
     */
    private static TreeNode getSuccessor(TreeNode node) {
        TreeNode sp = node;
        TreeNode s = node;
        TreeNode curr = node.right;
        while (curr != null) {
            sp = s;
            s = curr;
            curr = curr.left;
        }
        if (s != node.right) {
            sp.left = s.right;
            s.right = node.right;
        }
        return s;
    }
    /**
     * This is the recursive solution to this question.
     * Steps:
     * Recursively find the node that has the same value as the key, while setting the left/right nodes equal to
     * the returned subtree
     *
     * Once the node is found, have to handle the below 4 cases:
     * 1. node doesn't have left or right - return null
     * 2. node only has left subtree- return the left subtree
     * 3. node only has right subtree- return the right subtree
     * 4. node has both left and right - find the minimum value in the right subtree, set that value to the
     * currently found node, then recursively delete the minimum value in the right subtree
     * @param root the root of the tree
     * @param key the integer key for searching the deleted node
     * @return the root of the tree after deletion.
     */
    public static TreeNode solutionRef(TreeNode root, int key) {
        if (root == null) {
            return null;
        }
        if (key < root.val) {
            root.left = solutionRef(root.left, key);
        } else if (key > root.val) {
            root.right = solutionRef(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            TreeNode minNode = findMin(root.right);
            root.val = minNode.val;
            root.right = solutionRef(root.right, root.val);
        }
        return root;
    }
    /**
     * This is the helper function to find the min node in
     * a tree.
     * @param node the root node of the tree
     * @return the min node in the tree
     */
    private static TreeNode findMin(TreeNode node) {
        while (node.left != null) {
            node = node.left;
        }
        return node;
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
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(3);
        root.right = new TreeNode(6);
        root.left.left = new TreeNode(2);
        root.left.right = new TreeNode(4);
        root.right.right = new TreeNode(7);
        TreeNode result = DeleteNodeInBST.solutionRef(root, 3);
        System.out.println(result.val);
        System.out.println(result.left.val);
        System.out.println(result.right.val);
        System.out.println(result.left.left.val);
        System.out.println(result.right.right.val);

    }
}
