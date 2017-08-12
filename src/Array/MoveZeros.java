/**
 *
 */
package Array;

/**
 * Given an array nums, write a function to move all 0's to the end of it while
 * maintaining the relative order of the non-zero elements.
 * For example, given nums = [0, 1, 0, 3, 12], after calling your function, nums should be [1, 3, 12, 0, 0].
 * @author SenWang
 *
 */
public class MoveZeros {
    /**
     * This is my own solution for this question. This solution is acceptable but the
     * runtime complexity is not good.
     * @param nums the array of numbers to be considered.
     */
    public static void solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                for (int j = i + 1; j < nums.length; j++) {
                    if (nums[j] != 0) {
                        nums[i] = nums[j];
                        nums[j] = 0;
                        break;
                    }
                }
            }
        }
    }
    /**
     * This is another solution of mine, which makes use of inserted position.
     * @param nums the array of numbers to be considered.
     */
    public static void solution2(int[] nums) {
        int insertPosition = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                nums[insertPosition] = nums[i];
                insertPosition++;
            }
        }
        // fill the rest of position with zeros
        while (insertPosition < nums.length) {
            nums[insertPosition] = 0;
            insertPosition++;
        }
    }
    /**
     * This is the reference solution for this question, which makes use of two pointers.
     * @param nums the array of numbers to be considered.
     */
    public static void solutionRef(int[] nums) {
        int zeroPointer = 0;
        for (int i = 0 ; i < nums.length; i++) {
            if (nums[i] != 0) {
                int zeroElement = nums[zeroPointer];
                nums[zeroPointer] = nums[i];
                nums[i] = zeroElement;
                zeroPointer++;
            }
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {0, 0, 0, 0, 0, 0, 1};
        MoveZeros.solutionRef(test);
        for (int i = 0; i < test.length; i++) {
            System.out.print(test[i] + ", ");
        }
    }

}
