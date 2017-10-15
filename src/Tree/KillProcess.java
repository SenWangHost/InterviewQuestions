/**
 *
 */
package Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given n processes, each process has a unique PID (process id) and its PPID (parent process id).
 * Each process only has one parent process, but may have one or more children processes.
 * This is just like a tree structure. Only one process has PPID that is 0, which means this process has
 * no parent process. All the PIDs will be distinct positive integers.
 *
 * We use two list of integers to represent a list of processes, where the first list contains PID for
 * each process and the second list contains the corresponding PPID.
 * Now given the two lists, and a PID representing a process you want to kill, return a list of PIDs of
 * processes that will be killed in the end. You should assume that when a process is killed, all its
 * children processes will be killed. No order is required for the final answer.
 *
 * Example 1:
 * Input:
 * pid =  [1, 3, 10, 5]
 * ppid = [3, 0, 5, 3]
 * kill = 5
 * Output: [5,10]
 * Explanation:
 *          3
 *        /   \
 *       1     5
 *            /
 *           10
 * Kill 5 will also kill 10.
 * Note:
 * 1. The given kill id is guaranteed to be one of the given PIDs.
 * 2. n >= 1.
 * @author SenWang
 *
 */
public class KillProcess {
    /**
     * this is my own solution to this question. use map for grouping pid and ppid.
     */
    public static List<Integer> solution(List<Integer> pid, List<Integer> ppid, int kill) {
        Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
        for (int i = 0; i < ppid.size(); i++) {
            if (map.get(ppid.get(i)) == null) {
                map.put(ppid.get(i), new ArrayList<Integer>());
            }
            map.get(ppid.get(i)).add(pid.get(i));
        }
        Deque<Integer> queue = new ArrayDeque<Integer>();
        List<Integer> result = new ArrayList<Integer>();
        queue.offer(kill);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                int parent = queue.poll();
                size--;
                result.add(parent);
                List<Integer> children = map.get(parent);
                if (children != null) {
                    for (int child : children) {
                        queue.offer(child);
                    }
                }

            }
        }
        return result;
    }
    /**
     * the reference solution has the same idea as mine.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        Integer[] PID = {1, 3, 10, 5, 11, 7, 9, 12};
        Integer[] PPID = {3, 0, 5, 3, 5, 3, 7, 7};
        List<Integer> pid = Arrays.asList(PID);
        List<Integer> ppid = Arrays.asList(PPID);
        List<Integer> result = solution(pid, ppid, 3);
        System.out.println(result);

    }

}
