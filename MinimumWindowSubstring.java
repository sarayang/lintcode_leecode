package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-26.
 */
public class MinimumWindowSubstring {
    public String minWindow(String source , String target) {
        if (source.length() == 0 || source == null) {
            return "";
        }

        if (target.length() == 0 || target == null) {
            return source;
        }

        int[] targetHash = new int[256];
        int[] sourceHash = new int[256];
        intialTargetHash(target, targetHash);

        int minLen = Integer.MAX_VALUE;
        String result = "";
        int j = 0;
        for (int i = 0; i < source.length(); i++) {
            while (j < source.length() && !isValid(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }
            if (isValid(sourceHash, targetHash)) {
                if (minLen > j - i) {
                    minLen = Math.min(minLen, j - i);
                    result = source.substring(i, j);
                }
            }
            sourceHash[source.charAt(i)]--;
        }

        return result;
    }

    private void intialTargetHash(String target, int[] targets) {
        for (char c : target.toCharArray()) {
            targets[c]++;
        }
    }

    private boolean isValid(int[] sourceHash, int[] targetHash) {
        for (int i = 0; i < 256; i++) {
            if (sourceHash[i] < targetHash[i]) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        MinimumWindowSubstring m = new MinimumWindowSubstring();
        String s = "ADEBAC";
        String t = "ABC";
        System.out.println(m.minWindow(s, t));
    }
}
