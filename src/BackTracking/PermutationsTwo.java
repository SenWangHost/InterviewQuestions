/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.
 * For example,
 * [1,1,2] have the following unique permutations:
 * [
 *  [1,1,2],
 *  [1,2,1],
 *  [2,1,1]
 * ]
 * @author SenWang
 *
 */
public class PermutationsTwo {
    /**
     * This is the recursive backtracking solution to this question.
     * @param nums the array of numbers to be considered.
     * @return two dimensional lists contain all possible permutations.
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        boolean[] used = new boolean[nums.length];
        backTrack(result, new ArrayList<Integer>(), nums, used);
        return result;
    }
    /**
     * This is the recursive helper function for the solution above.
     * @param result the two dimensional list for storing the results.
     * @param tempList the temporary list for storing one permutations.
     * @param nums the array of numbers to be considered
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int[] nums, boolean[] used) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<Integer>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (used[i] || i != 0 && nums[i - 1] == nums[i] && used[i - 1] == false) {
                continue;
            }
            used[i] = true;
            tempList.add(nums[i]);
            backTrack(result, tempList, nums, used);
            tempList.remove(tempList.size() - 1);
            used[i] = false;

        }
    }
    /**
     * This is the iterative solution to this question, the idea is based on
     * insert the upcoming element into different positions.
     * @param nums the array of numbers to be considered.
     * @return two dimensional lists contain all possible permutations.
     */
    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        result.add(temp);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> new_result = new ArrayList<List<Integer>>();
            Set<String> set = new HashSet<String>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> list : result) {
                    List<Integer> new_list = new ArrayList<Integer>(list);
                    new_list.add(j, nums[i]);
                    if (set.add(new_list.toString())) {
                        new_result.add(new_list);
                    }
                }
            }
            result = new_result;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 1, 2};
        List<List<Integer>> result = PermutationsTwo.solution2(test);
        System.out.println(result.size());
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
