/**
 *
 */
package BitManipulation;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG".
 * When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 *
 * For example,
 * Given s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT",
 * Return:
 * ["AAAAACCCCC", "CCCCCAAAAA"].
 * @author SenWang
 *
 */
public class RepeatedDNASequence {
    /**
     * This is one of the reference solution to this question, which uses hash set to keep
     * track of the seen pattern.
     * @param s the string representation of DNA sequence.
     * @return a list containing all the 10-letter-long sequences that occur more than once.
     */
    public static List<String> solutionRef(String s) {
        Set<String> seen = new HashSet<String>();
        Set<String> repeated = new HashSet<String>();
        for (int i = 0; i + 9 < s.length(); i++) {
            String sub = s.substring(i, i + 10);
            if (seen.contains(sub)) {
                repeated.add(sub);
            } else {
                seen.add(sub);
            }
        }
        return new ArrayList<String>(repeated);
    }
    /**
     * This is another reference solution to this question, which uses
     * hash map and bit manipulation, which encodes the four letter like the following:
     * A -> 00, C -> 01, G -> 10, T -> 11. Thus, a substring such as AACCTCCGGT will be
     * encoded as 00 00 01 01 11 01 01 10 10 11 = 23915 (decimal)
     * @param s the string representation of DNA sequence.
     * @return a list containing all the 10-letter-long sequences that occur more than once.
     */
    public static List<String> solutionRef2(String s) {
        Set<Integer> seen = new HashSet<Integer>();
        Set<Integer> repeated = new HashSet<Integer>();
        List<String> result = new ArrayList<String>();
        char[] map = new char[26];
        // map['A' - 'A'] = 0;
        map['C' - 'A'] = 1;
        map['G' - 'A'] = 2;
        map['T' - 'A'] = 3;
        for (int i = 0; i + 9 < s.length(); i++) {
            // encode the string into integer
            int hash = 0;
            for (int j = i; j < i + 10; j++) {
                hash <<= 2;
                hash |= map[s.charAt(j) - 'A'];
            }
            if (!seen.add(hash) && repeated.add(hash)) {
                result.add(s.substring(i, i + 10));
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
        String test = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT";
        List<String> result = RepeatedDNASequence.solutionRef(test);
        for (String str : result) {
            System.out.println(str);
        }
    }

}
