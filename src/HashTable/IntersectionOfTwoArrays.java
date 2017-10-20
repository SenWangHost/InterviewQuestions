/**
 *
 */
package HashTable;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/**
 * Given two arrays, write a function to compute their intersection.
 * Example:
 * Given nums1 = [1, 2, 2, 1], nums2 = [2, 2], return [2].
 * Note:
 * Each element in the result must be unique.
 * The result can be in any order.
 * @author SenWang
 *
 */
public class IntersectionOfTwoArrays {
    /**
     * this is my own solution to this question.
     */
    public static int[] solution(int[] nums1, int[] nums2) {
        Set<Integer> result = new HashSet<Integer>();
        Set<Integer> set = new HashSet<Integer>();
        for (int num : nums1) {
            if (!set.contains(num)) {
                set.add(num);
            }
        }
        for (int num : nums2) {
            if (set.contains(num) && !result.contains(num)) {
                result.add(num);
            }
        }
        Iterator<Integer> iter = result.iterator();
        int[] res = new int[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = iter.next();
        }
        return res;
    }
    /**
     * this is one of the reference solutio to this question, which sort two arrays
     * and use two pointers.
     */
    public static int[] solutionRef(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        Set<Integer> set = new HashSet<Integer>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                set.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] result = new int[set.size()];
        int k = 0;
        for (Integer num : set) {
            result[k++] = num;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solutionRef(nums1, nums2);
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

}
