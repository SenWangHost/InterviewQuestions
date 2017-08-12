/**
 *
 */
package Array;

/**
 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
 * then the whole array will be sorted in ascending order, too.
 * You need to find the shortest such subarray and output its length.
 *
 * Example 1:
 * Input: [2, 6, 4, 8, 10, 9, 15]
 * Output: 5
 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
 *
 * Note:
 * Then length of the input array is in range [1, 10,000].
 * The input array may contain duplicates, so ascending order here means <=.
 * @author SenWang
 *
 */
public class FindUnsortedSubarray {
    /**
     * This is my own solution for this question.
     * @param nums the array of numbers to be considered.
     * @return the shortest length of subarray that you need to sort it in ascending order.
     */
    public static int solution(int[] nums) {
        int head = 0;
        int tail = 0;
        for (int i = 0; i < nums.length; i++) {
            int prev = Integer.MIN_VALUE;
            int next = Integer.MAX_VALUE;
            if (i - 1 >= 0) {
                prev = nums[i - 1];
            }
            if (i + 1 < nums.length) {
                next = nums[i + 1];
            }
            if (nums[i] >= prev && nums[i] >= next && head == 0) {
                head = i;
            }
            if (nums[i] <= prev && nums[i] <= next) {
                tail = i;
            }
        }
        System.out.println(head);
        System.out.println(tail);
        if (head == 0 && tail == 0) {
            return 0;
        }
        if (nums[head] == nums[tail]) {
            return 0;
        }
        return tail - head + 1;
    }
    /**
     * This is the reference solution for this question.
     * @param nums the array of numbers to be considered.
     * @return the shortest length of subarray that you need to sort it in ascending order.
     */
    public static int solutionRef(int[] nums) {
        int size = nums.length;
        int head = -1;
        int tail = -2;
        int max = nums[0];
        int min = nums[size - 1];
        for (int i = 1; i < size; i++) {
            max = Math.max(max, nums[i]);
            min = Math.min(min, nums[size - 1 - i]);
            if (nums[i] < max) {
                tail = i;
            }
            if (nums[size - 1 - i] > min) {
                head = size - 1 - i;
            }
        }
        if (tail < head && head < 0) {
            return 0;
        }
        return tail - head + 1;
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 3, 2, 2, 2};
        int result = FindUnsortedSubarray.solutionRef(test);
        System.out.println(result);
    }

}
