/**
 *
 */
package HashTable;

import java.util.HashMap;
import java.util.Map;

/**
 * TinyURL is a URL shortening service where you enter a URL such as https://leetcode.com/problems/design-tinyurl
 * and it returns a short URL such as http://tinyurl.com/4e9iAk.
 * Design the encode and decode methods for the TinyURL service.
 * There is no restriction on how your encode/decode algorithm should work.
 * You just need to ensure that a URL can be encoded to a tiny URL and the tiny URL can be decoded to the original URL.
 * @author SenWang
 *
 */
public class EncodeAndDecodeTinyURL {
    /**
     * this is my own solution to this question, which use a simple counter
     */
    public static class Codec {
        /**
         *
         */
        private Map<Integer, String> map = new HashMap<>();
        private int counter = -1;
        /**
         *
         * @param longUrl
         * @return
         */
        public String encode(String longUrl) {
            counter++;
            map.put(counter, longUrl);
            return "http://tinyurl.com/" + counter;
        }
        /**
         *
         */
        public String decode(String shortUrl) {
            int index = Integer.parseInt(shortUrl.replace("http://tinyurl.com/", ""));
            return map.get(index);
        }
    }
    /**
     * other reference solutions are easy to understandm such as using hashcode or random number function.
     */
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub

    }

}
