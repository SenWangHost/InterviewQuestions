/**
 *
 */
package Math;

/**
 * Description:
 * Count the number of prime numbers less than a non-negative number, n.
 * @author SenWang
 *
 */
public class CountPrimes {
    /**
     * This is my own solution to this question. This is the naive solution
     * that will not be accepted because time limit exceed.
     * @param n the limit for counting the prime numbers
     * @return the number of prime numbers that lies in range of 0
     * and n.
     */
    public static int solution(int n) {
        if (n <= 1) {
            return 0;
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (isPrime(i)) {
                count++;
            }
        }
        return count;
    }
    /**
     * This is the helper function to check whether is a prime number.
     * @param number the number to be checked.
     * @return true if it is a prime number, false otherwise.
     */
    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        int mid = (int) Math.sqrt(number);
        for (int i = 2; i <= mid; i++) {
            if (number % i == 0 || number % (number / i) == 0) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the reference solution to this, which uses Sieve of Eratosthenes
     * algorithm, the detailed information is on wikipedia and leetcode.
     * The key idea behind sieve of ratosthenes is that the  of a prime number
     * must not be prime. The following code is less efficient for the understanding
     * of the algorithm.
     * @param number the number to be checked.
     * @return true if it is a prime number, false otherwise.
     */
    public static int solutionRef(int n) {
        // create a list of numbers up to n and mark all of them to be true.
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) {
           isPrime[i] = true;
        }
        // Loop's ending condition is i * i < n instead of i < sqrt(n)
        // to avoid repeatedly calling an expensive function sqrt().
        for (int i = 2; i * i < n; i++) {
            // skip the number that has already been marked off.
            if (!isPrime[i]) {
                continue;
            }
            // start at p * p to mark off the element.
            for (int j = i * i; j < n; j += i) {
                isPrime[j] = false;
            }
        }
        // get the number of prime number from the list.
        int count = 0;
        for (int i = 2; i < n; i++) {
           if (isPrime[i]) count++;
        }
        return count;
    }
    /**
     * This is another reference solution, which uses the same algorithm
     * but with more compact code.
     * @param number the number to be checked.
     * @return true if it is a prime number, false otherwise.
     */
    public static int solutionRef2(int n) {
        boolean[] notPrime = new boolean[n];
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (notPrime[i] == false) {
                count++;
                for (int j = 2; i*j < n; j++) {
                    notPrime[i*j] = true;
                }
            }
        }
        return count;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 20;
        int result = CountPrimes.solution(test);
        System.out.println(result);
    }
}
