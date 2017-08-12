/**
 *
 */
package Math;

import java.util.stream.Stream;

/**
 * Given a string representing an expression of fraction addition and subtraction, you need to return the calculation
 * result in string format. The final result should be irreducible fraction. If your final result is an integer,
 * say 2, you need to change it to the format of fraction that has denominator 1.
 * So in this case, 2 should be converted to 2/1.
 *
 * Example 1:
 * Input:"-1/2+1/2"
 * Output: "0/1"
 *
 * Example 2:
 * Input:"-1/2+1/2+1/3"
 * Output: "1/3"
 *
 * Example 3:
 * Input:"1/3-1/2"
 * Output: "-1/6"
 *
 * Example 4:
 * Input:"5/3+1/3"
 * Output: "2/1"
 *
 * Note:
 * The input string only contains '0' to '9', '/', '+' and '-'. So does the output.
 * Each fraction (input and output) has format ±numerator/denominator. If the first input fraction or the output is
 * positive, then '+' will be omitted.
 * The input only contains valid irreducible fractions, where the numerator and denominator of each fraction will always
 * be in the range [1,10]. If the denominator is 1, it means this fraction is actually an integer in a fraction format defined above.
 * The number of given fractions will be in the range [1,10].
 * The numerator and denominator of the final result are guaranteed to be valid and in the range of 32-bit int.
 * @author SenWang
 *
 */
public class FractionAdditionAndSubtraction {
    /**
     * This is my own solution to this question. The runtime complexity
     * is O(n) and beats 98% of the solutions on leetcode. But the code
     * is rather complicated.
     * @param expression the expression containing fraction to be evaluated.
     * @return the result of the faction addition and subtraction.
     */
    public static String solution(String expression) {
        int sign = 1;
        int numinator = 0;
        int denominator = 1;
        int index = 0;
        while (index < expression.length()) {
            char temp = expression.charAt(index);
            if (temp == '+') {
                sign = 1;
            } else if (temp == '-') {
                sign = -1;
            } else if (temp >= '0' && temp <= '9') {
                int num = 0;
                int denomi = 0;
                boolean fraction = false;
                while (index < expression.length() &&
                        (expression.charAt(index) == '/' || (expression.charAt(index) >= '0' && expression.charAt(index) <= '9'))) {
                    char c = expression.charAt(index);
                    if (c == '/') {
                        fraction = true;
                    } else if (!fraction) {
                        num = num * 10 + c - '0';
                    } else {
                        denomi = denomi * 10 + c - '0';
                    }
                    index++;
                }
                int lcm = lcm(denominator, denomi);
                int fac1 = lcm / denominator;
                int fac2 = lcm / denomi;
                denominator = lcm;
                numinator = numinator * fac1 + sign * fac2 * num;
                index--;
            }
            index++;
        }
        System.out.println(numinator);
        System.out.println(denominator);
        if (numinator == 0) {
            return "0/1";
        } else {
            int gcd = gcd(Math.abs(numinator), denominator);
            numinator /= gcd;
            denominator /= gcd;
        }
        return numinator + "/" + denominator;
    }
    /**
     * This is the helper function to calculate the greatest common factor
     * between two numbers
     * @param a the first number.
     * @param b the second number.
     * @return the greatest common factor.
     */
    private static int gcd(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    /**
     * This is the helper function to find the least common multiple between
     * two numbers.
     * @param a the first number.
     * @param b the second number.
     * @return the greatest multiple of the two numbers.
     */
    private static int lcm(int a, int b) {
        // compute the least common multiple by first computing
        // the greatest common divisor.
        int gcd = gcd(a, b);
        return a * b / gcd;
    }
    /**
     * This is one of the reference solutions to this questions. The
     * idea is first to split the string into different faction numbers and then
     * add them together.
     * @param expression the expression containing fraction to be evaluated.
     * @return the result of the faction addition and subtraction.
     */
    public static String solutionRef(String expression) {
        String[] fracs = expression.split("(?=[-+])"); // splits input string into individual fractions
        String res = "0/1";
        for (String frac : fracs) {
            res = add(res, frac); // add all fractions together
        }
        return res;
    }
    /**
     * This is the helper function to add two fraction number together.
     * @param frac1 the first fraction represented by string.
     * @param frac2 the second fraction represented by string.
     * @return the sum of the two fraction number representedby string.
     */
    private static String add(String frac1, String frac2) {
        int[] f1 = Stream.of(frac1.split("/")).mapToInt(Integer::parseInt).toArray(),
                f2 = Stream.of(frac2.split("/")).mapToInt(Integer::parseInt).toArray();
        int numer = f1[0] * f2[1] + f1[1] * f2[0], denom = f1[1] * f2[1];
        String sign = "";
        if (numer < 0) {
            sign = "-";
            numer *= -1;
        }
        return sign + numer / gcd(numer, denom) + "/" + denom / gcd(numer, denom); // construct reduced fraction
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "5/3+1/3";
        String result = FractionAdditionAndSubtraction.solution(test);
        System.out.println(result);
    }

}
