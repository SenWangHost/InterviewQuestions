/**
 *
 */
package Sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given an array of meeting time intervals consisting of start and end times [[s1,e1],[s2,e2],...] (si < ei),
 * find the minimum number of conference rooms required.
 *
 * For example,
 * Given [[0, 30],[5, 10],[15, 20]],
 * return 2.
 * @author SenWang
 *
 */
public class MeetingRoomsTwo {
    /**
     * this is my own solution to this question.
     */
    public static int solution(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        // Sort the intervals by start time
        Arrays.sort(intervals, new Comparator<Interval>() {
            @Override
            public int compare(Interval a, Interval b) {
                return a.start - b.start;
            }
        });
        // Use a min heap to track the minimum end time of merged intervals
        PriorityQueue<Integer> ends = new PriorityQueue<Integer>();
        ends.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start >= ends.peek()) {
                // no overlap, then should update smallest end.
                ends.poll();
            }
            ends.offer(intervals[i].end);
        }
        return ends.size();
    }
    /**
     * this is another reference solution to this question, which sort both the start times and end
     * times and determine the needed number of rooms.
     */
    public static int solution2(Interval[] intervals) {
        if (intervals == null || intervals.length == 0) {
            return 0;
        }
        int[] starts = new int[intervals.length];
        int[] ends = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            starts[i] = intervals[i].start;
            ends[i] = intervals[i].end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        int room = 0;
        int endItr = 0;
        for (int i = 0; i < intervals.length; i++) {
            if (starts[i] < ends[endItr]) {
                room++;
            } else {
                endItr++;
            }
        }
        return room;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

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
        @SuppressWarnings("unused")
        public Interval(int s, int e) {
            start = s;
            end = e;
        }
    }
}
