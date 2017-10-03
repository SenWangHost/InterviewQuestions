/**
 *
 */
package Math;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 * @author SenWang
 *
 */
public class RomanToInteger {
    /**
     * this is my own solution to this question.
     */
    public static int solution(String s) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        map.put('I', 1);
        map.put('V', 5);
        map.put('X', 10);
        map.put('L', 50);
        map.put('C', 100);
        map.put('D', 500);
        map.put('M', 1000);
        char[] array = s.toCharArray();
        int result = 0;
        for (int i = 0; i < array.length; i++) {
            if (i + 1 < array.length) {
                int curr = map.get(array[i]);
                int next = map.get(array[i + 1]);
                if (curr < next) {
                    result -= curr;
                } else {
                    result += curr;
                }
            } else {
                result += map.get(array[i]);
            }
        }
        return result;
    }
    /**
     * this is one of reference solution, use the same idea but runs fast because of array
     */
    public static int solutionRef(String s) {
        int[] array = new int[s.length()];
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == 'I') {
                array[i] = 1;
            } else if (c == 'V') {
                array[i] = 5;
            } else if (c == 'X') {
                array[i] = 10;
            } else if (c == 'L') {
                array[i] = 50;
            } else if (c == 'C') {
                array[i] = 100;
            } else if (c == 'D') {
                array[i] = 500;
            } else if (c == 'M') {
                array[i] = 1000;
            }
        }
        int sum = 0;
        for (int i = 0; i < array.length - 1; i++) {
            if (array[i] < array[i + 1]) {
                sum -= array[i];
            } else {
                sum += array[i];
            }
        }
        return sum;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "DCXXI";
        System.out.println(solution(test));
    }

}
