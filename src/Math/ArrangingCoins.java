/**
 *
 */
package Math;

/**
 * You have a total of n coins that you want to form in a staircase shape,
 * where every k-th row must have exactly k coins.
 * Given n, find the total number of full staircase rows that can be formed.
 * n is a non-negative integer and fits within the range of a 32-bit signed integer.
 *
 * Example 1:
 * n = 5
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤
 * Because the 3rd row is incomplete, we return 2.
 *
 * Example 2:
 * n = 8
 * The coins can form the following rows:
 * ¤
 * ¤ ¤
 * ¤ ¤ ¤
 * ¤ ¤
 * Because the 4th row is incomplete, we return 3.
 * @author SenWang
 *
 */
public class ArrangingCoins {
    /**
     * This is my own solution to this question. This is
     * naive solution which just adds up the consecutive sum.
     * @param n the number of coins we have.
     * @return the total number of full row we could form.
     */
    public static int solution(int n) {
        long sum = 0;
        int k = 0;
        while (sum <= n) {
            k++;
            sum += k;
        }
        return k - 1;
    }
    /**
     * This is my another solution of this question, which
     * uses binary search to find the result in the range of 0
     * to n. The runtime complexity would be O(log(n)) and beats 75% of the
     * solutions.
     * @param n the number of coins we have.
     * @return the total number of full row we could form.
     */
    public static int solution2(int n) {
        int low = 0;
        int high = n;
        int mid = 0;
        while (low <= high) {
            mid = (high - low) / 2 + low;
            long sum = ((long) (mid + 1)) * ((long) mid)/ 2;
            long upSum = (long) (mid + 2) * (long) (mid + 1) / 2;
            if (sum <= n && n < upSum) {
                return mid;
            } else if (sum > n) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return mid;
    }
    /**
     * This is one of the reference solution to this question, which uses
     * the math equation to solve this problem, and the runtime complexity
     * would be O(1).
     * sum = x * (x - 1) / 2, thus x = x = (-1 + sqrt(8 * n + 1)) / 2
     * @param n the number of coins we have.
     * @return the total number of full row we could form.
     */
    public static int solutionRef(int n) {
        return (int)((-1 + Math.sqrt(1 + 8 * (long)n)) / 2);
    }
    /**
     * This is another version of binary search solution, which is much
     * clean and compact than my solution.
     * @param n the number of coins we have.
     * @return the total number of full row we could form.
     */
    public static int solutionRef2(int n) {
        long longN = n;
        long low = 0;
        long high = longN;
        while (low <= high) {
            long mid = (low + high) / 2;
            if (mid * (mid + 1) / 2 <= longN) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return (int) (low - 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = Integer.MAX_VALUE;
        int result = ArrangingCoins.solution2(test);
        System.out.println(result);
        System.out.println(Integer.MAX_VALUE);
    }
}
