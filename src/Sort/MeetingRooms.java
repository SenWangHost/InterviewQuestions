/**
 *
 */
package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * determine if a person could attend all meetings.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return false.
 * @author SenWang
 *
 */
public class MeetingRooms {
    /**
     * this is my own solution to this question.
     */
    public static boolean solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return false;
        }
        Map<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            if (map.containsKey(intervals[i].start)) {
                return false;
            } else {
                map.put(intervals[i].start, intervals[i].end);
            }
            starts[i] = intervals[i].start;
        }
        Arrays.sort(starts);
        for (int i = 0; i < starts.length - 1; i++) {
            int end = map.get(starts[i]);
            if (end >= starts[i + 1]) {
                return false;
            }
        }
        return true;
    }
    /**
     * the reference solution has the same idea as mine but instead, use a comparator
     * to sort the interval, which increase the efficiency of the algorithm
     */
    public static boolean solutionRef(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return true;
        }
        Arrays.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                // TODO Auto-generated method stub
                return o1.start - o2.start;
            }

        });
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < intervals[i - 1].end) {
                return false;
            }
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Interval in1 = new Interval(5, 8);
        Interval in2 = new Interval(6, 8);
        Interval[] intervals = {in1, in2};
        System.out.println(solution(intervals));
    }

    /**
     * the interval class
     */
    private static class Interval {
        private int start;
        private int end;
        @SuppressWarnings("unused")
        public Interval() {
            start = 0;
            end = 0;
        }
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

}
