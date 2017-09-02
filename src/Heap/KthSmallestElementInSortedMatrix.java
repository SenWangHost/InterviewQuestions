/**
 *
 */
package Heap;

import java.util.Map;
import java.util.TreeMap;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Example:
 * matrix =
 * [
 *  [ 1,  5,  9],
 *  [10, 11, 13],
 *  [12, 13, 15]
 * ],
 * k = 8,
 * return 13.
 * Note:
 * You may assume k is always valid, 1 ≤ k ≤ n2
 * @author SenWang
 *
 */
public class KthSmallestElementInSortedMatrix {
    /**
     * This is my own solution to this question, which adds all the element into
     * the heap.
     * @param matrix the sorted matrix reprensented by two dimensional array.
     * @param k the kth smallest element.
     * @return the kth smallest element.
     */
    public static int solution(int[][] matrix, int k) {
        TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
        int row = matrix.length;
        int col = matrix[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                map.put(matrix[i][j], map.getOrDefault(matrix[i][j], 0) + 1);
            }
        }
        int count = 0;
        while (count < k) {
            Map.Entry<Integer, Integer> entry = map.pollFirstEntry();
            count += entry.getValue();
            if (count >= k) {
                return entry.getKey();
            }
        }
        return 0;
    }
    /**
     * This is the reference solution to this question, which uses binary search on
     * each row and count the number that is less than the mid element.
     * @param matrix the sorted matrix reprensented by two dimensional array.
     * @param k the kth smallest element.
     * @return the kth smallest element.
     */
    public static int solutionRef(int[][] matrix, int k) {
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = matrix[0][0];
        int hi = matrix[row - 1][col - 1] + 1;
        while (lo < hi) {
            int mid = lo + (hi - lo) / 2;
            int count = 0;
            for (int i = 0; i < row; i++) {
                int j = col - 1;
                while (j >= 0 && matrix[i][j] > mid) {
                    j--;
                }
                count += (j + 1);
            }
            if (count < k) {
                lo = mid + 1;
            } else {
                hi = mid;
            }
        }
        return lo;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[][] matrix = {{1,  5,  9}, {4, 7, 10}, {12, 13, 15}};
        int k = 2;
        int result = KthSmallestElementInSortedMatrix.solutionRef(matrix, k);
        System.out.println(result);
    }

}
