package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-19.
 */
public class Longest_Substring_with_At_Most_K_Distinct_Characters {
    public int lengthOfLongestSubstringKDistinct(String s, int k) {
        int left = 0;
        int right = s.length();
        char[] chars = s.toCharArray();

        int sum = 0;
        int len = 0;
        int[] hash = new int[256];

        for (int i = 0, j = 0; j < chars.length; j++) {
            hash[chars[j]]++;
            if (hash[chars[j]] == 1) {
                sum++;
            }

            while (sum > k) {
                hash[chars[i]]--;
                if (hash[chars[i]] == 0) {
                    sum--;
                }
                i++;
            }

            len = Math.max(len, j - i + 1);
        }

        return len;
    }
}
