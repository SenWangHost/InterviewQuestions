/**
 *
 */
package Tree;

import java.util.HashMap;
import java.util.Map;
import java.util.NavigableSet;
import java.util.TreeSet;

/**
 * Given an array of integers, find out whether there are two distinct indices i and j in the array such that the
 * absolute difference between nums[i] and nums[j] is at most t and the absolute difference between i and j is at most k.
 * @author SenWang
 *
 */
public class ContainDuplicateThree {
    /**
     * This is reference solution to this question, which makes use of binary search tree, namely,
     * the tree set data structure in java.
     * @param nums the array of numbers to be considered.
     * @param k the maximum absolute distance that two indices could have.
     * @param t the maximum absolute distance that two numbers could have.
     * @return true if such pair exists, else otherwise.
     */
    public static boolean solutionRef(int[] nums, int k, int t) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return false;
        }
        NavigableSet<Long> tree = new TreeSet<Long>();
        for (int i = 0; i < nums.length; i++) {
            Long ceil = tree.ceiling((long) (nums[i] - k));
            Long floor = tree.floor((long) (nums[i] + k));
            if (ceil != null && ceil <= nums[i]) {
                return true;
            }
            if (floor != null && floor >= nums[i]) {
                return true;
            }
            tree.add((long) nums[i]);
            if (i >= k) {
                tree.remove((long) nums[i - k]);
            }
        }
        return false;
    }
    /**
     * This is the helper function for the second reference solution.
     * @param i
     * @param w
     * @return
     */
    private static long getID(long i, long w) {
        return i < 0 ? (i + 1) / w - 1 : i / w;
    }
    /**
     * This is another reference solution for this question, which uses the idea of
     * bucket sort.
     * @param nums the array of numbers to be considered.
     * @param k the maximum absolute distance that two indices could have.
     * @param t the maximum absolute distance that two numbers could have.
     * @return true if such pair exists, else otherwise.
     */
    public static boolean solutionRef2(int[] nums, int k, int t) {
        if (t < 0) return false;
        Map<Long, Long> d = new HashMap<>();
        long w = (long)t + 1;
        for (int i = 0; i < nums.length; ++i) {
            long m = getID(nums[i], w);
            if (d.containsKey(m))
                return true;
            if (d.containsKey(m - 1) && Math.abs(nums[i] - d.get(m - 1)) < w)
                return true;
            if (d.containsKey(m + 1) && Math.abs(nums[i] - d.get(m + 1)) < w)
                return true;
            d.put(m, (long)nums[i]);
            if (i >= k) d.remove(getID(nums[i - k], w));
        }
        return false;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {2, 0, 3, 4, 5};
        boolean result = ContainDuplicateThree.solutionRef(test, 1, 2);
        System.out.println(result);
    }

}
