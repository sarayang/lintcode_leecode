package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-19.
 */
public class Longest_Substring_Without_Repeating_Characters {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() <= 1) {
            return s.length();
        }

        int[] hash = new int[256];
        char[] charS = s.toCharArray();

        int ans = 0;
        int i = 0, j = 0;
        for (i = 0; i < charS.length; i++) {
            while (j < charS.length && hash[charS[j]] == 0) {
                hash[charS[j]] = 1;
                ans = Math.max(ans, j - i + 1);
                j++;
            }
            hash[charS[i]] = 0;
        }

        return ans;
    }
}
