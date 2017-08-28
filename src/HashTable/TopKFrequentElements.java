/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Given a non-empty array of integers, return the k most frequent elements.
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
     * This is my own solution to this question.
     * @param nums the array of numbers to be considered.
     * @param k the limit for frequency
     * @return a list of integer of the k most frequent elements.
     */
    public static List<Integer> solution(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        for (int num : nums) {
            if (map.containsKey(num)) {
                map.put(num, map.get(num) + 1);
            } else {
                map.put(num, 1);
            }
        }
        Set<Integer> set = map.keySet();
        List<Integer> result = new ArrayList<Integer>();
        Iterator<Integer> iter = set.iterator();
        while (iter.hasNext()) {
            int number = iter.next();
            int fre = map.get(number);
            if (fre >= k) {
                result.add(number);
            }
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
        List<Integer> result = TopKFrequentElements.solution(nums, k);
        System.out.println(result);
    }

}
