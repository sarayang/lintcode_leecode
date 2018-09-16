package lintcode.lintcode_leecode;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-09-08.
 */
public class Sort_Colors_II {
    public void sortColors2(int[] colors, int k) {
        if (colors == null || colors.length <= 1) {
            return;
        }
        // three pointers special case
        int min = 1;
        int max = k;

        int left = 0;
        int right = colors.length - 1;
        int current = 0;
        while (min <= max) {
            while (current <= right) {
                if (colors[current] == min) {
                    swap_index(colors, current, left);
                    current++;
                    left++;
                } else if (colors[current] == max) {
                    swap_index(colors, current, right);
                    right--;
                } else {
                    current++;
                }

            }
            current = left;
            min++;
            max--;
        }

    }


    private void swap_index(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }

    public static void main(String[] args) {
        Sort_Colors_II s =  new Sort_Colors_II();
        int[] nums = {1,2,2,1,1,2,2};
        s.sortColors2(nums, 2);

    }
}
