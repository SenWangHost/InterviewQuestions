/**
 * This package mainly contains the interview questions mainly related
 * with linked list.
 */
package LinkedList;

/**
 * You are given two non-empty linked lists representing two non-negative integers.
 * The digits are stored in reverse order and each of their nodes contain a single digit.
 * Add the two numbers and return it as a linked list.
 * You may assume the two numbers do not contain any leading zero, except the number 0 itself.
 *
 * Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
 * Output: 7 -> 0 -> 8
 * @author SenWang
 *
 */
public class AddTwoNumbers {
    /**
     * The helper function to transform a linked list to numbers
     * @param l the linked list to be transformed.
     * @return the digit the linked list represent.
     */
    private double listToNum(ListNode l) {
        double digit = 1;
        double result = 0;
        while (l != null) {
            result += l.val * digit;
            l = l.next;
            digit *= 10;
        }
        return result;
    }
    /**
     * The helper function to transform a num into a linked list.
     * @param num the number to be transferred into.
     * @return the list node the number to be represented.
     */
    private ListNode numToList(double num) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        while (num >= 1) {
            temp.val = (int) num % 10;
            num = num / 10;
            temp.next = new ListNode(0);
            temp = temp.next;
        }
        return result;
    }
    /**
     * The solution to add two numbers.
     * @param l1 the first linked list to use.
     * @param l2 the second linked list to use.
     * @return the linked list that represents the sum.
     */
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        double num1 = listToNum(l1);
        double num2 = listToNum(l2);
        System.out.println(num1);
        System.out.println(num2);
        System.out.println(num1 + num2);
        ListNode result = numToList(num1 + num2);
        return result;
    }
    /**
     *
     */
    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        int incre = 0;
        while (l1 != null || l2 != null) {
            if (l1 != null && l2 != null) {
               if (l1.val + l2.val + incre <= 9) {
                   temp.val = l1.val + l2.val + incre;
                   incre = 0;
               } else {
                   temp.val = l1.val + l2.val + incre - 10;
                   incre = 1;
               }
               l1 = l1.next;
               l2 = l2.next;
            } else if (l1 != null) {
                if (l1.val + incre <= 9) {
                    temp.val = l1.val + incre;
                    incre = 0;
                } else {
                    temp.val = l1.val + incre - 10;
                    incre = 1;
                }
                l1 = l1.next;
            } else if (l2 != null) {
                if (l2.val + incre <= 9) {
                    temp.val = l2.val + incre;
                    incre = 0;
                } else {
                    temp.val = l2.val + incre - 10;
                    incre = 1;
                }
                l2 = l2.next;
            }
            if (l1 != null || l2 != null || incre == 1) {
                temp.next = new ListNode(incre);
                temp = temp.next;
            }
        }
        return result;
    }
    /**
     * This is the reference solution for this problem.
     */
    public ListNode addTwoNumbersRef(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode curr = result;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = (l1 != null) ? l1.val : 0;
            int y = (l2 != null) ? l2.val : 0;
            int sum = x + y + carry;
            carry = sum / 10;
            curr.val = sum % 10;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
            if (l1 != null || l2 != null || carry == 1) {
                curr.next = new ListNode(carry);
                curr = curr.next;
            }
        }
        return result;
    }
    /**
     * The node for the linked list.
     * @author SenWang
     */
    public class ListNode {
        /**
         * The value field for the list node.
         */
        private int val;
        /**
         * The next reference field for the list node.
         */
        private ListNode next;
        /**
         * The constructor for the ListNode.
         * @param x
         */
        public ListNode(int x) {
            val = x;
            next = null;
        }
    }
    /**
     * The helper function to transform a array of integers into linked list.
     * @param arr the array to be transformed.
     * @return the linked list representing the array.
     */
    public ListNode arrayToList(int[] arr) {
        ListNode result = new ListNode(0);
        ListNode temp = result;
        for (int i = 0; i < arr.length; i++) {
            temp.val = arr[i];
            if (i != arr.length - 1) {
                temp.next = new ListNode(0);
                temp = temp.next;
            }
        }
        return result;
    }
    /**
     * The several test cases for add two numbers solution
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        AddTwoNumbers test = new AddTwoNumbers();
        // test case 1
        int[] arr1 = {9};
        ListNode l1 = test.arrayToList(arr1);
        int[] arr2 = {1, 9, 9};
        ListNode l2 = test.arrayToList(arr2);
        ListNode sum = test.addTwoNumbersRef(l1, l2);
        // print out the result.
        while (sum != null) {
            System.out.println(sum.val);
            sum = sum.next;
        }
    }

}
