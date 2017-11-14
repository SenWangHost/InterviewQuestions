/**
 *
 */
package HashTable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Given scores of N athletes, find their relative ranks and the people with the top three highest scores,
 * who will be awarded medals: "Gold Medal", "Silver Medal" and "Bronze Medal".
 *
 * Example 1:
 * Input: [5, 4, 3, 2, 1]
 * Output: ["Gold Medal", "Silver Medal", "Bronze Medal", "4", "5"]
 * Explanation: The first three athletes got the top three highest scores,
 * so they got "Gold Medal", "Silver Medal" and "Bronze Medal".
 * For the left two athletes, you just need to output their relative ranks according to their scores.
 *
 * Note:
 * 1. N is a positive integer and won't exceed 10,000.
 * 2. All the scores of athletes are guaranteed to be unique.
 * @author SenWang
 *
 */
public class RelativeRanks {
    /**
     * this is my own solution to this question.
     */
    public static String[] solution(int[] nums) {
        int rank = nums.length;
        Map<Integer, String> map = new HashMap<>();
        int[] array = Arrays.copyOf(nums, nums.length);
        Arrays.sort(array);
        for (int num : array) {
            if (rank > 3) {
                map.put(num, String.valueOf(rank));
            } else if (rank == 3) {
                map.put(num, "Bronze Medal");
            } else if (rank == 2) {
                map.put(num, "Silver Medal");
            } else if (rank == 1) {
                map.put(num, "Gold Medal");
            }
            rank--;
        }
        String[] result = new String[nums.length];
        for (int i = 0; i < result.length; i++) {
            result[i] = map.get(nums[i]);
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
