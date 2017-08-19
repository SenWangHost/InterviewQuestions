/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 * For example,
 * If nums = [1,2,2], a solution is:
 * [
 *  [2],
 *  [1],
 *  [1,2,2],
 *  [2,2],
 *  [1,2],
 *  []
 * ]
 * @author SenWang
 *
 */
public class SubsetsTwo {
    /**
     * This is my own solution to this question.
     * @param nums the array of numbers to be considered.
     * @return a list containing all possible subsets.
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        result.add(new ArrayList<Integer>());
        if (nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        // use size variable to keep track of the number of elements
        // that are newly inserted.
        int size = 0;
        int startIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i >= 1 && nums[i] == nums[i - 1]) {
                startIndex = size;
            } else {
                startIndex = 0;
            }
            size = result.size();
            for (int j = startIndex; j < size; j++) {
                List<Integer> oldList = result.get(j);
                List<Integer> newList = new ArrayList<Integer>(oldList);
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
    /**
     * This is the recursive solution which uses backtracking algorithm
     * to reach all the possible subsets
     * @param nums the array of numbers to be considered.
     * @return a list containing all possible subsets.
     */
    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        backTrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    /**
     * This is the helper function for the backtracking solution above.
     * @param result the two dimensional list for storing the results.
     * @param tempList the tempList for holding the subset.
     * @param nums the array of numbers to be considered.
     * @param start the start index for tracking the element.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, int start) {
        result.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < nums.length; i++) {
            if (i > start && nums[i - 1] == nums[i]) {
                continue;
            }
            tempList.add(nums[i]);
            backTrack(result, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    /**
     * This is the test function for this question,
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 2};
        List<List<Integer>> result = SubsetsTwo.solution2(test);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
