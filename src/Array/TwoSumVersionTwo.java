/**
 *
 */
package Array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of integers that is already sorted in ascending order,
 * find two numbers such that they add up to a specific target number.
 * The function twoSum should return indices of the two numbers such that they add up to the target,
 * where index1 must be less than index2. Please note that your returned answers (both index1 and index2) are not zero-based.
 * You may assume that each input would have exactly one solution and you may not use the same element twice.
 *
 * Input: numbers={2, 7, 11, 15}, target=9
 * Output: index1=1, index2=2
 * @author SenWang
 *
 */
public class TwoSumVersionTwo {
    /**
     * This is my own solution to this problem. This is the basic solution makes use of
     * hash map.
     * @param numbers the array of numbers to be considered.
     * @param target the sum that two numbers should be added up to.
     * @return the pair that contains the index of two numbers.
     */
    public static int[] solution(int[] numbers, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < numbers.length; i++) {
            if (!map.containsKey(target - numbers[i])) {
                map.put(numbers[i], i + 1);
            } else {
                result[0] = map.get(target - numbers[i]);
                result[1] = i + 1;
                return result;
            }
        }
        return null;
    }
    /**
     * This is another solution of mine, which make use of the fact that it is sorted.
     * which should be the standard solution. Use the binary search to find the counter part.
     * @param numbers the array of numbers to be considered.
     * @param target the sum that two numbers should be added up to.
     * @return the pair that contains the index of two numbers.
     */
    public static int[] solution2(int[] numbers, int target) {
        int size = numbers.length;
        int[] result = new int[2];
        for (int i = 0; i < size - 1; i++) {
            int tofind = target - numbers[i];
            if (tofind >= numbers[i + 1] && tofind <= numbers[size - 1]) {
                // use the binary search to find the possible value.
                int low = i + 1;
                int high = size - 1;
                while (low <= high) {
                    int mid = (high + low) / 2;
                    if (numbers[mid] == tofind) {
                        result[0] = i + 1;
                        result[1] = mid + 1;
                        return result;
                    } else if (tofind > numbers[mid]) {
                        low = mid + 1;
                    } else {
                        high = mid - 1;
                    }
                }
            }
        }
        return null;
    }
    /**
     * This is a more efficient solution than hashmap and binary search. It could be
     * considered as the refernce solution. The idea is to shrink the range we search the answer pair
     * @param numbers the array of numbers to be considered.
     * @param target the sum that two numbers should be added up to.
     * @return the pair that contains the index of two numbers.
     */
    public static int[] solutionRef(int[] numbers, int target) {
        int size = numbers.length;
        int[] result = new int[2];
        int low = 0;
        int high = size - 1;
        while (low < high) {
            int tempSum = numbers[low] + numbers[high];
            if (tempSum == target) {
                result[0] = low + 1;
                result[1] = high + 1;
                return result;
            } else if (tempSum < target) {
                low++;
            } else {
                high--;
            }
        }
        return result;
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 7, 11, 15};
        int target = 9;
        int[] result = TwoSumVersionTwo.solutionRef(test, target);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
