package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Sort_Colors {
    public void sortColors(int[] nums) {
        int start = 0;
        int end = nums.length - 1;
        int current = start;

        while (current <= end) {
            if (nums[current] == 0) {
                swap(nums, start, current);
                start++;
                current++;
            } else if (nums[current] == 1) {
                current++;
            } else {
                swap(nums, current, end);
                end--;
            }
        }
    }

    private void swap(int[] nums, int from, int to) {
        int tmp = nums[from];
        nums[from] = nums[to];
        nums[to] = tmp;
    }
}
