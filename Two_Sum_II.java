package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Two_Sum_II {
    public int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        int[] result = new int[2];
        while (left < right) {
            if (nums[left] + nums[right] < target) {
                left++;
            } else if (nums[left] + nums[right] > target) {
                right--;
            } else {
                result[0] = left + 1;
                result[1] = right + 1;
                break;
            }
        }
        return result;
    }
}
