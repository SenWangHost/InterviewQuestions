/**
 *
 */
package Array;

/**
 * In LOL world, there is a hero called Teemo and his attacking can make his enemy Ashe be in poisoned condition.
 * Now, given the Teemo's attacking ascending time series towards Ashe and the poisoning time duration per Teemo's attacking,
 * you need to output the total time that Ashe is in poisoned condition.
 *
 * You may assume that Teemo attacks at the very beginning of a specific time point,
 * and makes Ashe be in poisoned condition immediately.
 *
 * Example 1:
 * Input: [1,4], 2
Output: 4
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned immediately.
This poisoned status will last 2 seconds until the end of time point 2.
And at time point 4, Teemo attacks Ashe again, and causes Ashe to be in poisoned status for another 2 seconds.
So you finally need to output 4.
Example 2:
Input: [1,2], 2
Output: 3
Explanation: At time point 1, Teemo starts attacking Ashe and makes Ashe be poisoned.
This poisoned status will last 2 seconds until the end of time point 2.
However, at the beginning of time point 2, Teemo attacks Ashe again who is already in poisoned status.
Since the poisoned status won't add up together, though the second poisoning attack will still work at time point 2, it will stop at the end of time point 3.
So you finally need to output 3.
Note:
You may assume the length of given time series array won't exceed 10000.
You may assume the numbers in the Teemo's attacking time series and his poisoning time duration per attacking are non-negative integers, which won't exceed 10,000,000.
 * @author SenWang
 *
 */
public class TeemoAttacking {
    /**
     * this is my own solution to this question, this solution was adopted from merge intervals solution.
     */
    public static int solution(int[] timeSeries, int duration) {
        int[] ends = new int[timeSeries.length];
        for (int i = 0; i < timeSeries.length; i++) {
            ends[i] = timeSeries[i] + duration - 1;
        }
        int count = 0;
        for (int i = 0, j = 0; i < timeSeries.length; i++) {
            if (i == timeSeries.length - 1 || timeSeries[i + 1] > ends[i]) {
                count += (ends[i] - timeSeries[j] + 1);
                j = i + 1;
            }
        }
        return count;
    }
    /**
     * this is one of the reference solution to this question, which
     */
    public static int solutionRef(int[] timeSeries, int duration) {
        if (timeSeries.length == 0) {
            return 0;
        }
        int begin = timeSeries[0];
        int result = 0;
        for (int t : timeSeries) {
            if (t < begin + duration) {
                result += t - begin;
            } else {
                result += duration;
            }
            begin = t;
        }
        return result;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
