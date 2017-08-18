/**
 *
 */
package BitManipulation;

/**
 * Given an integer (signed 32 bits), write a function to check whether it is a power of 4.
 * Example:
 * Given num = 16, return true. Given num = 5, return false.
 * Follow up: Could you solve it without loops/recursion?
 * @author SenWang
 *
 */
public class IsPowerOfFour {
    /**
     * This is the bit manipulation solution for this question.
     * @param num the input number to be considered.
     * @return true if the input number is a power of four, false otherwise.
     */
    public static boolean solution(int num) {
        // num & (num - 1) == 0 drop the least significant 1 bit, in this case
        // is to make sure there is one 1 bit in the bit representation.

        // num & (0x55555555) == num is to make sure the one-bit position occurs
        // at the odd position.
        return num > 0 && (num & (num - 1)) == 0 && (num & 0x55555555) == num;
    }
    /**
     * This is the mathematical solution to this question.
     * @param num the input number to be considered.
     * @return true if the input number is a power of four, false otherwise.
     */
    public static boolean solution2(int num) {
        if (num <= 0) {
            return false;
        }
        while (num > 1) {
            if (num % 4 != 0) {
                return false;
            }
            num /= 4;
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 16;
        System.out.println(solution2(test));
    }

}
