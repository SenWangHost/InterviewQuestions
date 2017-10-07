/**
 *
 */
package BinarySearch;

/**
 * You are a product manager and currently leading a team to develop a new product.
 * Unfortunately, the latest version of your product fails the quality check.
 * Since each version is developed based on the previous version, all the versions
 * after a bad version are also bad.
 *
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first bad one,
 * which causes all the following ones to be bad.
 * You are given an API bool isBadVersion(version) which will return whether version is bad.
 * Implement a function to find the first bad version. You should minimize the number of calls to the API.
 * @author SenWang
 *
 */
public class FirstBadVersion {
    /**
     * this is my own soltuion to this question.
     */
    public static int solution(int n) {
        if (isBadVersion(1)) {
            return 1;
        }
        int low = 1;
        int high = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isBadVersion(mid)) {
                if (mid - 1 >= 1 && !isBadVersion(mid - 1)) {
                    return mid;
                }
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }
    /**
     * this is reference solution to this question, which uses
     * binary search with slight modifications
     */
    public static int solutionRef(int n) {
        int low = 1;
        int high = n;
        while (low < high) {
            int mid = low + (high - low) / 2;
            if (!isBadVersion(mid)) {
                low = mid + 1;
            } else {
                high = mid;
            }
        }
        return low;
    }
    /**
     * this is the method to determine whether a version is good or bad.
     */
    public static boolean isBadVersion(int version) {
        if (version >= 3) {
            return true;
        } else {
            return false;
        }
    }
    /**
     * This is a test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        System.out.println(solution(7));
    }

}
