/**
 *
 */
package LinkedList;

/**
 * Design a Phone Directory which supports the following operations:
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 * Example:
 * // Init a phone directory containing a total of 3 numbers: 0, 1, and 2.
 * PhoneDirectory directory = new PhoneDirectory(3);
 * // It can return any available phone number. Here we assume it returns 0.
 * directory.get();
 * // Assume it returns 1.
 * directory.get();
 * // The number 2 is available, so return true.
 * directory.check(2);
 * // It returns 2, the only number that is left.
 * directory.get();
 * // The number 2 is no longer available, so return false.
 * directory.check(2);
 * // Release number 2 back to the pool.
 * directory.release(2);
 * // Number 2 is available again, return true.
 * directory.check(2);
 * @author SenWang
 *
 */
public class DesignPhoneDirectory {
    /**
     * this is my own solution to this quetion.
     */
    public static class PhoneDirectory {
        /**
         * the point for curr node
         */
        private PhoneNumber curr;
        /**
         * the constructor for this class
         */
        public PhoneDirectory(int n) {
            PhoneNumber head = new PhoneNumber(0);
            PhoneNumber node = head;
            for (int i = 1; i < n; i++) {
                node.next = new PhoneNumber(i);
                node = node.next;
            }
            curr = head;
        }
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
    private static class PhoneNumber {
        /**
         * The field of value for the node.
         */
        @SuppressWarnings("unused")
        private int val;
        private boolean used;
        /**
         * The reference to the next node.
         */
        private PhoneNumber next;
        /**
         * The constructor for the node.
         * @param x the value to be stored in the node.
         */
        private PhoneNumber(int x) {
            val = x;
            next = null;
            used = false;
        }
    }
}
