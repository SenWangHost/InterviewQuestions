/**
 *
 */
package Array;

/**
 * Given an array and a value, remove all instances of that value in place and return the new length.
 * Do not allocate extra space for another array, you must do this in place with constant memory.
 * The order of elements can be changed. It doesn't matter what you leave beyond the new length.
 *
 * Example:
 * Given input array nums = [3,2,2,3], val = 3
 * Your function should return length = 2, with the first two elements of nums being 2.
 * @author SenWang
 *
 */
public class RemoveElement {
    /**
     * This is my own solution for this question. This solution is acceptable but the runtime complexity is not so good.
     * @param nums the array of numbers to be examined.
     * @param val the val to be removed.
     * @return the length of the array after all the instances of val are removed.
     */
    public int solution(int[] nums, int val) {
        int size = nums.length;
        for (int i = 0; i < size; i++) {
            if (nums[i] == val) {
                for (int j = i; j < size - 1; j++) {
                    nums[j] = nums[j + 1];
                }
                size -= 1;
                i -= 1;
            }
        }
        return size;
    }
    /**
     * This is the reference solution for this question.
     * @param nums the array of numbers to be examined.
     * @param val the val to be removed.
     * @return the length of the array after all the instances of val are removed.
     */
    public int solutionRef(int[] nums, int val) {
        int index = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) {
                nums[index] = nums[i];
                index++;
            }
        }
        return index + 1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        RemoveElement test = new RemoveElement();
        int nums[] = {3, 3, 4, 2};
        int result = test.solution(nums, 3);
        System.out.println(result);
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }

    }

}
