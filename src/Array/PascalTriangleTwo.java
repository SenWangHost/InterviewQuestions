/**
 *
 */
package Array;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given an index k, return the kth row of the Pascal's triangle.
 * For example, given k = 3,
 * Return [1,3,3,1].
 * Note:
 * Could you optimize your algorithm to use only O(k) extra space?
 * @author SenWang
 *
 */
public class PascalTriangleTwo {
    /**
     * This is my own solution to this question. The idea comes from the reference solution.
     * The formula to calculate the element is the same: K(i)(j) = K(i - 1)(j - 1) + K(i - 1)(j)
     * but make use of the fact that arraylist is a dynamic array.
     * @param rowIndex the index of row in pascal triangle
     * @return the array list that belongs to the pascal triangle
     */
    public static List<Integer> solution(int rowIndex) {
        List<Integer> result = new ArrayList<Integer>();
        for(int i = 0;i < rowIndex + 1; i++) {
                result.add(1);
                for(int j = i - 1;j > 0; j--) {
                    result.set(j, result.get(j - 1) + result.get(j));
                }
        }
        return result;
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        List<Integer> result = PascalTriangleTwo.solution(7);
        Iterator<Integer> iter = result.iterator();
        System.out.print("[");
        while (iter.hasNext()) {
            System.out.print(iter.next() + ", ");
        }
        System.out.print("]");
    }

}
