/**
 *
 */
package Array;

/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * Note:
 * You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
 * The number of elements initialized in nums1 and nums2 are m and n respectively.
 * @author SenWang
 *
 */
public class MergeSortedArray {
    /**
     * This is my own solution to this problem. Make use of standard merge sort method.
     * This solution is acceptable and runtime complexity is O(n) but complicated.
     * @param nums1 the first array of numbers to be considered.
     * @param m the number of elements in the first array.
     * @oaram nums2 the second array of numbers to be considered.
     * @param n the number of elements in the second array.
     */
    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int[] temp = new int[m + n];
        int index1 = 0;
        int index2 = 0;
        int indexM = 0;
        while (index1 < m && index2 < n) {
            if (nums1[index1] < nums2[index2]) {
                temp[indexM] = nums1[index1];
                index1++;
            } else {
                temp[indexM] = nums2[index2];
                index2++;
            }
            indexM++;
        }
        // copy the rest of elements into the temp array
        while (index1 < m) {
            temp[indexM++] = nums1[index1++];
        }
        while (index2 < n) {
            temp[indexM++] = nums2[index2++];
        }
        // copy the temp element into the array 1
        for (int i = 0; i < m + n; i++) {
            nums1[i] = temp[i];
        }
    }
    /**
     * This is one optimized solution for this question. It merges the array from end to
     * the beginning because the end of array 1 would be always be empty. Also, the length
     * of array 1 would be always be larger than array 2. The runtime complexity is the same
     * as my own solution.
     * @param nums1 the first array of numbers to be considered.
     * @param m the number of elements in the first array.
     * @oaram nums2 the second array of numbers to be considered.
     * @param n the number of elements in the second array.
     */
    public static void solutionRef(int[] nums1, int m, int[] nums2, int n) {
        int index1 = m - 1;
        int index2 = n - 1;
        int indexM = m + n - 1;
        while (index1 >= 0 && index2 >= 0) {
            if (nums1[index1] > nums2[index2]) {
                nums1[indexM] = nums1[index1];
                index1--;
            } else {
                nums1[indexM] = nums2[index2];
                index2--;
            }
            indexM--;
        }
        // copy the rest of element in array 2 into the array 1
        // no need to copy element in array 1
        while (index2 >= 0) {
            nums1[indexM--] = nums2[index2--];
        }
    }
    /**
     * This is the test function for this problem.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums1 = {1, 3, 5, 7, 0, 0};
        int[] nums2 = {2, 6};
        MergeSortedArray.solutionRef(nums1, 4, nums2, 2);
        for (int i = 0; i < nums1.length; i++) {
            System.out.println(nums1[i]);
        }
    }

}
