/**
 *
 */
package BitManipulation;

/**
 * Reverse bits of a given 32 bits unsigned integer.
 * For example, given input 43261596 (represented in binary as 00000010100101000001111010011100),
 * return 964176192 (represented in binary as 00111001011110000010100101000000).
 * Follow up:
 * If this function is called many times, how would you optimize it?
 * @author SenWang
 *
 */
public class ReverseBits {
    /**
     * This is my own solution to this question, which uses loop to do
     * the reverse.
     * @param n the input integer to be considered.
     * @return the integer that contains reversed bits.
     */
    public static int solution(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            int digit = (n >> i) & 1;
            result |= digit;
            if (i != 31) {
                result <<= 1;
            }
        }
        return result;
    }
    /**
     * This is the reference solution use bit manipulation, the idea is divide
     * and conquer algorithm.
     * @param n the input integer to be considered.
     * @return the integer that contains reversed bits.
     */
    public static int solution2(int n) {
        n = ((n & 0xaaaaaaaa) >>> 1) | ((n & 0x55555555) << 1);
        n = ((n & 0xcccccccc) >>> 2) | ((n & 0x33333333) << 2);
        n = ((n & 0xf0f0f0f0) >>> 4) | ((n & 0x0f0f0f0f) << 4);
        n = ((n & 0xff00ff00) >>> 8) | ((n & 0x00ff00ff) << 8);
        n = (n >>> 16) | (n << 16);
        return n;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 1;
        int result = ReverseBits.solution2(test);
        System.out.println(Integer.toBinaryString(result));
    }

}
