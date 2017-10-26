/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

/**
 * Suppose Andy and Doris want to choose a restaurant for dinner, and they both have a list of
 * favorite restaurants represented by strings.
 * You need to help them find out their common interest with the least list index sum.
 * If there is a choice tie between answers, output all of them with no order requirement.
 *  You could assume there always exists an answer.
 *
 *  Example 1:
 *  Input:
 *  ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *  ["Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"]
 *  Output: ["Shogun"]
 *  Explanation: The only restaurant they both like is "Shogun".
 *
 *  Example 2:
 *  Input:
 *  ["Shogun", "Tapioca Express", "Burger King", "KFC"]
 *  ["KFC", "Shogun", "Burger King"]
 *  Output: ["Shogun"]
 *  Explanation: The restaurant they both like and have the least index sum is "Shogun" with index sum 1 (0+1).
 *  Note:
 *  1. The length of both lists will be in the range of [1, 1000].
 *  2. The length of strings in both lists will be in the range of [1, 30].
 *  3. The index is starting from 0 to the list length minus 1.
 *  4. No duplicates in both lists.
 * @author SenWang
 *
 */
public class MinimumIndexSumOfTwoLists {
    /**
     * this is my own solution to this question.
     */
    public static String[] solution(String[] list1, String[] list2) {
        Map<String, int[]> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], new int[2]);
            map.get(list1[i])[0] = i;
            map.get(list1[i])[1] = 1;
        }
        int min = Integer.MAX_VALUE;
        for (int j = 0; j < list2.length; j++) {
            if (map.containsKey(list2[j])) {
                map.get(list2[j])[0] += j;
                map.get(list2[j])[1]++;
                min = Math.min(min, map.get(list2[j])[0]);
            }
        }
        List<String> result = new ArrayList<String>();
        for (Entry<String, int[]> entry : map.entrySet()) {
            int[] value = entry.getValue();
            if (value[1] == 2 && value[0] == min) {
                result.add(entry.getKey());
            }
        }
        String[] res = new String[result.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = result.get(i);
        }
        return res;
     }
    /**
     * this is the reference solution to this question, which has the same idea but
     * with simpler implementation
     */
    public static String[] solutionRef(String[] list1, String[] list2) {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < list1.length; i++) {
            map.put(list1[i], i);
        }
        int minSum = Integer.MAX_VALUE;
        List<String> result = new ArrayList<>();
        for (int i = 0; i < list2.length; i++) {
            Integer j = map.get(list2[i]);
            if (j != null && i + j <= minSum) {
                if (i + j < minSum) {
                    result.clear();
                    minSum = i + j;
                }
                result.add(list2[i]);
            }
        }
        return result.toArray(new String[result.size()]);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] list1 = {"Shogun", "Tapioca Express", "Burger King", "KFC"};
        String[] list2 = {"KFC", "Shogun", "Burger King"};
        String[] result = solution(list1, list2);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
