/**
 *
 */
package DynamicProgramming;

/**
 * Given an integer array nums, find the sum of the elements between indices i and j (i ≤ j), inclusive.
 * Example:
 * Given nums = [-2, 0, 3, -5, 2, -1]
 * sumRange(0, 2) -> 1
 * sumRange(2, 5) -> -1
 * sumRange(0, 5) -> -3
 * Note:
 * 1. You may assume that the array does not change.
 * 2. There are many calls to sumRange function.
 * @author SenWang
 *
 */
public class RangeSumQueryImmutable {
    /**
     * This is my own implementation for this question.
     * @author SenWang
     */
    public static class NumArray {
        /**
         * a double dimensional array for storing the results.
         */
        private int sum;
        /**
         * the start index.
         */
        private int start;
        /**
         * the end index.
         */
        private int end;
        /**
         * to store the array
         */
        private int[] array;
        /**
         * The constructor for this number array.
         * @param nums the array of numbers to be considered.
         */
        public NumArray(int[] nums) {
            array = nums;
            sum = nums[0];
            start = 0;
            end = 0;
        }
        /**
         * The method to calculate the range sum.
         * @param i the starting index.
         * @param j the ending index.
         * @return the sum ranging from i to j
         */
        public int sumRange(int i, int j) {
            if (j > end) {
                for (int index = end + 1; index <= j; index++) {
                    sum += array[index];
                }
                end = j;
            }
            if (j < end) {
                for (int index = end; index > j; index--) {
                    sum -= array[index];
                }
                end = j;
            }
            if (i < start) {
                for (int index = start - 1; index >= i; index--) {
                    sum += array[index];
                }
                start = i;
            }
            if (i > start) {
                for (int index = start; index < i; index++) {
                    sum -= array[index];
                }
                start = i;
            }
            return sum;
        }
    }
    /**
     * This is my own implementation for this question.
     * @author SenWang
     */
    public static class NumArrayRef {
        private int[] array;
        /**
         * The constructor for this number array.
         * @param nums the array of numbers to be considered.
         */
        public NumArrayRef(int[] nums) {
            array = nums;
            for (int i = 1; i < nums.length; i++) {
                array[i] += array[i - 1];
            }
        }
        /**
         * The method to calculate the range sum.
         * @param i the starting index.
         * @param j the ending index.
         * @return the sum ranging from i to j
         */
        public int sumRange(int i, int j) {
            if (i == 0) {
                return array[j];
            }
            return array[j] - array[i - 1];
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {-2, 0, 3, -5, 2, -1};
        NumArray test = new NumArray(nums);
        System.out.println(test.sumRange(0, 2));
        System.out.println(test.sumRange(2, 5));
        System.out.println(test.sumRange(0, 5));
    }

}
