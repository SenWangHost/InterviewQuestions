/**
 *
 */
package String;

/**
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 *
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of
 * the second first-level revision.
 *
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * @author SenWang
 *
 */
public class CompareVersionNumbers {
    /**
     * This is my own solution to this question.
     * @param version1 the string representation of first version number.
     * @param version2 the string representation of second version number.
     * @return 1 if version1 > version2, -1 if version1 < version2, else 0.
     */
    public static int solution(String version1, String version2) {
        String[] array1 = version1.split("\\.");
        String[] array2 = version2.split("\\.");
        int length = Math.max(array1.length, array2.length);
        int[] v1 = new int[length];
        int[] v2 = new int[length];
        for (int i = 0; i < array1.length;i++) {
            v1[i] = Integer.parseInt(array1[i]);
        }
        for (int i = 0; i < array2.length;i++) {
            v2[i] = Integer.parseInt(array2[i]);
        }
        for (int i = 0; i < length; i++) {
            if (v1[i] > v2[i]) {
                return 1;
            } else if (v1[i] < v2[i]) {
                return -1;
            } else {
                continue;
            }
        }
        return 0;
    }
    /**
     * This is one of the reference solution to this question, which
     * doesn't use split function, but use two index to extract the number
     * for the strings.
     * @param version1 the string representation of first version number.
     * @param version2 the string representation of second version number.
     * @return 1 if version1 > version2, -1 if version1 < version2, else 0.
     */
    public static int solutionRef(String version1, String version2) {
        int length1 = version1.length();
        int length2 = version2.length();
        int index1 = 0;
        int index2 = 0;
        while (index1 < length1 || index2 < length2) {
            int number1 = 0;
            int number2 = 0;
            while (index1 < length1 && version1.charAt(index1) != '.') {
                number1 = 10 * number1 + version1.charAt(index1) - '0';
                index1++;
            }
            while (index2 < length2 && version2.charAt(index2) != '.') {
                number2 = 10 * number2 + version2.charAt(index2) - '0';
                index2++;
            }
            if (number1 > number2) {
                return 1;
            } else if (number1 < number2) {
                return -1;
            } else {
                index1++;
                index2++;
            }
        }
        return 0;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String version1 = "0.1";
        String version2 = "0.1";
        int result = CompareVersionNumbers.solution(version1, version2);
        System.out.println(result);
    }
}
