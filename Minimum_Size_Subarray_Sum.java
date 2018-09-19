package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-19.
 */
public class Minimum_Size_Subarray_Sum {
    public int minimumSize(int[] nums, int s) {
        int sum = 0;
        int ans = Integer.MAX_VALUE;

        for (int left = 0, right = 0; right < nums.length; right++) {
            sum += nums[right];

            while (sum >= s) {
                ans = Math.min(ans, right - left + 1);
                sum -= nums[left];
                left++;
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;

    }
}
