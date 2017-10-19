/**
 *
 */
package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * Note: The solution set must not contain duplicate triplets.
 * For example, given array S = [-1, 0, 1, 2, -1, -4],
 * A solution set is:
 * [
 *  [-1, 0, 1],
 *  [-1, -1, 2]
 * ]
 * @author SenWang
 *
 */
public class ThreeSum {
    /**
     * this is my own solution to this question. remember to skip the same result.
     */
    public static List<List<Integer>> solution(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 0; i < nums.length - 2; i++) {
            int target = -nums[i];
            if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
                int start = i + 1;
                int end = nums.length - 1;
                while (start < end) {
                    int sum = nums[start] + nums[end];
                    if (sum > target) {
                        end--;
                    } else if (sum < target) {
                        start++;
                    } else {
                        List<Integer> temp = new ArrayList<Integer>();
                        temp.add(nums[i]);
                        temp.add(nums[start]);
                        temp.add(nums[end]);
                        result.add(temp);
                        while (start < end && nums[start] == nums[start + 1]) {
                            start++;
                        }
                        while (start < end && nums[end] == nums[end - 1]) {
                            end--;
                        }
                        start++;
                        end--;
                    }
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
        int[] nums = {-1, 0, 1, 2, -1, -4};
        List<List<Integer>> result = solution(nums);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
