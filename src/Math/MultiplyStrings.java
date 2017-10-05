/**
 *
 */
package Math;

/**
 * @author SenWang
 *
 */
public class MultiplyStrings {
    /**
     * this is my own solution to this question.
     */
    public static String solution(String num1, String num2) {
        if (num1.equals("0") || num2.equals("0")) {
            return "0";
        }
        String second = null;
        String first = null;
        if (num1.length() < num2.length()) {
            first = num2;
            second = num1;
        } else {
            first = num1;
            second = num2;
        }
        StringBuilder result = new StringBuilder("0");
        for (int i = 0; i < second.length(); i++) {
            StringBuilder temp = multiply(first, second.charAt(second.length() - 1 - i));
//            System.out.println(temp);
            for (int j = 0; j < i; j++) {
                temp.append("0");
            }
            result = add(result, temp);
//            System.out.println(result);
        }
        return result.toString();
    }
    /**
     * the method to multiply one string with a char digit
     */
    private static StringBuilder multiply(String num, char digit) {
        StringBuilder number = new StringBuilder(num).reverse();
        StringBuilder result = new StringBuilder("");
        int mul = digit - '0';
        int carry = 0;
        for (int i = 0; i < number.length(); i++) {
            int val = number.charAt(i) - '0';
            int sum = val * mul + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse();
    }
    /**
     * the method to add two number in the form of string builder
     */
    private static StringBuilder add(StringBuilder num1, StringBuilder num2) {
        num1 = num1.reverse();
        num2 = num2.reverse();
        int i = 0;
        int j = 0;
        int len1 = num1.length();
        int len2 = num2.length();
        int carry = 0;
        StringBuilder result = new StringBuilder("");
        while (i < len1 || j < len2) {
            int val1 = 0;
            int val2 = 0;
            if (i < len1) {
                val1 = num1.charAt(i) - '0';
                i++;
            }
            if (j < len2) {
                val2 = num2.charAt(j) - '0';
                j++;
            }
            int sum = val1 + val2 + carry;
            result.append(sum % 10);
            carry = sum / 10;
        }
        if (carry != 0) {
            result.append(carry);
        }
        return result.reverse();
    }
    /**
     * this is reference solution to this question, which uses the idea that num1[i] * num2[j]
     * should be placed at [i + j, i + j + 1]
     */
    public static String solutionRef(String num1, String num2) {
        int len1 = num1.length();
        int len2 = num2.length();
        int[] array = new int[len1 + len2];
        for (int i = len1 - 1; i >= 0; i--) {
            for (int j = len2 - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + array[p2];

                array[p1] += sum / 10;
                array[p2] = sum % 10;
            }
        }
        StringBuilder result = new StringBuilder("");
        for (int num : array) {
            System.out.println(num);
            if (result.length() != 0 || num != 0) {
                result.append(num);
            }
        }
        if (result.length() == 0) {
            return "0";
        }
        return result.toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        StringBuilder num1 = new StringBuilder("8700");
//        StringBuilder num2 = new StringBuilder("3045");
//        System.out.println(add(num1, num2));
//        String num = "1478";
//        char digit = '9';
//        System.out.println(multiply(num, digit));
        String num1 = "1125";
        String num2 = "438";
        System.out.println(solutionRef(num1, num2));
    }

}
