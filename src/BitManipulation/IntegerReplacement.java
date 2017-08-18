/**
 *
 */
package BitManipulation;

/**
 * Given a positive integer n and you can do operations as follow:
 * If n is even, replace n with n/2.
 * If n is odd, you can replace n with either n + 1 or n - 1.
 * What is the minimum number of replacements needed for n to become 1?
 *
 * Example 1:
 * Input:
 * 8
 * Output:
 * 3
 * Explanation:
 * 8 -> 4 -> 2 -> 1
 *
 * Example 2:
 * Input:
 * 7
 * Output:
 * 4
 * Explanation:
 * 7 -> 8 -> 4 -> 2 -> 1
 * or
 * 7 -> 6 -> 3 -> 2 -> 1
 * @author SenWang
 *
 */
public class IntegerReplacement {
    /**
     * This is my own solution to this question. The detailed expalnation is on the leetcode.
     * @param n the input integer.
     * @return the min number of steps for the number to reach one;
     */
    public static int solution(int n) {
        int count = 0;
        while (n != 1) {
            if (n % 2 == 0) {
                n >>>= 1;
            } else if (n == 3 || Integer.bitCount(n + 1) > Integer.bitCount(n - 1)) {
                n--;
            } else {
                n++;
            }
            count++;
        }
        return count;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 1234;
        System.out.println(IntegerReplacement.solution(test));
        System.out.println(Integer.toBinaryString(test));
    }

}
