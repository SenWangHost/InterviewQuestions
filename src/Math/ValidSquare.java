/**
 *
 */
package Math;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Given the coordinates of four points in 2D space, return whether the four points could construct a square.
 * The coordinate (x,y) of a point is represented by an integer array with two integers.
 *
 * Example:
 * Input: p1 = [0,0], p2 = [1,1], p3 = [1,0], p4 = [0,1]
 * Output: True
 * Note:
 * All the input integers are in the range [-10000, 10000].
 * A valid square has four equal sides with positive length and four equal angles (90-degree angles).
 * Input points have no order.
 * @author SenWang
 *
 */
public class ValidSquare {
    /**
     * This is my own solution to this question. The idea is that for
     * a square, there are two large length(diagonal), four smaller length(side).
     * @param p1 the array representing the first coordinate.
     * @param p2 the array representing the second coordinate.
     * @param p3 the array representing the third coordinate.
     * @param p4 the array representing the fourth coordinate.
     * @return true if those four points could form square, false otherwise.
     */
    public static boolean solution(int[] p1, int[] p2, int[] p3, int[] p4) {
        double len1 = length(p1, p2);
        double len2 = length(p2, p3);
        double len3 = length(p3, p4);
        double len4 = length(p4, p1);
        double len5 = length(p1, p3);
        double len6 = length(p2, p4);
        double[] length = {len1, len2, len3, len4, len5, len6};
        double max = 0;
        double min = Integer.MAX_VALUE;
        for (double side: length) {
            max = Math.max(side, max);
            min = Math.min(side, min);
        }
        int maxcount = 0;
        int nonmaxcount = 0;
        for (double side: length) {
            if (side == max) {
                maxcount++;
            }
            if (side == min) {
                nonmaxcount++;
            }
        }
        if (maxcount != 2 || nonmaxcount != 4) {
            return false;
        }
        return true;
    }
    /**
     * This is the helper function to calculate the length based on the coordinates
     * of two points.
     * @param p1 the coordinates of the first point.
     * @param p2 the coordinates of the second point.
     * @return the length of two points.
     */
    private static double length(int[] p1, int[] p2) {
        double result = (p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1]);
        result = Math.sqrt(result);
        return result;
    }
    /**
     * This is one of the reference solutions, which uses the same idea, but with a more compact
     * way to write using hashset.
     * @param p1 the array representing the first coordinate.
     * @param p2 the array representing the second coordinate.
     * @param p3 the array representing the third coordinate.
     * @param p4 the array representing the fourth coordinate.
     * @return true if those four points could form square, false otherwise.
     */
    public static boolean solutionRef(int[] p1, int[] p2, int[] p3, int[] p4) {
        Set<Double> set = new HashSet<Double>(Arrays.asList(length(p1, p2),
                length(p1, p3), length(p1, p4), length(p2, p3), length(p2, p4), length(p3, p4)));
        return !set.contains(0) && set.size() == 2;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] p1 = {1, 0};
        int[] p2 = {-1, 0};
        int[] p3 = {0, 1};
        int[] p4 = {0, -1};
        boolean result = ValidSquare.solutionRef(p1, p2, p3, p4);
        System.out.println(result);
    }

}
