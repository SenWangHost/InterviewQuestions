/**
 *
 */
package Tree;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".
 * What if the given tree could be any binary tree? Would your previous solution still work?
 * Note:
 * You may only use constant extra space.
 * For example,
 * Given the following binary tree,
 *           1
 *         /  \
 *        2    3
 *       / \    \
 *      4   5    7
 * After calling your function, the tree should look like:
 *             1 -> NULL
 *            /  \
 *           2 -> 3 -> NULL
 *          / \    \
 *         4-> 5 -> 7 -> NULL
 * @author SenWang
 */
public class PopulatingNextRIghtPointersInEachNodeTwo {
    /**
     * This is the iterative reference solution to this question, which
     * is based on the idea of level order traversal, but use the dummy head to
     * connect the node.
     * @param root the root node of this binary tree.
     */
    public static void solutionRef1(TreeLinkNode root) {
        TreeLinkNode dummy = new TreeLinkNode(0);
        while (root != null) {
            TreeLinkNode temp = dummy;
            while (root != null) {
                if (root.left != null) {
                    temp.next = root.left;
                    temp = temp.next;
                }
                if (root.right != null) {
                    temp.next = root.right;
                    temp = temp.next;
                }
                root = root.next;
            }
            root = dummy.next;
            // reset the dummy head's next node.
            dummy.next = null;
        }
    }
    /**
     * This is another reference iterative solution to this question, which
     * uses head variable to keep track of the head of a level in the tree.
     * Uses prev variable to connect the tree node in a level.
     * @param root the root node of this binary tree.
     */
    public static void solutionRef2(TreeLinkNode root) {
        TreeLinkNode head = null; // the head variable to keep track of the head of a level.
        TreeLinkNode prev = null; // the prev variable to keep track of previous node in a tree level.
        TreeLinkNode curr = root;
        while (curr != null) {
            // iterate on each level
            while (curr != null) {
                // if the left child exists.
                if (curr.left != null) {
                    if (prev != null) {
                        prev.next = curr.left;
                    } else {
                        // update the head variable
                        head = curr.left;
                    }
                    prev = curr.left;
                }
                // if the right child exists
                if (curr.right != null) {
                    if (prev != null) {
                        prev.next = curr.right;
                    } else {
                        head = curr.right;
                    }
                    prev = curr.right;
                }
                // iterate through the next reference
                curr = curr.next;
            }
            curr = head;
            // reset the head and prev variables
            head = null;
            prev = null;
        }
    }
    /**
     * This is the definition for the tree node class.
     * @author SenWang
     */
    private static class TreeLinkNode {
        /**
         * The field for storing the integer.
         */
        private int val;
        /**
         * The left reference to another tree node.
         */
        private TreeLinkNode left;
        /**
         * The right reference to another tree node.
         */
        private TreeLinkNode right;
        /**
         * The next reference to another tree node.
         */
        private TreeLinkNode next;
        /**
         * The constructor for the tree node
         * @param x the integer value to be stored into the tree node.
         */
        private TreeLinkNode(int x) {
            val = x;
            left = null;
            right = null;
            next = null;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        TreeLinkNode root = new TreeLinkNode(1);
        root.left = new TreeLinkNode(2);
        root.right = new TreeLinkNode(3);
        root.left.left = new TreeLinkNode(4);
        root.left.right = new TreeLinkNode(5);
        root.right.right = new TreeLinkNode(7);
        PopulatingNextRIghtPointersInEachNodeTwo.solutionRef1(root);
        System.out.println(root.left.next.val);
        System.out.println(root.left.left.next.val);
        System.out.println(root.left.right.next.val);
    }
}
