/**
 *
 */
package BitManipulation;

/**
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note:
 * 0 ≤ x, y < 2 ^ 31.
 * Example:
 * Input: x = 1, y = 4
 * Output: 2
 * Explanation:
 * 1   (0 0 0 1)
 * 4   (0 1 0 0)
 *        ?   ?
 * The above arrows point to positions where the corresponding bits are different.
 * @author SenWang
 *
 */
public class HammingDistance {
    /**
     * This is my own solution to this question, which uses xor and count the number of 1
     * in the binary representation of the xor result.
     * @param x the first number
     * @param y the second number
     * @return the hamming distance of two integers.
     */
    public static int solution(int x, int y) {
        int xorResult = x ^ y;
        int count = 0;
        for (int i = 0; i < 32; i++) {
            if ((xorResult & 1) == 1) {
                count++;
            }
            xorResult >>= 1;
        }
        return count;
    }
    /**
     * This is one-liner reference solution to this question.
     * @param x the first number
     * @param y the second number
     * @return the hamming distance of two integers.
     */
    public static int solutionRef(int x, int y) {
        return Integer.bitCount(x ^ y);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int x = 1;
        int y = 4;
        System.out.println(HammingDistance.solution(x, y));
    }

}
