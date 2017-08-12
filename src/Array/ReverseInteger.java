/**
 *
 */
package Array;

/**
 * Reverse digits of an integer.
 * Example1: x = 123, return 321
 * Example2: x = -123, return -321
 *
 * Have you thought about this?
 * Here are some good questions to ask before coding. Bonus points for you if you have already thought through this!
 * If the integer's last digit is 0, what should the output be? ie, cases such as 10, 100.
 * Did you notice that the reversed integer might overflow? Assume the input is a 32-bit integer, then the reverse of 1000000003 overflows.
 * How should you handle such cases?
 * For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 * @author SenWang
 *
 */
public class ReverseInteger {
    /**
     * This is my own solution for this question. This solution is acceptable and the runtime
     * complexity is efficient.
     * @param x the integer to be reversed.
     * @return the reversed digit of the integer
     */
    public static int solution(int x) {
        boolean neg = false;
        if (x < 0) {
            neg = true;
            x = -x;
        }
        int result = 0;
        while (x > 0) {
            int digit = x % 10;
            int temp = result * 10 + digit;
            // to detect the multiplication overflow
            if ((temp - digit) / 10 != result) {
                return 0;
            }
            result = temp;
            x = x / 10;
            // System.out.println(result);
        }
        if (neg) {
            return -result;
        } else {
            return result;
        }
    }
    /**
     * This is the reference solution for this question, almost the same as my solution.
     * @param x the integer to be reversed.
     * @return the reversed digit of the integer
     */
    public static int solutionRef(int x) {
        int result = 0;
        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result){
                return 0;
            }
            result = newResult;
            x = x / 10;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = -10003;
        int result = ReverseInteger.solutionRef(test);
        System.out.println(result);

    }

}
