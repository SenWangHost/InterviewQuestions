/**
 *
 */
package Math;

/**
 * Given an array of integers A and let n to be its length.
 * Assume Bk to be an array obtained by rotating the array A k positions clock-wise, we define a "rotation function" F
 * on A as follow:
 * F(k) = 0 * Bk[0] + 1 * Bk[1] + ... + (n-1) * Bk[n-1].
 * Calculate the maximum value of F(0), F(1), ..., F(n-1).
 * Note:
 * n is guaranteed to be less than 10 ^ 5.
 * Example:
 * A = [4, 3, 2, 6]
 * F(0) = (0 * 4) + (1 * 3) + (2 * 2) + (3 * 6) = 0 + 3 + 4 + 18 = 25
 * F(1) = (0 * 6) + (1 * 4) + (2 * 3) + (3 * 2) = 0 + 4 + 6 + 6 = 16
 * F(2) = (0 * 2) + (1 * 6) + (2 * 4) + (3 * 3) = 0 + 6 + 8 + 9 = 23
 * F(3) = (0 * 3) + (1 * 2) + (2 * 6) + (3 * 4) = 0 + 2 + 12 + 12 = 26
 * So the maximum value of F(0), F(1), F(2), F(3) is F(3) = 26.
 * @author SenWang
 */
public class RotateFunction {
    /**
     * This is my own solution to this question. This solution uses math derivation.
     * The runtime complexity would be O(n).
     * @param A an array of integers to be rotated and calculated.
     * @return the maximum value of rotate array calculation.
     */
    public static int solution(int[] A) {
        // calculate F(0) and the sum of the array
        int sumArray = 0;
        int f0 = 0;
        for (int i = 0; i < A.length; i++) {
            sumArray += A[i];
            f0 += i * A[i];
        }
        // calculate the rest of the value of the rotate function.
        int max = f0;
        int ftemp = f0;
        for (int i = A.length - 1; i >= 1; i--) {
            ftemp = ftemp + sumArray - A.length * A[i];
            if (ftemp >= max) {
                max = ftemp;
            }
        }
        return max;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1, 2, 3};
        int result = RotateFunction.solution(test);
        System.out.println(result);
    }

}
