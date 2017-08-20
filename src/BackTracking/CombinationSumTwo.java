/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of candidate numbers (C) and a target number (T), find all unique combinations in
 * C where the candidate numbers sums to T.
 * Each number in C may only be used once in the combination.
 *
 * Note:
 * 1. All numbers (including target) will be positive integers.
 * 2. The solution set must not contain duplicate combinations.
 * For example, given candidate set [10, 1, 2, 7, 6, 1, 5] and target 8,
 * A solution set is:
 * [
 *  [1, 7],
 *  [1, 2, 5],
 *  [2, 6],
 *  [1, 1, 6]
 * ]
 * @author SenWang
 *
 */
public class CombinationSumTwo {
    /**
     * This is the recursive backtracking solution to this question.
     * @param candidates the array of numbers to be considered.
     * @param target the target sum to be reached.
     * @return the two dimensional list containing the results.
     */
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        boolean[] used = new boolean[candidates.length];
        backTrack(result, new ArrayList<Integer>(), 0, target, candidates, used,0);
        return result;
    }
    /**
     * The recursive helper function for the backtracking solution above.
     * @param result the two dimensional lists for storing results.
     * @param tempList the temporary list for storing one result.
     * @param sum the current sum of the temporary list.
     * @param target the target sum to be reached.
     * @param nums the array of numbers to be considered.
     * @param start the starting index for tracking the element.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int sum, int target, int[] nums, boolean[] used,int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<Integer>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            if (used[i] || i > 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            sum += nums[i];
            backTrack(result, tempList, sum, target, nums, used, i + 1);
            tempList.remove(tempList.size() - 1);
            sum -= nums[i];
            used[i] = false;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {10, 1, 2, 7, 6, 1, 5};
        int target = 8;
        List<List<Integer>> result = CombinationSumTwo.solution(test, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
