/**
 *
 */
package Math;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 * For example:
 *    1 -> A
 *    2 -> B
 *    3 -> C
 *    ...
 *    26 -> Z
 *    27 -> AA
 *    28 -> AB
 * @author SenWang
 *
 */
public class ExcelSheetColumnTitle {
    /**
     * This is my own solution to this question. Consider it as base-26 number, then
     * it is easy to convert 1 - 26 to A - Z.
     * @param n the column number.
     * @return the corresponding column title
     */
    public static String solution(int n) {
        StringBuilder result = new StringBuilder("");
        while (n > 0) {
            result.append(Character.toString((char) ('A' + (n - 1) % 26)));
            n = (n - 1) / 26;
        }
        return result.reverse().toString();
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
        int test = 729;
        String result = ExcelSheetColumnTitle.solution(test);
        System.out.println(result);
    }
}
