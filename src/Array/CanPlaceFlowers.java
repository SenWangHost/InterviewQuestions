/**
 *
 */
package Array;

/**
 * Suppose you have a long flowerbed in which some of the plots are planted and some are not.
 * However, flowers cannot be planted in adjacent plots - they would compete for water and both would die.
 *
 * Given a flowerbed (represented as an array containing 0 and 1, where 0 means empty and 1 means not empty),
 * and a number n, return if n new flowers can be planted in it without violating the no-adjacent-flowers rule.
 *
 * Example 1:
 * Input: flowerbed = [1,0,0,0,1], n = 1
 * Output: True
 *
 * Example 2:
 * Input: flowerbed = [1,0,0,0,1], n = 2
 * Output: False
 *
 * Note:
 * The input array won't violate no-adjacent-flowers rule.
 * The input array size is in the range of [1, 20000].
 * n is a non-negative integer which won't exceed the input array size.
 * @author SenWang
 *
 */
public class CanPlaceFlowers {
    /**
     * This is my own solution for this question. This algorithm is not so good because it
     * @param flowerbed the array representing the flower bed.
     * @param n the number of flower the user want to put
     * @return true if n number of flowers can be placed, false otherwise.
     */
    public static boolean solution(int[] flowerbed, int n) {
        int size = flowerbed.length;
        if (size < 3) {
            for (int pos: flowerbed) {
                if (pos != 0) {
                    return 0 >= n;
                }
            }
            return 1 >= n;
        }
        int count = 0;
        // two special cases for head and tail
        if (flowerbed[0] == 0 && flowerbed[1] == 0) {
            count += 1;
            flowerbed[0] = 1;
        }
        if (flowerbed[size - 1] == 0 && flowerbed[size - 2] == 0) {
            count += 1;
            flowerbed[size - 1] = 1;
        }
        // the normal cases which are simply looking for three consecutive zeros
        for (int i = 0; i < size - 2; i++) {
            if (flowerbed[i] == 0 && flowerbed[i + 1] == 0 && flowerbed[i + 2] == 0) {
                count += 1;
                flowerbed[i + 1] = 1;
            }
        }
        System.out.println(count);
        return count >= n;
    }
    /**
     * This is the reference solution for this question, the idea is the same as my mine
     * but the true reason it is better is that after count is bigger than n, it will not
     * loop through the array any more.
     * @param flowerbed the array representing the flower bed.
     * @param n the number of flower the user want to put
     * @return true if n number of flowers can be placed, false otherwise.
     */
    public static boolean solutionRef(int[] flowerbed, int n) {
        int count = 0;
        for(int i = 0; i < flowerbed.length && count < n; i++) {
            if(flowerbed[i] == 0) {
         //get next and prev flower bed slot values. If i lies at the ends the next and prev are considered as 0.
               int next = (i == flowerbed.length - 1) ? 0 : flowerbed[i + 1];
               int prev = (i == 0) ? 0 : flowerbed[i - 1];
               if(next == 0 && prev == 0) {
                   flowerbed[i] = 1;
                   count++;
               }
            }
        }
        return count == n;
    }
    /**
     * This is the test case for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int[] test = {1,0, 0, 0, 0, 0, 1};
        boolean result = CanPlaceFlowers.solution(test, 2);
        System.out.println(result);
    }

}
