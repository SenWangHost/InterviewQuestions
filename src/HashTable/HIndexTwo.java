/**
 *
 */
package HashTable;

/**
 * Follow up for H-Index: What if the citations array is sorted in ascending order?
 * Could you optimize your algorithm?
 * @author SenWang
 *
 */
public class HIndexTwo {
    /**
     * this is my own solution to this question.
     */
    public static int solution(int[] citations) {
        int left = 0;
        int n = citations.length;
        int right = n - 1;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (citations[mid] == n - mid) {
                return citations[mid];
            } else if (citations[mid] > (n - mid)) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return n - (right + 1);
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
