/**
 *
 */
package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given numRows, generate the first numRows of Pascal's triangle.
 * For example, given numRows = 5,
 * Return
 * [
 *     [1],
 *    [1,1],
 *   [1,2,1],
 *  [1,3,3,1],
 * [1,4,6,4,1]
 * ]
 * @author SenWang
 *
 */
public class PascalTriangle {
    /**
     * This is my own solution for this question.
     * @param numRows the number of rows that the triangle would have
     * @return the pascal triangle
     */
    public static List<List<Integer>> solution(int numRows) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        for (int row = 0; row < numRows; row++) {
            List<Integer> line = new ArrayList<Integer>();
            if (row == 0) {
                line.add(1);
            } else {
                for (int col = 0; col <= row; col++) {
                    if (col == 0 || col == row) {
                        line.add(1);
                    } else {
                        line.add(result.get(row - 1).get(col - 1) + result.get(row - 1).get(col));
                    }
                }
            }
            result.add(line);
        }
        return result;
    }
    /**
     * The reference solution use the same algorithm as my own solution.
     * which is K(i)(j) = K(i - 1)(j - 1) + K(i - 1)(j), except for the first and last element.
     */
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int numRows = 7;
        List<List<Integer>> result = PascalTriangle.solution(numRows);
        Iterator<List<Integer>> rowIter = result.iterator();
        while (rowIter.hasNext()) {
            System.out.print("[");
            Iterator<Integer> colIter = rowIter.next().iterator();
            while (colIter.hasNext()) {
                System.out.print(colIter.next() + ", ");
            }
            System.out.print("]");
            System.out.println("");
        }
    }

}
