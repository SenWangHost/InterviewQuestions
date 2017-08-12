/**
 *
 */
package Math;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number is "happy".
 * A happy number is a number defined by the following process: Starting with any positive integer,
 * replace the number by the sum of the squares of its digits, and repeat the process until the number equals 1
 * (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy numbers.
 *
 * Example: 19 is a happy number
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * @author SenWang
 *
 */
public class HappyNumber {
    /**
     * This is my own solution to this question. This algorithm is based
     * on the fact that all non-happy number will reach 4 during the square summing process.
     * The detail explanation is on wikipedia about happy number.
     * @param n the number to be determined
     * @return true if it is a happy number, false otherwise.
     */
    public static boolean solution(int n) {
        int sum = 0;
        while (sum != 1 && sum != 4) {
            int temp = 0;
            while (n > 0) {
                temp += (n % 10) * (n % 10);
                n /= 10;
            }
            sum = temp;
            n = temp;
        }
        if (sum == 1) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * The reference solution uses many other mathematical properties
     * to test the happy number.
     * This is solution uses the properties, the numbers in [2, 6] are not
     * happy numbers and all non-happy numbers ends in a cycle like this.
     * @param n the number to be determined
     * @return true if it is a happy number, false otherwise.
     */
    public static boolean solutionRef(int n) {
        while (n > 6) {
            int next = 0;
            while (n > 0) {
                next += (n % 10) * (n % 10);
                n /= 10;
            }
            n = next;
        }
        return n == 1;
    }
    /**
     * Another reference solution is actually better in terms of avoiding knowing
     * about the mathematical properties of happy numbers.
     * It uses hashset to keep track of the square sum that occurred during the process.
     * If it already exists in the hashset, jump out of the loop.
     * @param n the number to be determined
     * @return true if it is a happy number, false otherwise.
     */
    public static boolean solutionRef2(int n) {
        Set<Integer> set = new HashSet<Integer>();
        while (set.add(n)) {
            int sum = 0;
            while (n > 0) {
                sum += (n % 10) * (n % 10);
                n /= 10;
            }
            if (sum == 1) {
                return true;
            } else {
                n = sum;
            }
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 8;
        boolean result = HappyNumber.solutionRef2(test);
        System.out.println(result);
    }
}
