/**
 *
 */
package Math;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * Some hints:
 * Could negative integers be palindromes? (ie, -1)
 * If you are thinking of converting the integer to string, note the restriction of using extra space.
 * You could also try reversing an integer. However, if you have solved the problem "Reverse Integer",
 * you know that the reversed integer might overflow. How would you handle such case?
 * There is a more generic way of solving this problem.
 * @author SenWang
 *
 */
public class PalindromeNumber {
    /**
     * This is my own solution to this question.
     * @param x the number to be checked.
     * @return true if it is a palindrome, false otherwise.
     */
    public static boolean solution(int x) {
        if (x < 0) {
            return false;
        }
        int len = 0;
        int temp = x;
        while (temp > 0) {
            len++;
            temp /= 10;
        }
        if (len == 1) {
            return true;
        }
        for (int i = 0; i < len / 2; i++) {
            int digitRight = (x / powerOfTen(i)) % 10;
            int digitLeft = (x / powerOfTen(len - 1 - i)) % 10;
            if (digitRight != digitLeft) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is my another solution to this question, which converts the integer
     * to the string.
     * @param x the number to be checked.
     * @return true if it is a palindrome, false otherwise.
     */
    public static boolean solution2(int x) {
        if (x < 0) {
            return false;
        }
        String normal = "";
        String reverse = "";
        while (x > 0) {
            int digit = x % 10;
            normal = digit + normal;
            reverse = reverse + digit;
            x /= 10;
        }
        return normal.equals(reverse);
    }
    /**
     * This is one reference solution to this question, which only compares half part of a
     * number
     * @param x the number to be checked.
     * @return true if it is a palindrome, false otherwise
     */
    public static boolean solutionRef(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev) || (x == rev / 10);
    }
    /**
     * This is the helper function to calculate the power of 10.
     * @param index the exponent to be input
     * @return the result of power of ten
     */
    private static int powerOfTen(int index) {
        int result = 1;
        for (int i = 0; i < index; i++) {
            result = result * 10;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 1222;
        boolean result = PalindromeNumber.solution2(x);
        System.out.println(result);
    }

}
