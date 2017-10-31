/**
 *
 */
package Stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

/**
 * Given an absolute path for a file (Unix-style), simplify it.
 *
 * For example,
 * path = "/home/", => "/home"
 * path = "/a/./b/../../c/", => "/c"
 *
 * Corner Cases:
 * Did you consider the case where path = "/../"?
 * In this case, you should return "/".
 * Another corner case is the path might contain multiple slashes '/' together, such as "/home//foo/".
 * In this case, you should ignore redundant slashes and return "/home/foo".
 * @author SenWang
 *
 */
public class SimplifyPath {
    /**
     * this is my own solution to this question.
     */
    public static String solution(String path) {
        if (path == null || path.length() == 0) {
            return null;
        }
        String result = "/";
        String[] array = path.split("/");
        Deque<String> stack = new ArrayDeque<String>();
        for (String str : array) {
            if (str.length() > 0) {
                if (str.equals("..") && stack.size() > 0) {
                    stack.pop();
                } else if (!str.equals(".") && !str.equals("..")){
                    stack.push(str);
                }
            }
        }
        String temp = "";
        while (stack.size() > 0) {
            temp = stack.pop() + temp;
            if (stack.size() >= 1) {
                temp = "/" + temp;
            }
        }
        return result + temp;
    }
    /**
     * this is the reference solution to this question, which uses same idea as mine but code
     * is much simplified.
     */
    public static String solutionRef(String path) {
        Deque<String> stack = new ArrayDeque<String>();
        Set<String> skip = new HashSet<String>();
        String[] array = path.split("/");
        for (String str : array) {
            if (str.equals("..") && stack.size() > 0) {
                stack.pop();
            } else if (!skip.contains(str)) {
                stack.push(str);
            }
        }
        String res = "";
        for (String dir : stack) {
            res = "/" + dir + res;
        }
        return res.isEmpty() ? "/" : res;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
//        String test = "/home//foo/";
//        String test2 = "/../";
//        String test3 = "/home/";
        String test4 = "/a/./b/../../c/";
//        String[] array = test.split("/");
//        for (String str : array) {
//            System.out.println(str);
//        }
        System.out.println(solution(test4));
    }

}
