/**
 *
 */
package Array;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai).
 * n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0).
 * Find two lines, which together with x-axis forms a container, such that the container contains the most water.
 * Note: You may not slant the container and n is at least 2.
 * @author SenWang
 *
 */
public class ContainerWithMostWater {
    /**
     * This is the reference solution to this question. The detailed reasoning of this
     * algorithm is on leetcode.
     * @param height an array of integers representing the height.
     * @return the maximum area for containing the water.
     */
    public static int solution(int[] height) {
        int max = 0;
        int low = 0;
        int high = height.length - 1;
        while (low < high) {
            max = Math.max(max, Math.min(height[low], height[high]) * (high - low));
            if (height[low] < height[high]) {
                low++;
            } else {
                high--;
            }
        }
        return max;
    }
    /**
     * This is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] height = {1, 2, 3};
        System.out.println(ContainerWithMostWater.solution(height));
    }

}
