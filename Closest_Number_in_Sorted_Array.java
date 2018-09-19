package lintcode.lintcode_leecode;

/**
 * Created by YANGSONG on 2018-09-17.
 */
public class Closest_Number_in_Sorted_Array {
    public int closestNumber(int[] A, int target) {
        int lowerboundIndex = findLowerbound(A, target);
        if (lowerboundIndex == -1) {
            return -1;
        }

        if (lowerboundIndex == -1) {
            return 0;
        }

        if (lowerboundIndex + 1 == A.length) {
            return lowerboundIndex;
        }

        return Math.abs(A[lowerboundIndex] - target) <= Math.abs(A[lowerboundIndex + 1] - target) ?
                lowerboundIndex : lowerboundIndex + 1;
    }

    private int findLowerbound(int[] array, int target) {
        if (array.length == 0) {
            return -1;
        }

        int start = 0;
        int end = array.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (array[mid] <= target) {
                start = mid;
            } else {
                end = mid;
            }
        }

        if (array[start] <= target) {
            return start;
        }

        if (array[end] <= target) {
            return end;
        }

        return -1;
    }

    public static void main(String[] args) {
        Closest_Number_in_Sorted_Array c = new Closest_Number_in_Sorted_Array();
        int[] arr = {22,25,100,209,1000,1110,1111};
        System.out.println(c.closestNumber(arr, 15));
    }
}
