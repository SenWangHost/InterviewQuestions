/**
 *
 */
package Math;

/**
 * Write a program to check whether a given number is an ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 6, 8 are ugly while 14 is not ugly since it includes another prime factor 7.
 * Note that 1 is typically treated as an ugly number.
 * @author SenWang
 *
 */
public class UglyNumber {
    /**
     * This is my own solution to this question. This solution is kind of
     * naive because the checking process follows the definition.
     * @param n the number to be determined.
     * @return true if this number is ugly, false otherwise.
     */
    public static boolean solution(int num) {
        if (num == 1) {
            return true;
        }
        if (num <= 0) {
            return false;
        }
        int mid = (int) Math.sqrt(num);
        for (int div = 1; div <= mid; div++) {
            if (num % div == 0) {
                if (isPrime(div) && (div != 1 && div != 2 && div != 3 && div != 5)) {
                    return false;
                }
                int pair = num / div;
                if (isPrime(pair) && (pair != 2 && pair != 3 && pair != 5)) {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * This is the helper function to check if a divisor
     * is prime or not.
     * @param number the number to be determined.
     * @return true if it is prime false otherwise.
     */
    private static boolean isPrime(int number) {
        int mid = (int) Math.sqrt(number);
        for (int i = 2; i <= mid; i++) {
            if (number % i == 0 || number % (number / i) == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the reference solution to this question.
     * The idea is: (1) basic cases: <= 0 and == 1
     * (2) other cases: since the number can contain the factors of 2, 3, 5, I just remove those factors.
     * So now, I have a number without any factors of 2, 3, 5.
     * (3) after the removing, the number (new number) can contain a) the factor that is prime and meanwhile it is >= 7,
     * or b) the factor that is not the prime and the factor is not comprised of 2, 3 or 5. In both cases,
     * it is false (not ugly number).
     * @param number the number to be determined.
     * @return true if it is prime false otherwise.
     */
    public static boolean solutionRef(int num) {
        if (num <= 0) {
            return false;
        }
        if (num == 1) {
            return true;
        }
        // remove 2 from number's divisor as much as possible.
        while (num % 2 == 0) {
            num /= 2;
        }
        // remove 3 from number's divisor as much as possible.
        while (num % 3 == 0) {
            num /= 3;
        }
        // remove 5 from number's divisor as much as possible
        while (num % 5 == 0) {
            num /= 5;
        }
        return num == 1;
    }
    /**
     * This is test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        // System.out.println(UglyNumber.isPrime(4));
        int test = 11;
        boolean result = UglyNumber.solution(test);
        System.out.println(result);
    }
}
