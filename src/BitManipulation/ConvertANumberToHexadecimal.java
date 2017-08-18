/**
 *
 */
package BitManipulation;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal. For negative integer,
 * two’s complement method is used.
 *
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s. If the number is zero, it is
 * represented by a single zero character '0'; otherwise, the first character in the hexadecimal string
 * will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 *
 * Example 1:
 * Input:
 * 26
 * Output:
 * "1a"
 *
 * Example 2:
 * Input:
 * -1
 * Output:
 * "ffffffff"
 * @author SenWang
 *
 */
public class ConvertANumberToHexadecimal {
    /**
     * This is my own solution to this question.
     * @param num the input number to be considered.
     * @return the hexadecimal representation of this number.
     */
    public static String solution(int num) {
        String[] table = new String[16];
        for (int i = 0; i < 16; i++) {
            if (i <= 9) {
                table[i] = Integer.toString(i);
            } else {
                table[i] = Character.toString((char) ('a' + i - 10));
            }
        }
        int mask = 15;
        StringBuilder result = new StringBuilder();
        for (int j = 28; j >= 0; j -= 4) {
            int temp = (num >> j) & mask;
            if (result.length() == 0 && temp != 0) {
                result.append(table[temp]);
            } else if (result.length() != 0){
                result.append(table[temp]);
            }
        }
        if (num == 0) {
            return "0";
        }
        return result.toString();
    }
    /**
     * This is my another solution to this question.
     * @param num the input number to be considered.
     * @return the hexadecimal representation of this number.
     */
    public static String solution2(int num) {
        if (num == 0) {
            return "0";
        }
        int mask = 15;
        StringBuilder result = new StringBuilder();
        for (int i = 28; i >= 0; i -= 4) {
            int temp = (num >> i) & mask;
            char hex;
            if (temp >= 0 && temp <= 9) {
                hex = (char) ('0' + temp);
            } else {
                hex = (char) ('a' + temp - 10);
            }
            if (result.length() == 0 && temp != 0) {
                result.append(Character.toString(hex));
            } else if (result.length() != 0) {
                result.append(Character.toString(hex));
            }
        }
        return result.toString();
    }
    /**
     * This is the reference solution to this question, the idea is the same but the
     * code is more compact.
     * @param num the input number to be considered.
     * @return the hexadecimal representation of this number.
     */
    public static String solutionRef(int num) {
        if (num == 0) {
            return "0";
        }
        char[] table = {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        String result = "";
        while (num != 0) {
            result = table[num & 15] + result;
            num >>>= 4;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 162;
        System.out.println(ConvertANumberToHexadecimal.solutionRef(test));
    }
}
