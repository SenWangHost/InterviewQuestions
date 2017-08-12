/**
 *
 */
package Math;

/**
 * We define the Perfect Number is a positive integer that is equal to the sum of all its positive divisors except itself.
 * Now, given an integer n, write a function that returns true when it is a perfect number and false when it is not.
 * Example:
 * Input: 28
 * Output: True
 * Explanation: 28 = 1 + 2 + 4 + 7 + 14
 * Note: The input number n will not exceed 100,000,000. (1e8)
 * @author SenWang
 *
 */
public class PerfectNumber {
    /**
     * This is my own solution to this question. Because the divisors are
     * paired, only have to iterate through the sqrt of the number
     * @param num the number to be checked.
     * @return true if it is a perfect number, false otherwise.
     */
    public static boolean solution(int num) {
        if (num == 1) {
            return false;
        }
        int sum = 1;
        int mid = (int) Math.sqrt(num);
        for (int i = 2; i <= mid; i++) {
            if (num % i == 0) {
                sum += i;
                sum += num / i;
            }
        }
        return sum == num;
    }
    /**
     * This is one reference solution, which uses the same idea, but with better code write up.
     * @param num the number to be checked.
     * @return true if it is a perfect number, false otherwise.
     */
    public static boolean solutionRef1(int num) {
        if (num <= 0) {
            return false;
        }
        int sum = 0;
        for (int i = 1; i * i <= num; i++) {
            if (num % i == 0) {
                sum += i;
                if (i * i != num) {
                    sum += num / i;
                }
            }
        }
        return sum - num == num;
    }
    /**
     * This is another reference solution for this question, which uses
     * euclid-euler theorem, the detailed explanation is on the leetcode.
     * @param num the number to be checked.
     * @return true if it is a perfect number, false otherwise.
     */
    public static boolean solutionRef2(int num) {
        int[] primes = {2, 3, 5, 7, 13, 17, 19, 31};
        for (int prime : primes) {
            if (pn(prime) == num) {
                return true;
            }
        }
        return false;
    }
    /**
     * This is helper function for the above reference solution.
     * @param p the prime number to be input
     * @return the mersenne prime number
     */
    private static int pn(int p) {
        return (1 << (p - 1)) * ((1 << p) - 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(PerfectNumber.solution(6));
    }
}
