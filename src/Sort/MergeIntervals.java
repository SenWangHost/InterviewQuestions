/**
 *
 */
package Sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Given a collection of intervals, merge all overlapping intervals.
 * For example,
 * Given [1,3],[2,6],[8,10],[15,18],
 * return [1,6],[8,10],[15,18].
 * @author SenWang
 *
 */
public class MergeIntervals {
    /**
     * this is my own solution to this question.
     */
    public static List<Interval> solution(List<Interval> intervals) {
        if (intervals == null || intervals.size() == 0) {
            return null;
        }
        Collections.sort(intervals, new Comparator<Interval>() {

            @Override
            public int compare(Interval o1, Interval o2) {
                // TODO Auto-generated method stub
                return o1.start - o2.start;
            }

        });
        List<Interval> result = new ArrayList<Interval>();
        int i = 0;
        while (i < intervals.size()) {
            int start = i;
            int end = i + 1;
            while (end < intervals.size() && intervals.get(start).end >= intervals.get(end).start) {
                intervals.get(start).end = intervals.get(end).end;
                end++;
            }
            result.add(intervals.get(start));
            i = end;
        }
        return result;
    }
    /**
     * this is one of the reference solution to this question, which sorts both start time
     * and end time.
     */
    public static List<Interval> solutionRef(List<Interval> intervals) {
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        for (int i = 0; i < intervals.size(); i++) {
            starts[i] = intervals.get(i).start;
            ends[i] = intervals.get(i).end;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);
        List<Interval> result = new ArrayList<Interval>();
        for (int i = 0, j = 0; i < n; i++) { // j is the start of the interval
            if (i == n - 1 || starts[i + 1] > ends[i]) {
                result.add(new Interval(starts[j], ends[i]));
                j = i + 1;
            }
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
