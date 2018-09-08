package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-07.
 */
public class QuickSort {

    public void quickSort(int[] nums, int start, int end) {
        if (nums == null) {
            return;
        }

        int pivot = nums[start + (end - start) / 2];

        while (start <= end) {
            while (start <= end && nums[start] < pivot) {
                start++;
            }

            while (start <= end && nums[end] > pivot) {
                end--;
            }

            if (start <= end) {
                int tmp = nums[start];
                nums[start] = nums[end];
                nums[end] = tmp;
                start++;
                end--;
            }
        }

        quickSort(nums, 0, end);
        quickSort(nums, start, nums.length - 1);

    }

    public static void main(String[] args) {
        String s = "yangsong";
        String substring = s.substring(3);
        System.out.println(substring);
    }
}
