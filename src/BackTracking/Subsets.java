/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.
 * Note: The solution set must not contain duplicate subsets.
 *
 * For example,
 * If nums = [1,2,3], a solution is:
 * [
 *  [3],
 *  [1],
 *  [2],
 *  [1,2,3],
 *  [1,3],
 *  [2,3],
 *  [1,2],
 *  []
 * ]
 * @author SenWang
 *
 */
public class Subsets {
    /**
     * This is my own solution to this question.
     * @param nums the input array of numbers to be considered.
     * @return a list containing all the subsets.
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
        for (int i = 0; i < nums.length; i++) {
            int size = result.size();
            for (int j = 0; j < size; j++) {
                List<Integer> oldList = result.get(j);
                List<Integer> newList = new ArrayList<Integer>(oldList);
                newList.add(nums[i]);
                result.add(newList);
            }
        }
        return result;
    }
    /**
     * This is one of the reference solution to this question, which
     * uses backtracking algorithm.
     * @param nums the input array of numbers to be considered.
     * @return a list containing all the subsets.
     */
    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), nums, 0);
        return result;
    }
    /**
     * This is the helper function for the backtracking solution above.
     * @param list the two dimensional list for storing the results.
     * @param tempList the temporary list for one subset.
     * @param nums the array of numbers to be considered.
     * @param start the start index for looping through the array.
     */
    private static void backTrack(List<List<Integer>> list, List<Integer> tempList, int[] nums, int start) {
        list.add(new ArrayList<Integer>(tempList));
        for (int i = start; i < nums.length; i++) {
            tempList.add(nums[i]);
            backTrack(list, tempList, nums, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3};
        List<List<Integer>> result = Subsets.solution2(test);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
