/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * Find all possible combinations of k numbers that add up to a number n, given that only numbers from 1
 * to 9 can be used and each combination should be a unique set of numbers.
 *
 * Example 1:
 * Input: k = 3, n = 7
 * Output:
 * [[1,2,4]]
 *
 * Example 2:
 * Input: k = 3, n = 9
 * Output:
 * [[1,2,6], [1,3,5], [2,3,4]]
 * @author SenWang
 *
 */
public class CombinationSumThree {
    /**
     * This is the recursive backtracking solution to this question.
     * @param k the number of integers used to reached the target
     * @param n the target sum to be reached.
     * @return two dimensional lists for storing the results.
     */
    public static List<List<Integer>> solution(int k, int n) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), 0, k, n, 1);
        return result;
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param result the two dimensional list for storing the results.
     * @param tempList the temporary for storing one result.
     * @param sum the current sum of the temporary list.
     * @param k the number of integers.
     * @param target the target sum to be reached.
     * @param start the start index for tracking the element.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int sum, int k, int target, int start) {
        if (sum > target) {
            return;
        }
        if (tempList.size() == k) {
            if (sum == target) {
                result.add(new ArrayList<Integer>(tempList));
            } else {
                return;
            }
        }
        for (int i = start; i < 10; i++) {
            tempList.add(i);
            sum += i;
            backTrack(result, tempList, sum, k, target, i + 1);
            tempList.remove(tempList.size() - 1);
            sum -= i;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int k = 3;
        int n = 9;
        List<List<Integer>> result = CombinationSumThree.solution(k, n);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }

}
