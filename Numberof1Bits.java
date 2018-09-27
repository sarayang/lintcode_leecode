package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-26.
 */
public class Numberof1Bits {

    public int hammingWeight(int n) {
        int counter = 0;
        while (n != 0) {
            counter += n %2;
            n = n / 2;
        }
        return counter;
    }

    // need to use global variable as a counter
    int counter = 0;
    public int hammingWeight_recusion(int n) {
        if (n == 0) {
            return counter;
        }
        counter += n % 2;
        return hammingWeight(n / 2);
    }

    public static void main(String[] args) {
        Numberof1Bits n = new Numberof1Bits();
        System.out.println(n.hammingWeight(11));
    }
}
