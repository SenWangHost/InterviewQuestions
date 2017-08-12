/**
 *
 */
package String;

/**
 * Implement atoi to convert a string to an integer.
 * Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself
 * what are the possible input cases.
 * Notes: It is intended for this problem to be specified vaguely (ie, no given input specs).
 * You are responsible to gather all the input requirements up front.
 *
 * The function first discards as many whitespace characters as necessary until the first non-whitespace character is found.
 * Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible,
 * and interprets them as a numerical value.
 * The string can contain additional characters after those that form the integral number,
 * which are ignored and have no effect on the behavior of this function.
 * If the first sequence of non-whitespace characters in str is not a valid integral number, or
 * if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.
 * If no valid conversion could be performed, a zero value is returned.
 * If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
 * @author SenWang
 *
 */
public class StringToInteger {
    /**
     * This is my own solution to this question. The runtime complexity
     * of this solution is O(n) but code is not compact and clean.
     * @param str the string input to be converted.
     * @return the integer that is converted from the string.
     */
    public static int solution(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int index = 0;
        // discard white space characters
        while (str.charAt(index) == ' ') {
            index++;
        }
        // starting from this character, check if this character is valid for
        // conversion
        if (str.charAt(index) != '-' && str.charAt(index) != '+'
                && str.charAt(index) > '9' && str.charAt(index) < '0') {
            return 0;
        }
        int sign = 1;
        int result = 0;
        int start = index;
        while (index < str.length()) {
            char temp = str.charAt(index);
            if (temp == '-' && index == start) {
                sign = -1;
            } else if (temp == '+' && index == start) {
                sign = 1;
            } else if (temp >= '0' && temp <= '9') {
                int digit = temp - '0';
                int base = result * 10;
                // overflow happening
                if (base / 10 != result && sign == 1) {
                    return Integer.MAX_VALUE;
                } else if (base / 10 != result && sign == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    result = base + digit;
                    if (result < 0 && sign == 1) {
                        return Integer.MAX_VALUE;
                    } else if (result < 0 && sign == -1) {
                        return Integer.MIN_VALUE;
                    }
                }
            } else {
                break;
            }
            index++;
        }
        return result * sign;
    }
    /**
     * The reference solution has the same idea as mine, but the code is more clean and compact.
     * First, discard all leading whitespaces.
     * Second, handle
     * @param str the string input to be converted.
     * @return the integer that is converted from the string.
     */
    public static int solutionRef(String str) {
        int base = 0;
        int sign = 1;
        int index = 0;
        // first, discard the white space
        while (str.charAt(index) == ' ') {
            index++;
        }
        // second, handle the sign
        if (str.charAt(index) == '-') {
            sign = -1;
            index++;
        } else if (str.charAt(index) == '+') {
            sign = 1;
            index++;
        }
        // third, convert to integer while handling the overflow.
        while (index < str.length() && str.charAt(index) >= '0' && str.charAt(index) <= '9') {
            int digit = str.charAt(index) - '0';
            // detect the overflow and handle it
            if (base > Integer.MAX_VALUE / 10 || (base == Integer.MAX_VALUE / 10 && digit > 7)) {
                if (sign == 1) {
                    return Integer.MAX_VALUE;
                } else {
                    return Integer.MIN_VALUE;
                }
            }
            base = base * 10 + digit;
            index++;
        }
        return base* sign;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "1234";
        int result = StringToInteger.solutionRef(test);
        System.out.println(result);
//        System.out.println(Integer.MIN_VALUE);
//        System.out.println(Integer.MAX_VALUE);
    }
}
