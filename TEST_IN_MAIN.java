package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-20.
 */
public class TEST_IN_MAIN {
    public static void main(String[] args) {
        String s = ".bb.a";
        String t = ".";
        int counter = 0;
        for (char c : s.toCharArray()) {
            if (c == '.') {
               counter++;
            }

        }
        System.out.println(t.indexOf("."));
        System.out.println(s.indexOf("."));
        System.out.println(counter);
    }
}
