package lintcode.lintcode_leecode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * Created by YANGSONG on 2018-09-24.
 *
 423. Valid Parentheses
 Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

 Example
 The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
 */

public class ValidParentheses {
    /**
     * @param s: A string
     * @return: whether the string is a valid parentheses
     */
    public boolean isValidParentheses(String s) {
        if (s.length() % 2 == 1) {
            return false;
        }

        Deque<Character> stack = new LinkedList<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.offer(')');
            } else if (c == '{') {
                stack.offer('}');
            } else if (c == '[') {
                stack.offer(']');
            } else {
                if (stack.isEmpty() || stack.pollLast() != c) {
                    return false;
                }
            }
        }

        if (!stack.isEmpty()) {
            return false;
        }

        return true;
    }
}
