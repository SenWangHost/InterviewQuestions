/**
 *
 */
package Array;

import java.util.Arrays;

/**
 * @author SenWang
 *
 */
public class ThreeSumClosest {
    /**
     * this is my own solution to this question, which is quite similar to the 3 sum question.
     * The time complexity would be O(n ^ 2)
     */
    public static int solution(int[] nums, int target) {
        int dist = Integer.MAX_VALUE;
        int result = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length - 2; i++) {
            int sum = target - nums[i];
            int j = i + 1;
            int k = nums.length - 1;
            int add = 0;
            while (j < k) {
                add = nums[j] + nums[k];
                if (add == sum) {
                    return add + nums[i];
                }
                if (add < sum) {
                    j++;
                } else {
                    k--;
                }
                // update distance and result.
                if (Math.abs(sum - add) < dist) {
                    dist = Math.abs(sum - add);
                    result = add + nums[i];
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
