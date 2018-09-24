package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-23.
 */
public class LetterCombinations_of_a_Phone_Number {
    public List<String> letterCombinations(String digits) {
        String[] phone = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> result = new ArrayList<>();
        if (digits.length() == 0) {
            return result;
        }

        dfs(0, digits.length(), digits, phone, "", result);
        return result;
    }

    private void dfs(int x, int len, String digits, String[] dic, String word, List<String> result) {
        if (word.length() == len) {
            result.add(word);
            return;
        }

        int d = digits.charAt(x) - '0';
        for (char c : dic[d].toCharArray()) {
            dfs(x + 1, len, digits, dic, word + c, result);
        }
    }
}
