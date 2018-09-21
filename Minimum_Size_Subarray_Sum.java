package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-19.
 */
public class Minimum_Size_Subarray_Sum {
    public int minimumSize(int[] nums, int s) {
        if (nums.length == 0 && nums == null) {
            return -1;
        }

        int ans = Integer.MAX_VALUE;
        int sum = 0;

        for (int i = 0, j = 0; j < nums.length; j++) {
            sum += nums[j];
            while (sum >= s) {
                ans = Math.min(ans, j - i + 1);
                sum -= nums[i];
                i++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
