/**
 *
 */
package Math;

/**
 * Given a non-negative integer num, repeatedly add all its digits until the result has only one digit.
 * For example:
 * Given num = 38, the process is like: 3 + 8 = 11, 1 + 1 = 2. Since 2 has only one digit, return it.
 * Follow up:
 * Could you do it without any loop/recursion in O(1) runtime?
 * @author SenWang
 *
 */
public class AddDigits {
    /**
     * This is my own solution to this question. This solution
     * has loops.
     * @param num the number to be considered.
     * @return the only one digit after summing the digits repeatly.
     */
    public static int solution(int num) {
        int result = 10;
        while (result > 9) {
            int sum = 0;
            while (num > 0) {
                sum += num % 10;
                num /= 10;
            }
            num = sum;
            result = sum;
        }
        return result;
    }
    /**
     * This is the reference solution to this question.
     * This math problem is actually a digit root problem can be calculate by
     * congruence in modular arithmetics. Detailed explanation is offer on wikipedia.
     */
    public static int solutionRef(int num) {
        return 1 + (num - 1) % 9;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 12357;
        int result = AddDigits.solutionRef(test);
        System.out.println(result);
    }
}
