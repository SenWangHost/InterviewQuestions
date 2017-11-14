/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * For example,
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * @author SenWang
 *
 */
public class MovingAverageFromDataStream {
    /**
     * this is my own solution to this question.
     */
    public static class MovingAverage {
        private int sum = 0;
        private Deque<Integer> queue;
        private int size;
        /** Initialize your data structure here. */
        public MovingAverage(int size) {
            this.size = size;
            queue = new ArrayDeque<Integer>();
        }

        public double next(int val) {
            if (queue.size() < size) {
                queue.offer(val);
                sum += val;
            } else {
                sum -= queue.poll();
                queue.offer(val);
                sum += val;
            }
            return (double) sum / queue.size();
        }
    }
    /**
     * this should be the solution to this question.
     */
    public static class MovingAverage2 {
        private int [] window;
        private int n, insert;
        private long sum;

        /** Initialize your data structure here. */
        public MovingAverage2(int size) {
            window = new int[size];
            insert = 0;
            sum = 0;
        }

        public double next(int val) {
            if (n < window.length)  n++;
            sum -= window[insert];
            sum += val;
            window[insert] = val;
            insert = (insert + 1) % window.length;

            return (double)sum / n;
        }
    }
    /**
     * This is the test function for this question
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
