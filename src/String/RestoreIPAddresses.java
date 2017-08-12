/**
 *
 */
package String;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
 * For example:
 * Given "25525511135",
 * return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)
 * @author SenWang
 *
 */
public class RestoreIPAddresses {
    /**
     * This is one simple reference solution to this question. The idea is to use
     * three cuts to separate the string.
     * @param s the input string to be checked.
     * @return the list of string containing all possible valid IP addresses.
     */
    public static List<String> solutionRef(String s) {
        List<String> result = new ArrayList<String>();
        int length = s.length();
        for (int i = 1; i <= 3; i++) {
            if (length - i > 9) {
                continue;
            }
            for (int j = i + 1; j <= i + 3; j++) {
                if (length - j > 6) {
                    continue;
                }
                for (int k = j + 1; k <= j + 3 && k < length; k++) {
                    // the four int's separated by "."
                    int a,b,c,d;
                    // notice that "01" can be parsed into 1. Need to deal with that later.
                    a = Integer.parseInt(s.substring(0, i));
                    b = Integer.parseInt(s.substring(i, j));
                    c = Integer.parseInt(s.substring(j, k));
                    d = Integer.parseInt(s.substring(k));
                    if (a > 255 || b > 255 || c > 255 || d > 255) {
                        continue;
                    }
                    String ip = a + "." + b + "." + c + "." + d;
                    // this is to reject those int's parsed from "01" or "00"-like substrings
                    if (ip.length() < length + 3) {
                        continue;
                    }
                    result.add(ip);
                }
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
        String test = "25525511135";
        List<String> result = RestoreIPAddresses.solutionRef(test);
        Iterator<String> iter = result.iterator();
        while (iter.hasNext()) {
            System.out.println(iter.next());
        }
    }
}
