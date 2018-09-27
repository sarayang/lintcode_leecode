package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-25.
 *
 * 1255. Remove K Digits
 Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

 Example 1:

 Input: num = "1432219", k = 3
 Output: "1219"
 Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
 Example 2:

 Input: num = "10200", k = 1
 Output: "200"
 Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.
 Example 3:

 Input: num = "10", k = 2
 Output: "0"
 Explanation: Remove all the digits from the number and it is left with nothing which is 0.
 Notice
 The length of num is less than 10002 and will be ≥ k.
 The given num does not contain any leading zero.
 */
public class RemoveKDigits {
    /**
     * @param num: a string
     * @param k: an integer
     * @return: return a string
     */
    // 1. use a stack to store all the element which in a ascending order.
    // 2. if you realized that the current check number is smaller than the top number in the stack, keep
    //    poping it until either the stack is empty or k = 0 or top < current check number.
    // 3. as long as the current number is less than the top number in the stack, pop the top one and reduce the k to k - 1;

    // corner case 1: remove 0's before an actual number
    // corner case 2: return "0" instead of "" remove all numbers from num, which is num.length() == k

    /**
     * 中文版解释：
     * 基本想法就是use a stack to keep一个increasing number chain，只要发现当前要check vaule is less than stack.peekLast() keep poping top
     * from the stack. the check condition is mentioned as above.
     * @param num
     * @param k
     * @return
     */
    public String removeKdigits(String num, int k) {
        if (num.length() == 0) {
            return num;
        }

        if (k == 0) {
            return num;
        }
        char[] chas = num.toCharArray();
        Deque<Integer> stack = new LinkedList<>();
        stack.offer(Character.getNumericValue(chas[0]));
        for (int j = 1; j < chas.length; j++) {
            while (k > 0
                    && !stack.isEmpty()
                    && Character.getNumericValue(chas[j]) < stack.peekLast()) {
                stack.pollLast();
                k--;
            }
            stack.offer(Character.getNumericValue(chas[j]));
        }

        // if k > 0, we keep polling from the last end
        while(k > 0 && !stack.isEmpty()) {
            stack.pollLast();
            k--;
        }

        // make sure we do not have bunch of zeros in front of the real number
        while (!stack.isEmpty() && stack.peekFirst() == 0) {
            stack.pollFirst();
        }

        StringBuffer sb = new StringBuffer();
        while (!stack.isEmpty()) {
            sb.append(stack.pollFirst());
        }

        // if k = num.length(), return "0" instead of empty string.
        return sb.toString().equals("") ? "0": sb.toString();
    }
}
