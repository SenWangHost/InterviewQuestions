/**
 *
 */
package Math;

/**
 * Given an integer, return its base 7 string representation.

Example 1:
Input: 100
Output: "202"
Example 2:
Input: -7
Output: "-10"
Note: The input will be in range of [-1e7, 1e7].
 * @author SenWang
 *
 */
public class Base7 {
    /**
     * this is my own solution to this question.
     */
    public static String solution(int num) {
        if (num == 0) {
            return "0";
        }
        int sign = 1;
        if (num < 0) {
            sign = -1;
        }
        num = Math.abs(num);
        StringBuilder result = new StringBuilder("");
        while (num > 0) {
            int rem = num % 7;
            result.append(String.valueOf(rem));
            num /= 7;
        }
        if (sign == 1) {
            return result.reverse().toString();
        } else {
            return result.append("-").reverse().toString();
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
