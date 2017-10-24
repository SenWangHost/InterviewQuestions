/**
 *
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n points in the plane that are all pairwise distinct, a "boomerang" is a tuple of points (i, j, k)
 * such that the distance between i and j equals the distance between i and k (the order of the tuple matters).
 * Find the number of boomerangs. You may assume that n will be at most 500 and coordinates of points are
 * all in the range [-10000, 10000] (inclusive).
 * Example:
 * Input:
 * [[0,0],[1,0],[2,0]]
 * Output:
 * 2
 * Explanation:
 * The two boomerangs are [[1,0],[0,0],[2,0]] and [[1,0],[2,0],[0,0]]
 * @author SenWang
 *
 */
public class NumberOfBoomerangs {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int[][] points) {
        int result = 0;
        for (int i = 0; i < points.length; i++) {
            Map<Integer, Integer> map = new HashMap<Integer, Integer>();
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    continue;
                }
                int dis = distance(points[i], points[j]);
                if (map.containsKey(dis)) {
                    map.put(dis, map.get(dis) + 1);
                } else {
                    map.put(dis, 1);
                }
            }
            // loop throug the map to find the number of points with the same distance
            for (int value : map.values()) {
                result += value * (value - 1);
            }
            map.clear();
        }
        return result;
    }
    /**
     * calcualte the distance between two points
     */
    private static int distance(int[] point1, int[] point2) {
        int diff1 = point1[0] - point2[0];
        int diff2 = point1[1] - point2[1];
        return diff1 * diff1 + diff2 * diff2;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
