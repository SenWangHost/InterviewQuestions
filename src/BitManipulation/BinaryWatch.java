/**
 *
 */
package BitManipulation;

import java.util.ArrayList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11), and the 6 LEDs on the bottom
 * represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 *
 * For example, the above binary watch reads "3:25".
 * Given a non-negative integer n which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 * Example:
 * Input: n = 1
 * Return: ["1:00", "2:00", "4:00", "8:00", "0:01", "0:02", "0:04", "0:08", "0:16", "0:32"]
 * Note:
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero, for example "10:2" is not valid, it should be "10:02".
 * @author SenWang
 *
 */
public class BinaryWatch {
    /**
     * This is my own solution to this question, which loop through
     * 12 * 60 possible time and check each number that has the matched number of lights.
     * @param num the input number to be considered.
     * @return a list of string to be considered.
     */
    public static List<String> solution(int num) {
        List<String> result = new ArrayList<String>();
        for (int hour = 0; hour <= 11; hour++) {
            int count = countOne(hour, 4);
            for (int min = 0; min <= 59; min++) {
                if (count + countOne(min, 6) == num) {
                    StringBuilder temp = new StringBuilder();
                    temp.append(hour);
                    temp.append(":");
                    if (min >= 0 && min <= 9) {
                        temp.append("0" + min);
                    } else {
                        temp.append(min);
                    }
                    result.add(temp.toString());
                }
            }

        }
        return result;
    }
    /**
     * check the number of 1 bit within a specific range.
     * @param number the input number to be considered.
     * @param range the range of bits to be considered.
     * @return number of 1 bit within this range.
     */
    private static int countOne(int number, int range) {
        int count = 0;
        for (int i = 0; i < range; i++) {
            count += ((number >> i) & 1);
        }
        return count;
    }
    /**
     * This is one of the reference solutions to this question, the idea is
     * the same as mine, but use java built-in function to achieve the same functionality.
     * @param num the input number to be considered.
     * @return a list of string to be considered.
     */
    public static List<String> solutionRef(int num) {
        List<String> result = new ArrayList<String>();
        for (int hour = 0; hour < 12; hour++) {
            for (int min = 0; min < 60; min++) {
                if (Integer.bitCount(hour) + Integer.bitCount(min) == num) {
                    result.add(String.format("%d:%02d", hour, min));
                }
            }
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 2;
        List<String> result = BinaryWatch.solution(test);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
