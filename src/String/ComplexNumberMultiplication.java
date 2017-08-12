/**
 *
 */
package String;

/**
 * Given two strings representing two complex numbers.
 * You need to return a string representing their multiplication. Note i2 = -1 according to the definition.
 *
 * Example 1:
 * Input: "1+1i", "1+1i"
 * Output: "0+2i"
 * Explanation: (1 + i) * (1 + i) = 1 + i2 + 2 * i = 2i, and you need convert it to the form of 0+2i.
 *
 * Example 2:
 * Input: "1+-1i", "1+-1i"
 * Output: "0+-2i"
 * Explanation: (1 - i) * (1 - i) = 1 + i2 - 2 * i = -2i, and you need convert it to the form of 0+-2i.
 * Note:
 * The input strings will not have extra blank.
 * The input strings will be given in the form of a+bi, where the integer a and b will both belong to the range of
 * [-100, 100]. And the output should be also in this form.
 * @author SenWang
 *
 */
public class ComplexNumberMultiplication {
    /**
     * This is my own solution to this question.
     * @param a the string representation of the first complex number.
     * @param b the string representation of the second complex number.
     * @return the string representation of the multiplication result
     */
    public static String solution(String a, String b) {
        int[] complex1 = toArray(a);
        int[] complex2 = toArray(b);
        int constant = complex1[0] * complex2[0] - complex1[1] * complex2[1];
        int parameter = complex1[0] * complex2[1] + complex1[1] * complex2[0];
        return constant + "+" + parameter + "i";
    }
    /**
     * This is the helper function to convert string representation of
     * complex number to an array of integer [a, b]
     * @param complex the string representation of the complex number.
     * @return an array of integer of constants [a, b]
     */
    private static int[] toArray(String complex) {
        String[] str = complex.split("\\+");
        int[] result = new int[2];
        result[0] = Integer.parseInt(str[0]);
        result[1] = Integer.parseInt(str[1].substring(0, str[1].length() - 1));
        return result;
    }
    /**
     * This is the reference solution to this question, which uses
     * the same algorithm but with more clean code.
     * @param a the string representation of the first complex number.
     * @param b the string representation of the second complex number.
     * @return the string representation of the multiplication result
     */
    public static String solutionRef(String a, String b) {
        String x[] = a.split("\\+|i");
        String y[] = b.split("\\+|i");
        int a_real = Integer.parseInt(x[0]);
        int a_img = Integer.parseInt(x[1]);
        int b_real = Integer.parseInt(y[0]);
        int b_img = Integer.parseInt(y[1]);
        return (a_real * b_real - a_img * b_img) + "+" + (a_real * b_img + a_img * b_real) + "i";
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test1 = "1+-1i";
        String test2 = "1+-1i";
        String result = ComplexNumberMultiplication.solution(test1, test2);
        System.out.println(result);

    }

}
