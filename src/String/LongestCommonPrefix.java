/**
 *
 */
package String;

import java.util.Arrays;

/**
 * Write a function to find the longest common prefix string amongst an array of strings.
 * @author SenWang
 *
 */
public class LongestCommonPrefix {
    /**
     * This is my own solution to this question.
     * @param strs an array of strings to be considered.
     * @return the longest common prefix string among them.
     */
    public static String solution(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
            char temp = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                // handle the case where some strings are shorter than others.
                if (i >= strs[j].length()) {
                    return result.toString();
                }
                char comp = strs[j].charAt(i);
                if (temp != comp) {
                    return result.toString();
                }
            }
            result.append(temp);
        }
        return result.toString();
    }
    /**
     * This is one of the reference solution to this question, which sort the
     * string array first and only compare the first and last string to find
     * the longest common prefix
     * @param strs an array of strings to be considered.
     * @return the longest common prefix string among them.
     */
    public static String solutionRef(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs!= null && strs.length > 0){
            // sort the string array
            Arrays.sort(strs);
            // the first string and the last string in the array.
            char [] a = strs[0].toCharArray();
            char [] b = strs[strs.length-1].toCharArray();
            // find the longest common prefix.
            for (int i = 0; i < a.length; i ++){
                if (b.length > i && b[i] == a[i]){
                    result.append(b[i]);
                }
                else {
                    return result.toString();
                }
            }
        }
        return result.toString();
    }
    /**
     * This is one of the reference solution that use the divide and
     * conquer algorithm and use recursion to solve this question.
     * @param strs an array of strings to be considered.
     * @return the longest common prefix string among them.
     */
    public static String solutionRef2(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }
        return longestCommonPrefix(strs, 0, strs.length - 1);
    }
    /**
     * This is the recursive helper function for this reference solution.
     * @param strs the array of strings to be considered.
     * @param l the left index of consideration.
     * @param r the right index of consideration.
     * @return the longest common prefix among the array of strings.
     */
    private static String longestCommonPrefix(String[] strs, int l, int r) {
        // the base case
        if (l == r) {
            return strs[l];
        }
        int mid = (l + r) / 2;
        String lcpLeft = longestCommonPrefix(strs, l, mid);
        String lcpRight = longestCommonPrefix(strs, mid + 1, r);
        return commonPrefix(lcpLeft, lcpRight);
    }
    /**
     * This is the helper function to extract the common prefix between
     * two strings.
     * @param str1 the first string to be considered.
     * @param str2 the second string to be considered.
     * @return the common prefix between the two strings.
     */
    private static String commonPrefix(String str1, String str2) {
        int len = Math.min(str1.length(), str2.length());
        StringBuilder result = new StringBuilder("");
        for (int i = 0; i < len; i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                result.append(str1.charAt(i));
            } else {
                return result.toString();
            }
        }
        return result.toString();
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String[] test = {"aa", "a", ""};
        String result = LongestCommonPrefix.solutionRef2(test);
        System.out.println(result);
    }

}
