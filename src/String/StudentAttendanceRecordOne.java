/**
 *
 */
package String;

/**
 * You are given a string representing an attendance record for a student.
 * The record only contains the following three characters:
 * 'A' : Absent.
 * 'L' : Late.
 * 'P' : Present.
 * A student could be rewarded if his attendance record doesn't contain more than one 'A' (absent) or more than
 * two continuous 'L' (late).
 * You need to return whether the student could be rewarded according to his attendance record.
 * @author SenWang
 *
 */
public class StudentAttendanceRecordOne {
    /**
     * This is my own solution to this question.
     * @param s the input string to be considered.
     * @return true if the student could be awarded, false otherwise.
     */
    public static boolean solution(String s) {
        int countA = 0;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == 'A') {
                countA++;
            }
            if (temp == 'L') {
                int index = i;
                int countL = 0;
                while (index < s.length() && s.charAt(index) == 'L') {
                    countL++;
                    index++;
                }
                if (countL > 2) {
                    return false;
                }
            }
        }
        if (countA > 1) {
            return false;
        }
        return true;
    }
    /**
     * This is one of the reference solution that just uses java string function.
     * @param s the input string to be considered.
     * @return true if the student could be awarded, false otherwise.
     */
    public static boolean solutionRef(String s) {
        if (s.indexOf('A') != s.lastIndexOf('A') || s.contains("LLL")) {
            return false;
        }
        return true;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test1 = "PPALLP";
        String test2 = "PPALLL";
        boolean result1 = StudentAttendanceRecordOne.solution(test1);
        boolean result2 = StudentAttendanceRecordOne.solution(test2);
        System.out.println(result1);
        System.out.println(result2);
    }

}
