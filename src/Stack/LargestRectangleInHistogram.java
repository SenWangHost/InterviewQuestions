/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1,
 * find the area of largest rectangle in the histogram.
 *
 * For example,
 * Given heights = [2,1,5,6,2,3],
 * return 10.
 * @author SenWang
 *
 */
public class LargestRectangleInHistogram {
    /**
     * this is the reference solution to this question, using the stack
     */
    public static int solution(int[] height) {
        int length = height.length;
        Deque<Integer> stack = new ArrayDeque<Integer>();
        int maxArea = 0;
        for (int i = 0; i <= length; i++) {
            System.out.println(i);
            int h = 0;
            if (i < length) {
                h = height[i];
            }
            if (stack.isEmpty() || h >= height[stack.peek()]) {
                stack.push(i);
            } else {
                int top = stack.pop();
                int area = 0;
                if (stack.isEmpty()) {
                    area = height[top] * i;
                } else {
                    area = height[top] * (i - 1 - stack.peek());
                }
                maxArea = Math.max(maxArea, area);
                i--;
            }
        }
        return maxArea;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] height = {2,1,5,6,2,3};
        System.out.println(solution(height));
    }

}
