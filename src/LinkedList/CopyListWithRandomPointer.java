/**
 *
 */
package LinkedList;

import java.util.HashMap;
import java.util.Map;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to
 * any node in the list or null.
 * Return a deep copy of the list.
 * @author SenWang
 *
 */
public class CopyListWithRandomPointer {
    /**
     * This is my own solution to this question.
     * @param head the head to linked list to be copied.
     * @return a deep copy of the linked list.
     */
    public static RandomListNode solutionRef(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> map = new HashMap<RandomListNode, RandomListNode>();
        RandomListNode temp = head;
        while (temp != null) {
            map.put(temp, new RandomListNode(temp.label));
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            map.get(temp).next = map.get(temp.next);
            map.get(temp).random = map.get(temp.random);
            temp = temp.next;
        }
        return map.get(head);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * this is definition for random list node.
     * @author SenWang
     */
    private static class RandomListNode {
        /**
         * The field for storing integer.
         */
        private int label;
        /**
         * The reference pointer to the next node.
         */
        private RandomListNode next;
        /**
         * The random reference pointer to any other node in the list or null.
         */
        private RandomListNode random;
        /**
         * The constructor for the random list node.
         * @param x the value to be stored in the node.
         */
        private RandomListNode(int x) {
            label = x;
        }
    }

}
