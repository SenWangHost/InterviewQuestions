/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) (without duplicates) and a target number (T), find all unique
 * combinations in C where the candidate numbers sums to T.
 * The same repeated number may be chosen from C unlimited number of times.
 *
 * Note:
 * 1. All numbers (including target) will be positive integers.
 * 2. The solution set must not contain duplicate combinations.
 * For example, given candidate set [2, 3, 6, 7] and target 7,
 * A solution set is:
 * [
 *  [7],
 *  [2, 2, 3]
 * ]
 * @author SenWang
 *
 */
public class CombinationSum {
    /**
     * This is the recursive backtracking solution to this question.
     * @param candidates the array of candidate numbers to be considered.
     * @param target the target sum to be considered.
     * @return two dimensional list containing the result.
     */
    public static List<List<Integer>> solution(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        backTrack(result, new ArrayList<Integer>(), 0, candidates, target, 0);
        return result;
    }
    /**
     * This is the recursive helper function for the backtracking solution above.
     * @param result the two dimensional list to contain the result.
     * @param tempList the temporary list for storing one combination.
     * @param sum the sum of all elements in the temporary list.
     * @param nums the array of numbers to be considered.
     * @param target the target to be reached.
     * @param start the start index for searching elements.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int sum, int[] nums, int target, int start) {
        if (sum > target) {
            return;
        }
        if (sum == target) {
            result.add(new ArrayList<Integer>(tempList));
        }
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            sum += nums[i];
            backTrack(result, tempList, sum, nums, target, i);
            tempList.remove(tempList.size() - 1);
            sum -= nums[i];
        }
    }
    /**
     * This is the iterative solution to this question, which uses the idea of dynamic programming.
     * The main idea reminds an approach for solving coins/knapsack problem - to store the result
     * for all i < target and create the solution from them. For that for each t from 1 to our target
     * we try every candidate which is less or equal to t in ascending order.
     * For each candidate "c" we run through all combinations for target t-c starting with the value
     * greater or equal than c to avoid duplicates and store only ordered combinations.
     * @param candidates the array of candidate numbers to be considered.
     * @param target the target sum to be considered.
     * @return two dimensional list containing the result.
     */
    public static List<List<Integer>> solution2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<List<Integer>>> container = new ArrayList<List<List<Integer>>>();
        // builds the solution from 1 to target.
        for (int tempT = 1; tempT <= target; tempT++) {
            // current result set for the temporary target.
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            for (int i = 0; i < candidates.length && candidates[i] <= tempT; i++) {
                if (candidates[i] == tempT) {
                    tempResult.add(Arrays.asList(candidates[i]));
                } else if (candidates[i] < tempT) {
                    for (List<Integer> list : container.get(tempT - candidates[i] - 1)) {
                        if (candidates[i] <= list.get(0)) {
                            List<Integer> newList = new ArrayList<Integer>();
                            newList.add(candidates[i]);
                            newList.addAll(list);
                            tempResult.add(newList);
                        }
                    }
                }
            }
            container.add(tempResult);
        }
        return container.get(target - 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 3, 6, 7};
        int target = 7;
        List<List<Integer>> result = CombinationSum.solution2(test, target);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
