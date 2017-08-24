/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
 * For example,
 * If n = 4 and k = 2, a solution is:
 * [
 *  [2,4],
 *  [3,4],
 *  [2,3],
 *  [1,2],
 *  [1,3],
 *  [1,4],
 * ]
 * @author SenWang
 *
 */
public class Combinations {
    /**
     * This is recursive backtracking solution to this question.
     * @param n the numbers from 1 to n.
     * @param k the number of integers to use.
     * @return two dimensional lists containing all possible combinations.
     */
    public static List<List<Integer>> solution(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, new ArrayList<Integer>(), n, k, 1);
        return result;
    }
    /**
     * This is the recursive helper function to the solution above.
     * @param result the two dimensional lists containing the results.
     * @param tempList the tempList holding one result.
     * @param n the numbers from 1 to n.
     * @param k the number of integers to uses.
     * @param start the starting number for tracking the element.
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> tempList, int n, int k, int start) {
        if (tempList.size() == k) {
            result.add(new ArrayList<Integer>(tempList));
            return;
        }
        for (int i = start; i <= n; i++) {
            tempList.add(i);
            backTrack(result, tempList, n, k, i + 1);
            tempList.remove(tempList.size() - 1);
        }
    }
    /**
     * This is the iterative solution to this question, which is based on the idea of dynamic programming.
     * @param n the numbers from 1 to n.
     * @param k the number of integers to use.
     * @return two dimensional lists containing all possible combinations.
     */
    public static List<List<Integer>> solution2(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int i = 1; i <= n; i++) {
            result.add(Arrays.asList(i));
        }
        // loop through number 1 result to number k result.
        for (int size = 2; size <= k; size++) {
            List<List<Integer>> newResult = new ArrayList<List<Integer>>();
            for (int start = size; start <= n; start++) {
                for (List<Integer> list : result) {
                    if (list.get(list.size() - 1) < start) {
                        List<Integer> newList = new ArrayList<Integer>(list);
                        newList.add(start);
                        newResult.add(newList);
                    }
                }
            }
            result = newResult;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int n = 4;
        int k = 2;
        List<List<Integer>> result = Combinations.solution2(n, k);
        for (List<Integer> list : result) {
            System.out.println(list);
        }
    }
}
