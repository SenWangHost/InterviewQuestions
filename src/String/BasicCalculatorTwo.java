/**
 *
 */
package String;

/**
 * Implement a basic calculator to evaluate a simple expression string.
 * The expression string contains only non-negative integers, +, -, *, / operators and empty spaces .
 * The integer division should truncate toward zero.
 * You may assume that the given expression is always valid.
 * Some examples:
 * "3+2*2" = 7
 * " 3/2 " = 1
 * " 3+5 / 2 " = 5
 * Note: Do not use the eval built-in library function.
 * @author SenWang
 *
 */
public class BasicCalculatorTwo {
    /**
     * This is my own solution to this question. This solution is acceptable
     * but the code is too complicated
     * @param s the input string expression to be evaluated.
     * @return the integer result of the evaluation.
     */
    public static int solution(String s) {
        s = s.replaceAll(" ", "");
        String[] array = s.split("[\\+-]");
        boolean[] signs = new boolean[array.length];
        for (int i = 0, j = 0; i < s.length(); i++) {
            if (i == 0) {
                if (s.charAt(i) == '-') {
                    signs[j++] = false;
                } else {
                    signs[j++] = true;
                }
            } else if (s.charAt(i) == '+') {
                signs[j++] = true;
            } else if (s.charAt(i) == '-') {
                signs[j++] = false;
            }
        }
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            String temp = array[i];
            // get the sign of the expression.
            int sign = 1;
            if (!signs[i]) {
                sign = -1;
            }
            // evaluate the expression by further splitting the expression
            if (temp.indexOf('/') == -1 && temp.indexOf('*') == -1) {
                result += sign * Integer.parseInt(temp);
            } else {
                String[] numbers = temp.split("[\\*/]");
                char[] signArray = new char[numbers.length - 1];
                for (int k = 0, j = 0; k < temp.length(); k++) {
                    if (temp.charAt(k) == '*') {
                        signArray[j++] = '*';
                    } else if (temp.charAt(k) == '/') {
                        signArray[j++] = '/';
                    }
                }
                int number = Integer.parseInt(numbers[0]);
                for (int m = 1; m < numbers.length; m++) {
                    if (signArray[m - 1] == '*') {
                        number *= Integer.parseInt(numbers[m]);
                    } else {
                        number /= Integer.parseInt(numbers[m]);
                    }
                }
                result += sign * number;
            }
        }
        return result;
    }
    /**
     * This is one of the reference solutions, in which use two variables
     * to keep track of the result of addition and multiplication.
     * @param s the input string expression to be evaluated.
     * @return the integer result of the evaluation.
     */
    public static int solutionRef(String s) {
        if (s == null) {
            return 0;
        }
        s = s.trim().replaceAll(" +", "");
        int length = s.length();

        int res = 0;
        long preVal = 0; // initial preVal is 0
        char sign = '+'; // initial sign is +
        int i = 0;
        while (i < length) {
            long curVal = 0;
            while (i < length && s.charAt(i) <= 57 && s.charAt(i) >= 48) { // int
                curVal = curVal*10 + (s.charAt(i) - '0');
                i++;
            }
            if (sign == '+') {
                res += preVal;  // update res
                preVal = curVal;
            } else if (sign == '-') {
                res += preVal;  // update res
                preVal = -curVal;
            } else if (sign == '*') {
                preVal = preVal * curVal; // not update res, combine preVal & curVal and keep loop
            } else if (sign == '/') {
                preVal = preVal / curVal; // not update res, combine preVal & curVal and keep loop
            }
            if (i < length) { // getting new sign
                sign = s.charAt(i);
                i++;
            }
        }
        res += preVal;
        return res;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "161+6033/2/69-11*2-12*6+51*40";
        int result = BasicCalculatorTwo.solution(test);
        System.out.println(result);
    }

}
