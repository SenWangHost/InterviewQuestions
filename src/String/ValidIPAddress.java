/**
 *
 */
package String;

/**
 * Write a function to check whether an input string is a valid IPv4 address or IPv6 address or neither.
 *
 * IPv4 addresses are canonically represented in dot-decimal notation, which consists of four decimal numbers,
 * each ranging from 0 to 255, separated by dots ("."), e.g.,172.16.254.1;
 * Besides, leading zeros in the IPv4 is invalid. For example, the address 172.16.254.01 is invalid.
 *
 * IPv6 addresses are represented as eight groups of four hexadecimal digits, each group representing 16 bits.
 * The groups are separated by colons (":").
 * For example, the address 2001:0db8:85a3:0000:0000:8a2e:0370:7334 is a valid one.
 * Also, we could omit some leading zeros among four hexadecimal digits and some low-case characters in the address
 * to upper-case ones, so 2001:db8:85a3:0:0:8A2E:0370:7334 is also a valid IPv6 address(Omit leading zeros and using upper cases).
 * However, we don't replace a consecutive group of zero value with a single empty group using two consecutive colons (::)
 * to pursue simplicity. For example, 2001:0db8:85a3::8A2E:0370:7334 is an invalid IPv6 address.
 * Besides, extra leading zeros in the IPv6 is also invalid. For example, the address 02001:0db8:85a3:0000:0000:8a2e:0370:7334
 * is invalid.
 * Note: You may assume there is no extra space or special characters in the input string.
 * @author SenWang
 *
 */
public class ValidIPAddress {
    /**
     * This is my own solution to this question.
     * @param IP the input IP address to be considered.
     * @return IPv4, IPv6 or neither.
     */
    public static String solution(String IP) {
        String[] v4 = IP.split("\\.");
        String[] v6 = IP.split(":");
        if (v4.length == 4) {
            if (IP.charAt(IP.length() - 1) == '.') {
                return "Neither";
            }
            for (String number : v4) {
                // check the empty number
                if (number.length() == 0) {
                    return "Neither";
                }
                // check leading zeros
                if (number.charAt(0) == '0' && number.length() != 1) {
                    return "Neither";
                }
                int num = 0;
                for (int i = 0; i < number.length(); i++) {
                    char temp = number.charAt(i);
                    if (temp < '0' || temp > '9') {
                        return "Neither";
                    } else {
                        num = num * 10 + temp - '0';
                    }
                }
                if (num > 255 || num < 0) {
                    return "Neither";
                }
            }
            return "IPv4";
        } else if (v6.length == 8) {
            if (IP.charAt(IP.length() - 1) == ':') {
                return "Neither";
            }
            for (String number : v6) {
                // check the length of the number.
                if (number.length() > 4 || number.length() == 0) {
                    return "Neither";
                }
                for (int i = 0; i < number.length(); i++) {
                    char temp = number.charAt(i);
                    if (temp >= '0' && temp <= '9') {
                        continue;
                    } else if (temp >= 'a' && temp <= 'f') {
                        continue;
                    } else if (temp >= 'A' && temp <= 'F') {
                        continue;
                    } else {
                        return "Neither";
                    }
                }
            }
            return "IPv6";
        } else {
            return "Neither";
        }
    }
    /**
     * This is one of the reference solution to this question, which uses
     * regular expression.
     * @param IP the input IP address to be considered.
     * @return IPv4, IPv6 or neither.
     */
    public static String solutionRef(String IP) {
        if (IP.matches("(([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])\\.){3}([0-9]|[1-9][0-9]|1[0-9][0-9]|2[0-4][0-9]|25[0-5])")) {
            return "IPv4";
        }
        if (IP.matches("(([0-9a-fA-F]{1,4}):){7}([0-9a-fA-F]{1,4})")) {
            return "IPv6";
        }
        return "Neither";
    }
    /**
     * This is the test function for this question.
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        String test = "172.32";
        String result = ValidIPAddress.solution(test);
        System.out.println(result);
        String test2 = "asdasd";
        String[] array = test2.split("\\.");
        System.out.println(array.length);
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}
