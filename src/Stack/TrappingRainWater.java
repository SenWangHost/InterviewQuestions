/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 *
 * For example,
 * Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * @author SenWang
 *
 */
public class TrappingRainWater {
    /**
     * this is one of the reference solution to this question, which uses stack. This algorithm
     * is very similar to the largest rectangle in histogram.
     */
    public static int solution(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int i = 0;
        int maxWater = 0;
        int maxBottomWater = 0;
        while (i < height.length) {
            if (stack.isEmpty() || height[i] <= height[stack.peek()]) {
                stack.push(i);
                i++;
            } else {
                int bottom = stack.pop();
                if (stack.isEmpty()) {
                    maxBottomWater = 0;
                } else {
                    maxBottomWater = (Math.min(height[stack.peek()], height[i]) - height[bottom] ) * (i - 1 - stack.peek());
                    maxWater += maxBottomWater;
                }
            }
        }
        return maxWater;
    }
    /**
     * this is another reference solution to this question, which uses
     * two pointers to traverse from two sides to the middle.
     */
    public static int solution2(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1;
        while (left < right && height[left] <= height[left + 1]) {
            left++;
        }
        while (left < right && height[right] <= height[right - 1]) {
            right--;
        }
        int result = 0;
        while (left < right) {
            int lheight = height[left];
            int rheight = height[right];
            if (lheight <= rheight) {
                // add the water volume
                while (left < right && lheight >= height[++left]) {
                    result += (lheight - height[left]);
                }
            } else {
                // add the water volume
                while (left < right && height[right--] <= rheight) {
                    result += (rheight - height[right]);
                }
            }
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
