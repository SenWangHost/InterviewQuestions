/**
 *
 */
package Math;

/**
 * Find the nth digit of the infinite integer sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ...
 * Note:
 * n is positive and will fit within the range of a 32-bit signed integer (n < 2^31).
 * Example 1:
 * Input: 3 Output: 3
 *
 * Example 2:
 * Input: 11 Output: 0
 * Explanation:
 * The 11th digit of the sequence 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, ... is a 0, which is part of the number 10.
 * @author SenWang
 *
 */
public class NthDigit {
    /**
     * This is my own solution to this question. This solution is bad and
     * exceed the memory limit eventually.
     * @param n the largest number of the consecutive sequence.
     * @return the nth digit of that sequence.
     */
    public static int solution(int n) {
        StringBuilder temp = new StringBuilder("");
        int count = 0;
        for (int num = 1; num <= n; num++) {
            String numTemp = Integer.toString(num);
            temp.append(numTemp);
            count += numTemp.length();
            if (count >= n) {
                break;
            }
        }
        return temp.charAt(n - 1) - '0';
    }
    /**
     * This is the reference solution which uses three steps to solve this problem.
     * 1. find the length of the number that Nth digit is in.
     * 2. find this number.
     * 3. find exactly which digit in this number should be the right answer.
     */
    public static int solutionRef(int n) {
        // step 1, find the length of the number that Nth digit is in.
        int len = 1;
        int count = 9;
        int start = 1;
        while (n > len * count) {
            n -= len * count;
            len++;
            count *= 10;
            start *= 10;
        }
        // step 2, find the target number
        int target = start + (n - 1) / len;
        // step 3, find which digit is the right answer.
        // here, convert the target number to string makes it easy to find digit.
        String s = Integer.toString(target);
        return Character.getNumericValue(s.charAt((n - 1) % len));
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(NthDigit.solutionRef(30));
//        System.out.println(NthDigit.solution(3));
//        System.out.println(NthDigit.solution(5));
//        System.out.println(NthDigit.solution(7));
//        System.out.println(NthDigit.solution(9));
//        System.out.println(NthDigit.solution(10));
//        System.out.println(NthDigit.solution(11));
//        System.out.println(NthDigit.solution(12));
//        System.out.println(NthDigit.solution(21));
    }

}
