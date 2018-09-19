package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-17.
 */
public class binary_search_tree {
    public int binarySearchTree(int[] array, int target) {
        int start = 0;
        int end = array.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (target < array[mid]) {
                end = mid;
            } else if (target > array[mid]) {
                start = mid;
            } else {
                return mid;
            }


//            if (array[mid] == target) {
//                return mid;
//            } else if (array[mid] < target) {
//                start = mid;
//            } else {
//                end = mid;
//            }
        }

        if (array[start] == target) {
            return start;
        }

        if (array[end] == target) {
            return end;
        }

        // we do not find target in array
        return -1;
    }

    public int findPosition(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int start = 0, end = nums.length - 1;
        // 要点1: start + 1 < end
        while (start + 1 < end) {
            // 要点2：start + (end - start) / 2
            int mid = start + (end - start) / 2;
            // 要点3：=, <, > 分开讨论，mid 不+1也不-1
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        // 要点4: 循环结束后，单独处理start和end
        if (nums[start] == target) {
            return start;
        }
        if (nums[end] == target) {
            return end;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7};
        binary_search_tree bst = new binary_search_tree();
        System.out.println(bst.binarySearchTree(arr, 1));
    }
}
