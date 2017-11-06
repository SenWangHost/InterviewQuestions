/**
 *
 */
package String;

import java.util.ArrayList;
import java.util.List;

/**
 * You are playing the following Flip Game with your friend: Given a string that contains only these two
 * characters: + and -, you and your friend take turns to flip two consecutive "++" into "--".
 * The game ends when a person can no longer make a move and therefore the other person will be the winner.
 * Write a function to compute all possible states of the string after one valid move.
 *
 * For example, given s = "++++", after one move, it may become one of the following states:
 * [
 *  "--++",
 *  "+--+",
 *  "++--"
 * ]
 * If there is no valid move, return an empty list [].
 * @author SenWang
 *
 */
public class FlipGame {
    /**
     * this is my own solution to this question.
     */
    public static List<String> solution(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 2) {
            return result;
        }
        int index = 0;
        while (index < s.length()) {
            if (index + 1 < s.length() && s.charAt(index) == '+' && s.charAt(index + 1) == '+') {
                result.add(s.substring(0, index) + "--" + s.substring(index + 2));
            }
            index++;
        }
        return result;
    }
    /**
     * this is the reference solution to this question.
     */
    public static List<String> solutionRef(String s) {
        List<String> list = new ArrayList<>();
        for (int i=-1; (i = s.indexOf("++", i+1)) >= 0; )
            list.add(s.substring(0, i) + "--" + s.substring(i+2));
        return list;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
