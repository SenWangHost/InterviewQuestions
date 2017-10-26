/**
 *
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).
 * Write a function to determine if a number is strobogrammatic. The number is represented as a string.
 * For example, the numbers "69", "88", and "818" are all strobogrammatic.
 * @author SenWang
 *
 */
public class StrobogrammaticNumber {
    /**
     * this is my own solution to this question.
     */
    public static boolean solution(String num) {
        Map<Character, Character> map = new HashMap<Character, Character>();
        map.put('6', '9');
        map.put('9', '6');
        map.put('1', '1');
        map.put('0', '0');
        map.put('8', '8');
        char[] array = num.toCharArray();
        int low = 0;
        int end = array.length - 1;
        while (low <= end) {
            if (!map.containsKey(array[low])) {
                return false;
            }
            if (map.get(array[low]) != array[end]) {
                return false;
            }
            low++;
            end--;
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
