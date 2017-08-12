/**
 *
 */
package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Write a program to find the node at which the intersection of two singly linked lists begins.
 * For example, the following two linked lists:
 * A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗
   B:     b1 → b2 → b3

 * begin to intersect at node c1.
 * Notes:
 * If the two linked lists have no intersection at all, return null.
 * The linked lists must retain their original structure after the function returns.
 * You may assume there are no cycles anywhere in the entire linked structure.
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * @author SenWang
 *
 */
public class IntersectionTwoLinkedLists {
    /**
     * The is my own solution to this question.
     * @param headA the head of linked list a.
     * @param headB the head of linked list b.
     * @return the intersection node of the two linked lists.
     */
    public static ListNode solution(ListNode headA, ListNode headB) {
        ListNode tempA = headA;
        ListNode tempB = headB;
        Set<ListNode> set = new HashSet<ListNode>();
        while (tempA != null) {
            set.add(tempA);
            tempA = tempA.next;
        }
        while (tempB != null) {
            if (set.contains(tempB)) {
                return tempB;
            }
            tempB = tempB.next;
        }
        return null;
    }
    /**
     * This is one reference solution that calculates the difference of length
     * and move the pointer at the same pace.
     * @param headA the head of linked list a.
     * @param headB the head of linked list b.
     * @return the intersection node of the two linked lists.
     */
    public static ListNode solutionRef(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        int lenA = length(headA);
        int lenB = length(headB);
        ListNode currA = headA;
        ListNode currB = headB;
        while (lenA > lenB) {
            currA = currA.next;
            lenA--;
        }
        while (lenB > lenA) {
            currB = currB.next;
        }
        while (currA != currB) {
            currA = currA.next;
            currB = currB.next;
        }
        return currA;
    }
    /**
     * This is the helper function to get the length of the linked list.
     * @param head the head of list to be considered.
     * @return the length of the linked list.
     */
    private static int length(ListNode head) {
        int length = 0;
        while (head != null) {
            length++;
            head = head.next;
        }
        return length;
    }
    /**
     * This is another reference solution without calculaing the difference of length.
     * The idea is like the following, which is pretty good:
     * I found most solutions here preprocess linkedlists to get the difference in len.
     * Actually we don't care about the "value" of difference, we just want to make sure two pointers reach the
     * intersection node at the same time.We can use two iterations to do that. In the first iteration, we will reset
     * the pointer of one linkedlist to the head of another linkedlist after it reaches the tail node.
     * In the second iteration, we will move two pointers until they
     * points to the same node. Our operations in first iteration will help us counteract the difference.
     * So if two linkedlist intersects, the meeting point in second iteration must be the intersection point.
     * If the two linked lists have no intersection at all, then the meeting pointer in second iteration must be
     * the tail node of both lists, which is null.
     * @param headA the head of linked list a.
     * @param headB the head of linked list b.
     * @return the intersection node of the two linked lists.
     */
    public static ListNode solutionRef2(ListNode headA, ListNode headB) {
        if (headA == null || headB == null) {
            return null;
        }
        ListNode currA = headA;
        ListNode currB = headB;
        //if a & b have different len, then we will stop the loop after second iteration
        while (currA != currB) {
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            if (currA == null) {
                currA = headB;
            } else {
                currA = currA.next;
            }
            if (currB == null) {
                currB = headA;
            } else {
                currB = currB.next;
            }
        }
        return currA;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * This is the definition for the node in singly linked list.
     * @author SenWang
     */
    private static class ListNode {
        /**
         * The field of value for the node.
         */
        @SuppressWarnings("unused")
        private int val;
        /**
         * The reference to the next node.
         */
        private ListNode next;
        /**
         * The constructor for the node.
         * @param x the value to be stored in the node.
         */
        private ListNode(int x) {
            val = x;
            next = null;
        }
    }
}
