/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

/**
 * Given a non-empty array of integers, return the top k most frequent elements.
 * For example,
 * Given [1,1,1,2,2,3] and k = 2, return [1,2].
 *
 * Note:
 * You may assume k is always valid, 1 ? k ? number of unique elements.
 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
 * @author SenWang
 *
 */
public class TopKFrequentElements {
    /**
     * This is the reference solution to this question, which uses bucket sort.
     * @param nums the array of numbers to be considered.
     * @param k the limit for frequency
     * @return a list of integer of the k most frequent elements.
     */
    public static List<Integer> solutionRef(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        List<Integer> numList = new ArrayList<Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
                numList.add(num);
            }
        }
        @SuppressWarnings("unchecked")
        List<Integer>[] bucket = new List[nums.length + 1];
        for (int key : numList) {
            int fre = map.get(key);
            if (bucket[fre] == null) {
                bucket[fre] = new ArrayList<Integer>();
            }
            bucket[fre].add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        for (int i = nums.length; i >= 0 && result.size() < k; i--) {
            if (bucket[i] != null) {
                result.addAll(bucket[i]);
            }
        }
        return result;
    }
    /**
     * This is another reference solution to this question, which uses tree map to
     * sort and find the top k most frequent element.
     * @param nums the array of numbers to be considered.
     * @param k the limit for frequency.
     * @return a list of integer of the k most frequent elements.
     */
    public static List<Integer> solutionRef2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        TreeMap<Integer, List<Integer>> treeMap = new TreeMap<Integer, List<Integer>>();
        for (int key : map.keySet()) {
            int fre = map.get(key);
            if (!treeMap.containsKey(fre)) {
                treeMap.put(fre, new ArrayList<Integer>());
            }
            treeMap.get(fre).add(key);
        }
        List<Integer> result = new ArrayList<Integer>();
        while (result.size() < k) {
            Map.Entry<Integer, List<Integer>> entry = treeMap.pollLastEntry();
            result.addAll(entry.getValue());
        }
        return result;
    }
    /**
     * this is the test function for this question above.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] nums = {1, 1, 1, 2, 2, 3};
        int k = 2;
        List<Integer> result = TopKFrequentElements.solutionRef2(nums, k);
        System.out.println(result);
    }

}
