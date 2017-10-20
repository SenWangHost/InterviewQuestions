/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author SenWang
 *
 */
public class IntersectionOfTwoArraysTwo {
    /**
     * this is my own solution to this question.
     */
    public static int[] solution(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0;
        int j = 0;
        List<Integer> result = new ArrayList<Integer>();
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j]) {
                i++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                result.add(nums1[i]);
                i++;
                j++;
            }
        }
        int[] res = new int[result.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = result.get(k);
        }
        return res;
    }
    /**
     * the reference solution use hash map to keep track of the frequency of each
     * element in the array, the time complexity would be O(n)
     */
    public static int[] solutionRef(int[] nums1, int[]nums2) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> result = new ArrayList<Integer>();
        for (int num : nums1) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        for (int num : nums2) {
            if (map.containsKey(num) && map.get(num) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] res = new int[result.size()];
        for (int k = 0; k < res.length; k++) {
            res[k] = result.get(k);
        }
        return res;
    }
    /**
     * This is the test function fot this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums1 = {1, 2, 2, 1};
        int[] nums2 = {2, 2};
        int[] result = solutionRef(nums1, nums2);
        for (int num : result) {
            System.out.println(num);
        }
    }

}
