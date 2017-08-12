/**
 *
 */
package Array;

/**
 * Given a non-negative integer represented as a non-empty array of digits, plus one to the integer.
 * You may assume the integer do not contain any leading zero, except the number 0 itself.
 * The digits are stored such that the most significant digit is at the head of the list.
 *
 * @author SenWang
 *
 */
public class PlusOne {
    /**
     * This is my own solution for this question. This solution is acceptable and runtime complexity is O(n);
     * @param digits the array of digits representing the number.
     * @return the array of digits after adding one.
     */
    public static int[] solution(int[] digits) {
        int size = digits.length;
        if (digits[size - 1] + 1 < 10) {
            digits[size - 1] += 1;
            return digits;
        }
        digits[size - 1] = 0;
        for (int i = size - 2; i >= 0; i--) {
            if (digits[i] != 9) {
                digits[i] += 1;
                return digits;
            } else {
                digits[i] = 0;
            }
        }
        int[] result = new int[size + 1];
        result[0] = 1;
        return result;
    }
    /**
     * The reference solution is the same as my own solution, so they are not provided any more.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {9, 9};
        int[] result = PlusOne.solution(test);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
