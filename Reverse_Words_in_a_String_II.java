package lintcode.lintcode_leecode;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-09-24.
 */
public class Reverse_Words_in_a_String_II {
    public void reverseWords(char[] str) {
        reverseStr(0, str.length - 1, str);

        System.out.println(Arrays.toString(str));

        int index = 0;
        for (int i = 0; i < str.length; i++) {
            if (str[i] != ' ') {
                continue;
            }
            reverseStr(index, i - 1, str);
            index = i + 1;
        }

        System.out.println(Arrays.toString(str));

        reverseStr(index, str.length - 1, str);

    }

    private void reverseStr(int start, int end, char[] str) {
        while (start <= end) {
            char tmp = str[start];
            str[start] = str[end];
            str[end] = tmp;
            start++;
            end--;
        }
    }
}
