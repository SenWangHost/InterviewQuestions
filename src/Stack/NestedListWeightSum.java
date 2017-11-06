/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * Given a nested list of integers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists.
 *
 * Example 1:
 * Given the list [[1,1],2,[1,1]], return 10. (four 1's at depth 2, one 2 at depth 1)
 * Example 2:
 * Given the list [1,[4,[6]]], return 27. (one 1 at depth 1, one 4 at depth 2, and one 6 at
 * depth 3; 1 + 4*2 + 6*3 = 27)
 * @author SenWang
 *
 */
public class NestedListWeightSum {
    /**
     * this is my own solution to this question.
     */
    public static int depthSum(List<NestedInteger> nestedList) {
        return helper(nestedList, 1);

    }
    private static int helper(List<NestedInteger> list, int depth) {
        int result = 0;
        for (NestedInteger ele : list) {
            if (ele.isInteger()) {
                result += ele.getInteger() * depth;
            } else {
                result += helper(ele.getList(), depth + 1);
            }
        }
        return result;
    }
    /**
     * this is an iterative solution to this question.
     */
    public static int solution2(List<NestedInteger> nestedList) {
        if(nestedList == null){
            return 0;
        }

        int sum = 0;
        int level = 1;

        Deque<NestedInteger> queue = new ArrayDeque<NestedInteger>(nestedList);
        while(queue.size() > 0){
            int size = queue.size();

            for(int i = 0; i < size; i++){
                NestedInteger ni = queue.poll();

                if(ni.isInteger()){
                    sum += ni.getInteger() * level;
                }else{
                    queue.addAll(ni.getList());
                }
            }

            level++;
        }

        return sum;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }
    /**
     * the nested integer class
     */
    public static class NestedInteger {
        private Integer integer;
        private List<NestedInteger> list;
        /**
         *
         */
        public NestedInteger() {
            integer = null;
            list = new ArrayList<NestedInteger>();
        }
        /**
         *
         */
        public NestedInteger(int value) {
            integer = value;
            list = new ArrayList<NestedInteger>();
        }
        /**
         *
         */
        public boolean isInteger() {
            return integer != null;
        }
        /**
         *
         */
        public Integer getInteger() {
            return integer;
        }
        /**
         *
         */
        public void setInteger(int value) {
            integer = value;
        }
        /**
         *
         */
        public void add(NestedInteger ni) {
            list.add(ni);
        }
        /**
         *
         */
        public List<NestedInteger> getList() {
            return list;
        }
    }

}
