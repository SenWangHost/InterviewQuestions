/**
 *
 */
package HashTable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.
 *
 * add - Add the number to an internal data structure.
 * find - Find if there exists any pair of numbers which sum is equal to the value.
 *
 * For example,
 * add(1); add(3); add(5);
 * find(4) -> true
 * find(7) -> false
 * @author SenWang
 *
 */
public class TwoSumThreeDataStructureDesign {
    /**
     * the two sum class
     */
    public static class TwoSum {
        /**
         * field for list
         */
        private List<Integer> list;
        /**
         * field for set
         */
        private Set<Integer> set;
        /**
         * the constructor for initializing the data structure
         */
        public TwoSum() {
            list = new ArrayList<Integer>();
            set = new HashSet<Integer>();
        }
        /**
         * the add method for this class
         */
        public void add(int number) {
            list.add(number);
        }
        /**
         * the find method for this class.
         */
        public boolean find(int value) {
            for (int num : list) {
                if (set.contains(value - num)) {
                    set = new HashSet<Integer>();
                    return true;
                } else {
                    set.add(num);
                }
            }
            set = new HashSet<Integer>();
            return false;
        }
    }
    /**
     * this is reference solution to this question.
     */
    public static class TwoSumRef {
        /**
         * field for hash map
         */
        private Map<Integer, Integer> map;
        /**
         * the constructor for the class
         */
        public TwoSumRef() {
            map = new HashMap<Integer, Integer>();
        }
        /**
         * the add method
         */
        public void add(int number) {
            if (map.containsKey(number)) {
                map.put(number, 2);
            } else {
                map.put(number, 1);
            }
        }
        /**
         * the find method
         */
        public boolean find(int value) {
            for (Entry<Integer, Integer> entry : map.entrySet()) {
                int num1 = value - entry.getKey();
                if (map.containsKey(num1)) {
                    if (num1 != entry.getKey() || map.get(num1) == 2) {
                        return true;
                    }
                }
            }
            return false;
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
