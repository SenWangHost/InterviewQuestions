/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.
 * By listing and labeling all of the permutations in order,
 * We get the following sequence (ie, for n = 3):
 * "123"
 * "132"
 * "213"
 * "231"
 * "312"
 * "321"
 * Given n and k, return the kth permutation sequence.
 * Note: Given n will be between 1 and 9 inclusive.
 * @author SenWang
 */
public class PermutationSequence {
    /**
     * this is my own recursive solution to this question. This solution works but it is
     * complicated and slow.
     * @param n the upper limit of set
     * @param k the kth permutation in the permutation sequence.
     * @return the kth permutation in the sequence.
     */
    public static String solution(int n, int k) {
        int groupStart = 1;
        int groupSize = factorial(n - 1);
        while (groupStart <= 9) {
            if (k <= groupStart * groupSize) {
                break;
            }
            groupStart++;
        }
        int diff = k - (groupStart - 1) * groupSize;
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(groupStart);
        int[] count = new int[1];
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        backTrack(result, temp, count, diff, n);
        String str = "";
        for (int num : result.get(0)) {
            str += Integer.toString(num);
        }
        return str;
    }
    /**
     * this is the recursive backtrack helper function to the solution above.
     * @parma temp the tmporary string for storing the permutation sequence.
     * @param count the index for determing the order in the sequence.
     * @param start the start number for the permutation
     * @param diff the final difference between start number and result
     * @param n
     */
    private static void backTrack(List<List<Integer>> result, List<Integer> temp, int[] count, int diff, int n) {
//        System.out.println(count[0]);
//        System.out.println(temp);
        if (temp.size() == n) {
            count[0]++;
        }
        if (count[0] == diff) {
            result.add(new ArrayList<Integer>(temp));
//            System.out.println(result);
            return;
        }
        for (int i = 1; i <= n; i++) {
            if (!temp.contains(i)) {
                temp.add(i);
                backTrack(result, temp, count, diff, n);
                temp.remove(temp.size() - 1);
            }
        }
    }
    /**
     * this is the helper function to calculate the factorial of a number
     * @param num the input number
     * @return the factorial of the input number.
     */
    private static int factorial(int num) {
        if (num == 0) {
            return 1;
        }
        return num * factorial(num - 1);
    }
    /**
     * This is the reference solution to this question.
     * @param n the upper limit of set
     * @param k the kth permutation in the permutation sequence.
     * @return the kth permutation in the sequence.
     */
    public static String solutionRef(int n, int k) {
        // create a list of numbers to get indices
        List<Integer> list = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        StringBuilder result = new StringBuilder();
        k--;
        for (int i = 1; i <=n; i++) {
            int index = k/factorial(n - i);
            result.append(String.valueOf(list.get(index)));
            list.remove(index);
            k -= index*factorial(n-i);
        }
        return result.toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String result = PermutationSequence.solution(8, 8590);
        System.out.println(result);
    }

}
