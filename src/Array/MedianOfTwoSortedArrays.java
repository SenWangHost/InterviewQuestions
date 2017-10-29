/**
 *
 */
package Array;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity should be O(log (m+n)).
 *
 * Example 1:
 * nums1 = [1, 3]
 * nums2 = [2]
 * The median is 2.0
 *
 * Example 2:
 * nums1 = [1, 2]
 * nums2 = [3, 4]
 * The median is (2 + 3)/2 = 2.5
 * @author SenWang
 *
 */
public class MedianOfTwoSortedArrays {
    /**
     * this is my own solution to this question, which is O(m + n) time complexity
     */
    public static double solution(int[] nums1, int[] nums2) {
        int[] combine = new int[nums1.length + nums2.length];
        int i = 0;
        int j = 0;
        int index = 0;
        while (index < combine.length) {
            if (i < nums1.length && j < nums2.length) {
                if (nums1[i] < nums2[j]) {
                    combine[index] = nums1[i];
                    i++;
                } else {
                    combine[index] = nums2[j];
                    j++;
                }
            } else if (i < nums1.length) {
                combine[index] = nums1[i];
                i++;
            } else if (j < nums2.length) {
                combine[index] = nums2[j];
                j++;
            }
            index++;
        }
        if (combine.length % 2 == 1) {
            return combine[combine.length / 2];
        } else {
            double result = (double) (combine[combine.length / 2] + combine[combine.length / 2 - 1]) / 2;
            return result;
        }
    }
    /**
     * this is one of the reference solution to this question.
     */
    public static double solutionRef(int[] A, int[] B) {
        int m = A.length, n = B.length;
        int l = (m + n + 1) / 2;
        int r = (m + n + 2) / 2;
        return (getkth(A, 0, B, 0, l) + getkth(A, 0, B, 0, r)) / 2.0;
    }
    /**
     *
     * @param A
     * @param aStart
     * @param B
     * @param bStart
     * @param k
     * @return
     */
    public static double getkth(int[] A, int aStart, int[] B, int bStart, int k) {
        if (aStart > A.length - 1) return B[bStart + k - 1];
        if (bStart > B.length - 1) return A[aStart + k - 1];
        if (k == 1) return Math.min(A[aStart], B[bStart]);

        int aMid = Integer.MAX_VALUE, bMid = Integer.MAX_VALUE;
        if (aStart + k/2 - 1 < A.length) aMid = A[aStart + k/2 - 1];
        if (bStart + k/2 - 1 < B.length) bMid = B[bStart + k/2 - 1];

        if (aMid < bMid)
            return getkth(A, aStart + k/2, B, bStart,       k - k/2);// Check: aRight + bLeft
        else
            return getkth(A, aStart,       B, bStart + k/2, k - k/2);// Check: bRight + aLeft
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
