package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Partition_Array {
    public int partitionArray(int[] nums, int k) {
        // write your code here
        int left = 0, right = nums.length - 1;
        while (left <= right) {

            while (left <= right && nums[left] < k) {
                left++;
            }
            // be careful of this "="", due to the description requirement
            while (left <= right && nums[right] >= k) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
            }
        }

        return left;


        // int pl = 0;
        // int pr = nums.length - 1;
        // while (pl <= pr) {
        //     while (pl <= pr && nums[pl] < k) {
        //         pl++;
        //     }
        //     while (pl <= pr && nums[pr] >= k) {
        //         pr--;
        //     }
        //     if (pl <= pr) {
        //         swap(pl, pr, nums);
        //     }
        // }
        // return pl;
    }

    private void swap(int i, int j, int[] arr) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private int partitionByK(int[] nums, int start, int end, int target) {
        if (start >= end) {
            return 0;
        }

        int left = start, right = end;
        while (left <= right) {

            while (left <= right && nums[left] < target) {
                left++;
            }
            while (left <= right && nums[right] > target) {
                right--;
            }

            if (left <= right) {
                int tmp = nums[left];
                nums[left] = nums[right];
                nums[right] = tmp;
                left++;
                right--;
            }
        }

        return left;
    }
}
