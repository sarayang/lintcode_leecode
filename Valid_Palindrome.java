package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Valid_Palindrome {
    public boolean isPalindrome(String s) {
        // double pointer to point the start and end
        int start = 0;
        int end = s.length() - 1;
        while (end > start) {
            while (start < s.length() && !isAlphanumeric(s.charAt(start))) {
                start++;
            }

            if (start == s.length()) {
                return true;
            }

            while (end >= 0 && !isAlphanumeric(s.charAt(end))) {
                end--;
            }

            if (Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    private boolean isAlphanumeric(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }

    // rewrote it second time
    public boolean isPalindrome_rewote(String s) {
        if (s == null || s.length() < 2) {
            return true;
        }
        int len = s.length();
        int start = 0;
        int end = s.length() - 1;
        while (start < end) {
            System.out.println(start + ", " + end);
            while (start < len && !isChar(s.charAt(start))) {
                start++;
            }

            while (end >= 0 && !isChar(s.charAt(end))) {
                end--;
            }

            if (start < len && end >= 0 &&
                    Character.toLowerCase(s.charAt(start)) != Character.toLowerCase(s.charAt(end))) {
                return false;
            }
            start++;
            end--;
        }

        return true;
    }

    private boolean isChar(char c) {
        return Character.isLetter(c) || Character.isDigit(c);
    }


}
