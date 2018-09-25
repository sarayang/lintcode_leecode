package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-24.
 */

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:

 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.

 11 is read off as "two 1s" or 21.

 21 is read off as "one 2, then one 1" or 1211.

 Given an integer n, generate the nth sequence.

 Example
 Given n = 5, return "111221".

 Notice
 The sequence of integers will be represented as a string.
 */

public class CountandSay {
    /**
     * @param n: the nth
     * @return: the nth sequence
     */
    public String countAndSay(int n) {
        int i = 1;
        String res = "1";

        while (i < n) {
            char c = res.charAt(0);
            int count = 0;
            StringBuffer sb = new StringBuffer();
            for (int j = 0; j <= res.length(); j++) {
                if (j != res.length() && res.charAt(j) == c) {

                    count++;
                } else {

                    sb.append(count);
                    sb.append(c);
                    if (j < res.length()) {
                        count = 1;
                        c = res.charAt(j);
                    }
                }
            }
            i++;
            res = sb.toString();
        }
        return res;
    }
}
