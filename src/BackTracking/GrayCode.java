/**
 *
 */
package BackTracking;

import java.util.ArrayList;
import java.util.List;

/**
 * The gray code is a binary numeral system where two successive values differ in only one bit.
 * Given a non-negative integer n representing the total number of bits in the code, print the sequence of
 *  gray code. A gray code sequence must begin with 0.
 *  For example, given n = 2, return [0,1,3,2]. Its gray code sequence is:
 *  00 - 0
 *  01 - 1
 *  11 - 3
 *  10 - 2
 *  Note:
 *  For a given n, a gray code sequence is not uniquely defined.
 *  For example, [0,2,3,1] is also a valid gray code sequence according to the above definition.
 *  For now, the judge is able to judge based on one instance of gray code sequence. Sorry about that.
 * @author SenWang
 *
 */
public class GrayCode {
    /**
     * This is the reference solution, which uses the formula for gray code.
     * @param n the number of bits limited to be used.
     * @return list of integer containing the results.
     */
    public static List<Integer> solution(int n) {
        List<Integer> result = new ArrayList<Integer>();
        for (int i = 0; i < (1 << n); i++) {
            result.add(i ^ (i >> 1));
        }
        return result;
    }
    /**
     * This is another solution to this question, which uses symmery.
     * @param n the number of bits limited to be used.
     * @return list of integer containing the results.
     */
    public static List<Integer> solution2(int n) {
        List<Integer> rs=new ArrayList<Integer>();
        rs.add(0);
        for(int i=0;i<n;i++){
            int size=rs.size();
            for(int k=size-1;k>=0;k--)
                rs.add(rs.get(k) | 1<<i);
        }
        return rs;
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
