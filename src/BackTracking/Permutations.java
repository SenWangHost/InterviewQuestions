/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a collection of distinct numbers, return all possible permutations.
 * For example,
 * [1,2,3] have the following permutations:
 * [
 *  [1,2,3],
 *  [1,3,2],
 *  [2,1,3],
 *  [2,3,1],
 *  [3,1,2],
 *  [3,2,1]
 * ]
 * @author SenWang
 *
 */
public class Permutations {
    /**
     * This is the recursive backtracking solution to this question, originally use hashset to
     * remember the added element, but hashset remove will make the solution slow.
     * @param nums the array of numbers to be considered.
     * @return two dimensional list containing all possible permutations.
     */
    public static List<List<Integer>> solution(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), nums);
        return result;
    }
    /**
     * This is the helper function for the backtracking solution above.
     * @param result the two dimensional list containing the results.
     * @param tempList the temporary list for holding one permutation.
     * @param nums the array of numbers to be considered.
     * @param start the start index for tracking the element.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList,int[] nums) {
        if (tempList.size() == nums.length) {
            result.add(new ArrayList<Integer>(tempList));
        }
        for (int i = 0; i < nums.length; i++) {
            if (!tempList.contains(nums[i])) {
                tempList.add(nums[i]);
                backTrack(result, tempList, nums);
                tempList.remove(tempList.size() - 1);
            }
        }
    }
    /**
     * This is the iterative solution to this question, which uses hash set to
     * keep trak of the added element.
     * @param nums the array of numbers to be considered.
     * @return two dimensional list containing all possible permutations.
     */
    public static List<List<Integer>> solution2(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null) {
            return result;
        }
        if (nums.length == 0) {
            result.add(new ArrayList<Integer>());
            return result;
        }
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        result.add(temp);
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> new_result = new ArrayList<List<Integer>>();
            for (int j = 0; j <= i; j++) {
                for (List<Integer> list : result) {
                    List<Integer> new_list = new ArrayList<Integer>(list);
                    new_list.add(j, nums[i]);
                    new_result.add(new_list);
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
        int[] test = {1, 2, 3};
        List<List<Integer>> result = Permutations.solution2(test);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
