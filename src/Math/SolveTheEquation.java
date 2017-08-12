/**
 *
 */
package Math;

/**
 * Solve a given equation and return the value of x in the form of string "x=#value".
 * The equation contains only '+', '-' operation, the variable x and its coefficient.
 * If there is no solution for the equation, return "No solution".
 * If there are infinite solutions for the equation, return "Infinite solutions".
 * If there is exactly one solution for the equation, we ensure that the value of x is an integer.
 *
 * Example 1:
 * Input: "x+5-3+x=6+x-2"
 * Output: "x=2"
 *
 * Example 2:
 * Input: "x=x"
 * Output: "Infinite solutions"
 *
 * Example 3:
 * Input: "2x=x"
 * Output: "x=0"
 *
 * Example 4:
 * Input: "2x+3x-6x=x+2"
 * Output: "x=-1"
 *
 * Example 5:
 * Input: "x=x+2"
 * Output: "No solution"
 * @author SenWang
 *
 */
public class SolveTheEquation {
    /**
     * This is my own solution to this question. This solution is acceptable
     * and the runtime complexity would be O(n).
     * @param equation the string representation of equation to be evaluated.
     * @return the possible solution of this solution in the form of string.
     */
    public static String solution(String equation) {
        int constant = 0;
        int reverse = 1;
        int sign = 1;
        int countx = 0;
        int index = 0;
        while (index < equation.length()) {
            char temp = equation.charAt(index);
            if (temp == '+') {
                sign = 1;
            } else if (temp == '-') {
                sign = -1;
            } else if (temp == 'x') {
                countx += sign * reverse;
            } else if (temp >= '0' && temp <= '9') {
                int number = 0;
                while (index < equation.length() && equation.charAt(index) >= '0' && equation.charAt(index) <= '9') {
                    number = number * 10 + equation.charAt(index) - '0';
                    index++;
                }
                if (index < equation.length() && equation.charAt(index) == 'x') {
                    countx += sign * number * reverse;
                } else {
                    constant += sign * number * reverse;
                    index--;
                }
            } else if (temp == '=') {
                // reset reverse and sign
                reverse = -1;
                sign = 1;
            }
            index++;
        }
        if (countx == 0 && constant == 0) {
            return "Infinite solutions";
        } else if (countx == 0 && constant != 0) {
            return "No solution";
        } else if (countx != 0) {
            int numeric = (reverse * constant) / countx;
            return "x=" + numeric;
        }
        return null;
    }
    /**
     * This is the reference solution to this question, which based
     * on the splitting of the equation by the equal sign.
     * The detailed explanation is on leetcode.
     * @param equation the string representation of equation to be evaluated.
     * @return the possible solution of this solution in the form of string.
     */
    public static String solutionRef(String equation) {
        String[] lr = equation.split("=");
        int lhs = 0, rhs = 0;
        for (String x: lr[0].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("x") >= 0) {

                lhs += Integer.parseInt(coeff(x));
            } else
                rhs -= Integer.parseInt(x);
        }
        for (String x: lr[1].split("(?=\\+)|(?=-)")) {
            if (x.indexOf("x") >= 0)
                lhs -= Integer.parseInt(coeff(x));
            else
                rhs += Integer.parseInt(x);
        }
        if (lhs == 0) {
            if (rhs == 0)
                return "Infinite solutions";
            else
                return "No solution";
        } else
            return "x=" + rhs / lhs;
    }
    /**
     * This is the helper function for this question.
     * @param x the input string to be considered.
     * @return the string after getting its coefficients.
     */
    private static String coeff(String x) {
        if (x.length() > 1 && x.charAt(x.length() - 2) >= '0' && x.charAt(x.length() - 2) <= '9') {
            return x.replace("x", "");
        }
        return x.replace("x", "1");
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "3x=33+22+11";
        String result = SolveTheEquation.solution(test);
        System.out.println(result);
    }

}
