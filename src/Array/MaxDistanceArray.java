/**
 *
 */
package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Given m arrays, and each array is sorted in ascending order.
 * Now you can pick up two integers from two different arrays (each array picks one) and calculate the distance.
 * We define the distance between two integers a and b to be their absolute difference |a-b|.
 * Your task is to find the maximum distance.
 *
 * Input:
 * [[1,2,3],
 * [4,5],
 * [1,2,3]]
 * Output: 4
 * Explanation:
 * One way to reach the maximum distance 4 is to pick 1 in the first or third array and pick 5 in the second array.
 *
 * Note:
 * Each given array will have at least 1 number. There will be at least two non-empty arrays.
 * The total number of the integers in all the m arrays will be in the range of [2, 10000].
 * The integers in the m arrays will be in the range of [-10000, 10000]
 * @author SenWang
 *
 */
public class MaxDistanceArray {
    /**
     * The solution to this question.
     * @param arrays The array for the input
     * @return the maximum distance the array could have.
     */
    public int maxDistance(List<List<Integer>> arrays) {
        // set max and min element.
        int maxNum = -10001;
        int minNum = 10001;
        int maxIndex = -1;
        int minIndex = -1;
        for (int i = 0; i < arrays.size(); i++) {
            List<Integer> temp = arrays.get(i);
            int maxTemp = temp.get(temp.size() - 1);
            int minTemp = temp.get(0);
            if (maxTemp >= maxNum) {
                maxNum = maxTemp;
                maxIndex = i;
            }
            if(minTemp < minNum) {
                minNum = minTemp;
                minIndex = i;
            }
        }
        if (maxIndex != minIndex) {
            return maxNum - minNum;
        }
        int dis1 = 0;
        int dis2 = 0;
        // set as maxIndex to find the distance;
        int minNumSec = 10001;
        for (int i = 0; i < arrays.size(); i++) {
            if (i != maxIndex) {
                List<Integer> temp = arrays.get(i);
                int minTemp = temp.get(0);
                if(minTemp < minNumSec) {
                    minNumSec = minTemp;
                }
            }
        }
        dis1 = maxNum - minNumSec;
        // set as maxIndex to find the distance;
        int maxNumSec = -10001;
        for (int i = 0; i < arrays.size(); i++) {
            if (i != minIndex) {
                List<Integer> temp = arrays.get(i);
                int maxTemp = temp.get(temp.size() - 1);
                if (maxTemp >= maxNumSec) {
                    maxNumSec = maxTemp;
                }
            }
        }
        dis2 = maxNumSec - minNum;
        if (dis1 >= dis2) {
            return dis1;
        } else {
            return dis2;
        }

    }
    /**
     * The reference solution to this question.
     * @param arrays The array for the input
     * @return the maximum distance the array could have.
     */
    public int maxDistanceRef(List<List<Integer>> arrays) {
        int result = Integer.MIN_VALUE;
        List<Integer> first = arrays.get(0);
        int max = first.get(first.size() - 1);
        int min = first.get(0);
        for (int i = 1; i < arrays.size(); i++) {
            List<Integer> sub = arrays.get(i);
            result = Math.max(result, Math.abs(sub.get(sub.size() - 1) - min));
            result = Math.max(result, Math.abs(sub.get(0) - max));
            max = Math.max(max, sub.get(sub.size() - 1));
            min = Math.min(min, sub.get(0));
        }
        return result;
    }

    /**
     * The test function for this question
     * @param args
     */
    public static void main(String[] args) {
        MaxDistanceArray test = new MaxDistanceArray();
        // TODO Auto-generated method stub
        List<List<Integer>> arrays1 = new ArrayList<List<Integer>>();
        List<Integer> sub1 = new ArrayList<Integer>();
        sub1.add(1);
        sub1.add(5);
//        sub1.add(3);
        List<Integer> sub2 = new ArrayList<Integer>();
        sub2.add(3);
        sub2.add(4);
//        List<Integer> sub3 = new ArrayList<Integer>();
//        sub3.add(1);
//        sub3.add(2);
//        sub3.add(3);
        arrays1.add(sub1);
        arrays1.add(sub2);
//        arrays1.add(sub3);
        int maxDis = test.maxDistanceRef(arrays1);
        System.out.println(maxDis);
    }

}
