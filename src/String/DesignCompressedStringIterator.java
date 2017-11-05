/**
 *
 */
package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Design and implement a data structure for a compressed string iterator.
 * It should support the following operations: next and hasNext.
 * The given compressed string will be in the form of each letter followed by a positive integer
 * representing the number of this letter existing in the original uncompressed string.
 *
 * next() - if the original string still has uncompressed characters,
 * return the next letter; Otherwise return a white space.
 * hasNext() - Judge whether there is any letter needs to be uncompressed.
 *
 * Note:
 * Please remember to RESET your class variables declared in StringIterator, as static/class variables
 * are persisted across multiple test cases. Please see here for more details.
 *
 * Example:
 * StringIterator iterator = new StringIterator("L1e2t1C1o1d1e1");
 * iterator.next(); // return 'L'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 'e'
 * iterator.next(); // return 't'
 * iterator.next(); // return 'C'
 * iterator.next(); // return 'o'
 * iterator.next(); // return 'd'
 * iterator.hasNext(); // return true
 * iterator.next(); // return 'e'
 * iterator.hasNext(); // return false
 * iterator.next(); // return ' '
 * @author SenWang
 *
 */
public class DesignCompressedStringIterator {
    /**
     * the class solution
     */
    public static class StringIterator {
        /**
         *
         */
        private int index = 0;
        List<Character> charList = new ArrayList<Character>();
        List<Integer> intList = new ArrayList<Integer>();
        public StringIterator(String compressedString) {
            int i = 0;
            while (i < compressedString.length()) {
                if (Character.isDigit(compressedString.charAt(i))) {
                    String num = "";
                    while (i < compressedString.length() && Character.isDigit(compressedString.charAt(i))) {
                        num += compressedString.charAt(i);
                        i++;
                    }
                    intList.add(Integer.parseInt(num));
                } else {
                    charList.add(compressedString.charAt(i));
                    i++;
                }
            }
        }
        /**
         *
         * @return
         */
        public char next() {
            if (index >= charList.size()) {
                return ' ';
            }
            char result = charList.get(index);
            intList.set(index, intList.get(index) - 1);
            if (intList.get(index) == 0) {
                index++;
            }
            return result;
        }
        /**
         *
         * @return
         */
        public boolean hasNext() {
            return index < charList.size();
        }
    }
    /**
     * this is another reference solution to this question.
     */
    public static class StringIteratorRef {
        String res = null;
        int ptr = 0;
        int num = 0;
        char c = ' ';
        public StringIteratorRef(String compressedString) {
            res = compressedString;
        }

        public char next() {
            if (!hasNext()) {
                return ' ';
            }
            if (num == 0) {
                c = res.charAt(ptr++);
                while (ptr < res.length() && Character.isDigit(res.charAt(ptr))) {
                    num = num * 10 + res.charAt(ptr++) - '0';
                }
            }
            num--;
            return c;
        }

        public boolean hasNext() {
            return ptr != res.length() || num != 0;
        }
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String compressedString = "x6";
        @SuppressWarnings("unused")
        StringIterator iterator = new StringIterator(compressedString);
    }

}
