/**
 *
 */
package DynamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to
 * adjacent numbers on the row below.
 * For example, given the following triangle
 * [
 *     [2],
 *    [3,4],
 *   [6,5,7],
 *  [4,1,8,3]
 * ]
 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
 * Note:
 * Bonus point if you are able to do this using only O(n) extra space, where n is the total
 *  number of rows in the triangle.
 * @author SenWang
 *
 */
public class Triangle {
    /**
     * This is my own solution to this question, it is acceptable but runs slowly.
     * @param triangle the two dimensional list representing the numbers.
     * @return the minimum path sum from top to bottom.
     */
    public static int solution(List<List<Integer>> triangle) {
        int row = triangle.size();
        for (int i = 1; i < row; i++) {
            List<Integer> prevList = triangle.get(i - 1);
            List<Integer> currList = triangle.get(i);
            for (int j = 0; j < currList.size(); j++) {
                if (j == 0) {
                    currList.set(j, prevList.get(j) + currList.get(j));
                } else if (j == currList.size() - 1) {
                    currList.set(j, prevList.get(j - 1) + currList.get(j));
                } else {
                    currList.set(j, Math.min(prevList.get(j - 1), prevList.get(j)) + currList.get(j));
                }
            }
        }
        int result = Integer.MAX_VALUE;
        for (int num : triangle.get(row - 1)) {
            result = Math.min(result, num);
        }
        return result;
    }
    /**
     * This is the reference solution, which uses bottom up dynamic programming method.
     * @param triangle the two dimensional list representing the numbers.
     * @return the minimum path sum from top to bottom.
     */
    public static int solutionRef(List<List<Integer>> triangle) {
        int[] dp = new int[triangle.size() + 1];
        for(int i = triangle.size() - 1;i >= 0; i--){
            for(int j = 0;j < triangle.get(i).size(); j++){
                dp[j] = Math.min(dp[j],dp[j+1]) + triangle.get(i).get(j);
            }
        }
        return dp[0];
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<List<Integer>> triangle = new ArrayList<List<Integer>>();
        List<Integer> row1 = new ArrayList<Integer>();
        row1.add(-1);
        List<Integer> row2 = new ArrayList<Integer>();
        row2.add(2);
        row2.add(3);
        List<Integer> row3 = new ArrayList<Integer>();
        row3.add(1);
        row3.add(-1);
        row3.add(-1);
        triangle.add(row1);
        triangle.add(row2);
        triangle.add(row3);
        System.out.println(Triangle.solution(triangle));
    }

}
