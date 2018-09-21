package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Move_Zeroes {
    public void moveZeroes(int[] nums) {
        // write your code here

        int nonZero = 0;

        int currentZero = nextZeroIndex(nums, 0);

        while(nonZero < nums.length) {
            if (nums[nonZero] != 0 && nonZero > currentZero) {
                nums = swap(nums, nonZero, currentZero);
                currentZero = nextZeroIndex(nums, currentZero);

            }
            nonZero++;
        }
    }

    private int[] swap(int[] num, int a, int b) {
        System.out.println(Integer.toString(a) + "|" + Integer.toString(b));
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
        return num;
    }

    private int nextZeroIndex(int[] nums, int zero) {
        while(zero < nums.length) {
            if (nums[zero] != 0) {
                zero++;
            } else {
                break;
            }
        }
        return zero;
    }
}
