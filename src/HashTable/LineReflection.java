/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given n points on a 2D plane, find if there is such a line parallel to y-axis that reflect the given points.
 * Example 1:
 * Given points = [[1,1],[-1,1]], return true.
 * Example 2:
 * Given points = [[1,1],[-1,-1]], return false.
 * Follow up:
 * Could you do better than O(n^2)?
 * @author SenWang
 *
 */
public class LineReflection {
    /**
     * this is my own solution to this question, which uses hashmap to group the points
     * with the same y value.
     */
    public static boolean solution(int[][] points) {
        if (points == null || points.length == 0) {
            return true;
        }
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int[] point : points) {
            if (!map.containsKey(point[1])) {
                map.put(point[1], new ArrayList<Integer>());
            }
            List<Integer> temp = map.get(point[1]);
            if (!temp.contains(point[1])) {
                temp.add(point[0]);
            }
        }
        Double mid = null;
        for (List<Integer> list : map.values()) {
            Collections.sort(list);
            int start = 0;
            int end = list.size() - 1;
            while (start <= end && end >= 0 && start < list.size()) {
                double temp = (double) (list.get(start) + list.get(end)) / 2;
                if (mid == null) {
                    mid = temp;
                }
                if (mid != temp) {
                    return false;
                }
                start++;
                end--;
            }
        }
        return true;
    }
    /**
     * this is the reference solution to this question, a very smart solution
     */
    public static boolean solutionRef(int[][] points) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        Set<String> set = new HashSet<String>();
        for (int[] point : points) {
            max = Math.max(max, point[0]);
            min = Math.min(min, point[0]);
            String temp = point[0] + "a" + point[1];
            set.add(temp);
        }
        int sum = max + min;
        for (int[] point : points) {
            String temp = (sum - point[0]) + "a" + point[1];
            if (!set.contains(temp)) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double x = 1;
        double y = 2;
        double result = x / y;
        System.out.println(result);
    }

}
