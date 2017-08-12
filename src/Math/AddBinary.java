/**
 *
 */
package Math;

/**
 * Given two binary strings, return their sum (also a binary string).
 * For example,
 * a = "11"
 * b = "1"
 * Return "100".
 * @author SenWang
 *
 */
public class AddBinary {
    /**
     * This is my own solution to this question.
     * @param a the string representation of the first binary number.
     * @param b the string representation of the second binary number.
     * @return the string representation of the summing binary number.
     */
    public static String solution(String a, String b) {
        int lenA = a.length();
        int lenB = b.length();
        int indexA = lenA - 1;
        int indexB = lenB - 1;
        int digitA = 0;
        int digitB = 0;
        int carriage = 0;
        StringBuilder result = new StringBuilder("");
        while (indexA >= 0 || indexB >= 0) {
            if (indexA >= 0) {
                digitA = a.charAt(indexA) - '0';
            } else {
                digitA = 0;
            }
            if (indexB >= 0) {
                digitB = b.charAt(indexB) - '0';
            } else {
                digitB = 0;
            }
            int sum = digitA + digitB + carriage;
            result.append((char) (sum % 2 + '0'));
            carriage = sum / 2;
            indexA--;
            indexB--;
            if (indexA < 0 && indexB < 0 && carriage == 1) {
                result.append('1');
            }
        }
        return result.reverse().toString();
    }
    /**
     * The reference solution has the same idea as mine. This version
     * of code is more compact.
     * @param a the string representation of the first binary number.
     * @param b the string representation of the second binary number.
     * @return the string representation of the summing binary number.
     */
    public static String solutionRef(String a, String b) {
        StringBuilder result = new StringBuilder("");
        int indexA = a.length() - 1;
        int indexB = b.length() - 1;
        int carriage = 0;
        while (indexA >= 0 || indexB >= 0) {
            int sum = carriage;
            if (indexA >= 0) {
                sum += a.charAt(indexA--) - '0';
            }
            if (indexB >= 0) {
                sum += b.charAt(indexB--) - '0';
            }
            result.append(sum % 2);
            carriage = sum / 2;
        }
        if (carriage == 1) {
            result.append('1');
        }
        return result.reverse().toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String testA = "11";
        String testB = "11";
        String result = AddBinary.solution(testA, testB);
        System.out.println(result);
    }

}
