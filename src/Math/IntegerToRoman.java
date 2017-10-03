/**
 *
 */
package Math;

/**
 * @author SenWang
 *
 */
public class IntegerToRoman {
    /**
     * this is my own solution to this question, all check point includes the special cases.
     */
    public static String solution(int num) {
        int[] divs = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        String[] letters = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        String result = "";
        while (num != 0) {
            System.out.println(num);
            int count = 0;
            String letter = "";
            for (int i = 0; i < divs.length; i++) {
                int div = divs[i];
                letter = letters[i];
                if (num >= div) {
                    count = num / div;
                    num = num % div;
                    break;
                }
            }
            while (count != 0) {
                result += letter;
                count--;
            }
        }
        return result;
    }
    /**
     * this is one of the reference solution to this question, but generally not a good idea
     * because it is not scalable and extendible.
     */
    public static String solutionRef(int num) {
        String[] M = {"","M","MM","MMM"};
        String[] C = {"","C","CC","CCC","CD","D","DC","DCC","DCCC","CM"};
        String[] X = {"","X","XX","XXX","XL","L","LX","LXX","LXXX","XC"};
        String[] I = {"","I","II","III","IV","V","VI","VII","VIII","IX"};
        return (M[(num / 1000)] +C[(num / 100) % 10] + X[(num / 10) % 10] +I[(num % 10)]);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 41;
        System.out.println(solution(test));
    }

}
