/**
 *
 */
package String;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * P   A   H   N
 * A P L S I I G
 * Y   I   R
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 * @author SenWang
 *
 */
public class ZigZagConversion {
    /**
     * this is my own solution to this question. This solution is accepted.
     */
    public static String solution(String s, int numRows) {
        if (numRows <= 1) {
            return s;
        }
        StringBuilder[] temp = new StringBuilder[numRows];
        for (int i = 0; i < temp.length; i++) {
            temp[i] = new StringBuilder("");
        }
        int index = 0;
        boolean col = true;
        int startc = 0;
        int endc = numRows - 1;
        int startl = numRows - 2;
        int endl = 1;
        while (index < s.length()) {
            if (col) {
                for (int i = startc; i <= endc && index < s.length(); i++) {
                    temp[i].append(s.charAt(index));
                    index++;
                }
                col = false;
            } else {
                for (int i = startl; i >= endl && index < s.length(); i--) {
                    temp[i].append(s.charAt(index));
                    index++;
                }
                col = true;
            }
        }
        StringBuilder result = temp[0];
        for (int i = 1; i < temp.length; i++) {
            result.append(temp[i]);
        }
        return result.toString();
    }
    /**
     * the reference solution has the same idea as mine
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
