/**
 *
 */
package Math;

/**
 * Convert a non-negative integer to its english words representation.
 * Given input is guaranteed to be less than 2^31 - 1.
 * For example,
 * 123 -> "One Hundred Twenty Three"
 * 12345 -> "Twelve Thousand Three Hundred Forty Five"
 * 1234567 -> "One Million Two Hundred Thirty Four Thousand Five Hundred Sixty Seven"
 * @author SenWang
 *
 */
public class IntegerToEnglishWords {
    /**
     * this is my own solution to this question
     */
    public static String solution(int num) {
        if (num < 1000) {
            return lessThanThousand(num);
        }
        String[] digits = {"Billion","Million","Thousand"};
        int count = 0;
        int div = 1000000000;
        String result = "";
        while (num > 0 && div != 0) {
            int val = num / div;
            if (val != 0) {
                if (count < 3) {
                    result += lessThanThousand(val) + " " + digits[count] + " ";
                } else {
                    result += lessThanThousand(val);
                }
                num %= div;
            }
            div /= 1000;
            count += 1;
        }
        return result;
    }
    /**
     * the method to convert number that is less than twenty
     */
    private static String lessThanTwenty(int num) {
        if (num >= 20) {
            return null;
        }
        String[] array = {"Zero","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                            "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                            "Eighteen","Nineteen"};
        return array[num];
    }
    /**
     * the method to convert 20 to 99
     */
    private static String lessThanHundred(int num) {
        if (num >= 100) {
            return null;
        }
        String[] onedigit = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        String[] tenthdigit = {"Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if (num % 10 == 0) {
            return tenthdigit[num / 10 - 2];
        } else {
            return tenthdigit[num / 10 - 2] + " " + onedigit[num % 10 - 1];
        }
    }
    /**
     * the method to convert number less than one thousand
     */
    private static String lessThanThousand(int num) {
        if (num < 20) {
            return lessThanTwenty(num);
        }
        if (num < 99) {
            return lessThanHundred(num);
        }
        if (num < 100) {
            return lessThanHundred(num);
        }
        if (num >= 1000) {
            return null;
        }
        String[] onedigit = {"One","Two","Three","Four","Five","Six","Seven","Eight","Nine"};
        if (num % 100 == 0) {
            return onedigit[num / 100 - 1] + " Hundred";
        } else {
            String result = onedigit[num / 100 - 1] + " Hundred";
            if (num % 100 < 20) {
                return result + " " + lessThanTwenty(num % 100);
            } else {
                return result + " " + lessThanHundred(num % 100);
            }
        }
    }
    /**
     * this is reference solution to this question, the idea is the same as mine
     * but code is much more clear and compact
     */
    public static String solutionRef(int num) {
        if (num == 0) {
            return "Zero";
        }
        String[] thousands = {"","Thousand", "Million", "Billion"};
        int i = 0;
        String result = "";
        while (num > 0) {
            if (num % 1000 != 0)
                result = solutionHelper(num % 1000) + thousands[i] + " " + result;
            num /= 1000;
            i++;
        }

        return result.trim();
    }
    /**
     * this is the helper function to the reference solution, which converts
     * the number less than 1000
     */
    private static String solutionHelper(int num) {
        String[] lessThan20 = {"","One","Two","Three","Four","Five","Six","Seven","Eight","Nine",
                "Ten","Eleven","Twelve","Thirteen","Fourteen","Fifteen","Sixteen","Seventeen",
                "Eighteen","Nineteen"};
        String[] tens = {"","Ten","Twenty","Thirty","Fourty","Fifty","Sixty","Seventy","Eighty","Ninety"};
        if (num == 0) {
            return "";
        } else if (num < 20) {
            return lessThan20[num] + " ";
        } else if (num < 100) {
            return tens[num / 10] + " " + solutionHelper(num % 10);
        } else {
            return lessThan20[num / 100] + " Hundred " + solutionHelper(num % 100);
        }
    }
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        int test = 2147483647;
        System.out.println(solution(test));
    }

}
