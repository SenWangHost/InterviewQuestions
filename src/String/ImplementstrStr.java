/**
 *
 */
package String;

/**
 * Implement strStr().
 * Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 * @author SenWang
 *
 */
public class ImplementstrStr {
    /**
     * This is my own solution to this question.
     * @param haystack the string to be searched in for needle
     * @param needle the needle to be searched
     * @return the index of the first occurrence of the needle, -1 if the needle
     * is not part of the haystack
     */
    public static int solution(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (haystack.length() == 0) {
            return -1;
        }
        int index = 0;
        // use mark to go back and examine other parts
        int mark = -1;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(index)) {
                if (index == 0) {
                    mark = i;
                }
                index++;
                if (index >= needle.length()) {
                    return i - needle.length() + 1;
                }
            } else {
                index = 0;
                if (mark != -1) {
                    i = mark;
                    mark = -1;
                }
            }
        }
        return -1;
    }
    /**
     * This is the reference solution for this question. It beats 77% of the solution.
     * @param haystack the string to be searched in for needle
     * @param needle the needle to be searched
     * @return the index of the first occurrence of the needle, -1 if the needle
     * is not part of the haystack
     */
    public static int solutionRef(String haystack, String needle) {
        int l1 = haystack.length(), l2 = needle.length();
        // two special cases for haystack and needle.
        if (l1 < l2) {
            return -1;
        } else if (l2 == 0) {
            return 0;
        }
        int threshold = l1 - l2;
        // make use of substring method and string equal method
        for (int i = 0; i <= threshold; ++i) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                if (haystack.substring(i,i+l2).equals(needle)) {
                    return i;
                }
            }

        }
        return -1;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String haystack = "aaa";
        String needle = "aaaa";
        int result = ImplementstrStr.solution(haystack, needle);
        System.out.println(result);
    }

}
