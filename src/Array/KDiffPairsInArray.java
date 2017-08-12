/**
 *
 */
package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * Given an array of integers and an integer k, you need to find the number of unique k-diff pairs in the array.
 * Here a k-diff pair is defined as an integer pair (i, j), where i and j are both numbers in the array and
 * their absolute difference is k.
 *
 * Example 1:
 * Input: [3, 1, 4, 1, 5], k = 2
 * Output: 2
 * Explanation: There are two 2-diff pairs in the array, (1, 3) and (3, 5).
 * Although we have two 1s in the input, we should only return the number of unique pairs.
 *
 * Example 2:
 * Input:[1, 2, 3, 4, 5], k = 1
 * Output: 4
 * Explanation: There are four 1-diff pairs in the array, (1, 2), (2, 3), (3, 4) and (4, 5).
 *
 * Example 3:
 * Input: [1, 3, 1, 5, 4], k = 0
 * Output: 1
 * Explanation: There is one 0-diff pair in the array, (1, 1).
 * @author SenWang
 *
 */
public class KDiffPairsInArray {
    /**
     * This is my own solution for this question. This solution is acceptable but way too
     * complicated.
     * @param nums the array of numbers to be considered.
     * @param k the difference the user specified.
     * @return the number of unique k-difference pair
     */
    public static int solution(int[] nums, int k) {
        int n = nums.length;
        if (k < 0) {
            return 0;
        } else if (k == 0) {
            int count = 0;
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int i = 0; i < n; i++) {
                if (map.containsKey(nums[i])) {
                    map.put(nums[i], map.get(nums[i]) + 1);
                    if (map.get(nums[i]) == 2) {
                        count++;
                    }
                } else {
                    map.put(nums[i], 1);
                }
            }
            return count;
        } else {
            int count = 0;
            Set<Integer> set = new HashSet<Integer>();
            for (int i = 0; i < n; i++) {
                if (set.contains(nums[i] + k) && !set.contains(nums[i])) {
                    count++;
                }
                if (set.contains(nums[i] - k) && !set.contains(nums[i])) {
                    count++;
                }
                if (!set.contains(nums[i])) {
                    set.add(nums[i]);
                }
            }
            return count;
        }

    }
    /**
     * This is the reference solution that uses the hashmap. The idea is to
     * store the element and the times it appeared into the hashmap.
     * @param nums the array of numbers to be considered.
     * @param k the difference the user specified.
     * @return the number of unique k-difference pair
     */
    public static int solutionRef(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k < 0) {
            return 0;
        }
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }
        int count = 0;
        for (Map.Entry<Integer, Integer> entry: map.entrySet()) {
            if (k == 0) {
                // count the element that appears more than once.
                if (entry.getValue() > 1) {
                    count++;
                }
            } else {
                if (map.containsKey(entry.getKey() + k)) {
                    count++;
                }
            }
        }
        return count;
    }
    /**
     * This is another reference solution, which uses two pointers.
     * The runtime complexity would be O(n * log(n)).
     * @param nums the array of numbers to be considered.
     * @param k the difference the user specified.
     * @return the number of unique k-difference pair
     */
    public static int solutionRef2(int[] nums, int k) {
        if (k < 0) {
            return 0;
        }
        Arrays.sort(nums);
        int result = 0;
        for (int i = 0, j = 1; j < nums.length;) {
            if (j <= i || nums[i] + k > nums[j]) {
                j++;
            } else if (i > 0 && nums[i] == nums[i - 1] || nums[i] + k < nums[j]) {
                i++;
            } else {
                result++;
                i++;
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
        int[] test = {1, 3, 1, 5, 4};
        int k = 0;
        int result = KDiffPairsInArray.solution(test, k);
        System.out.println(result);
    }
}
