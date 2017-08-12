/**
 *
 */
package Math;

/**
 * Related to question Excel Sheet Column Title
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 * For example:
 *     A -> 1
 *     B -> 2
 *     C -> 3
 *     ...
 *     Z -> 26
 *     AA -> 27
 *     AB -> 28
 * @author SenWang
 *
 */
public class ExcelSheetColumnNumber {
    /**
     * This is my own solution to this question.
     * @param s the string representation of column number
     * @return the column number of excel title.
     */
    public static int solution(String s) {
        int result = 0;
        int count = 1;
        for (int i = s.length() - 1; i >= 0; i--) {
            int digit = s.charAt(i) - 'A' + 1;
            result += digit * count;
            count *= 26;
        }
        return result;
    }
    /**
     * The reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "AAA";
        int result = ExcelSheetColumnNumber.solution(test);
        System.out.println(result);
    }

}
