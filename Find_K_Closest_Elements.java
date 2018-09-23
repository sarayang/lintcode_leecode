package lintcode.lintcode_leecode;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by YANGSONG on 2018-09-21.
 */
public class Find_K_Closest_Elements {
    // not sure if this will be accepted by the interviewer......sigh...
    public int[] kClosestNumbers(int[] A, int target, int k) {
        // use Collections.sort to sort elements in A via the distance of k
        List<Integer> arr = Arrays.stream(A).boxed().collect(Collectors.toList());
        Collections.sort(arr, (a, b) -> a == b ? a - b : Math.abs(a - target) - Math.abs(b - target));
        arr = arr.subList(0, k);
        Arrays.sort(A);
        int[] a = arr.stream().mapToInt(i->i).toArray();

        return a;
    }


    // updated version using binary search tree to find the lowerbound of target.
    // from there, it will use two pointer to search the left and right side of the return index of bst.
    public int[] kClosestNumbers_bst(int[] A, int target, int k) {
        int[] result = new int[k];

        int left = binarysearch(A, 0, A.length - 1, target);
        int right = left + 1;

        for (int i = 0; i < k; i++) {
            if (isLeftClosest(A, left, right, target)) {
                result[i] = A[left];
                left--;
            } else {
                result[i] = A[right];
                right++;
            }
        }
        return result;
    }

    private boolean isLeftClosest(int[] arr, int left, int right, int target) {
        if (left > right) {
            return false;
        }

        if (left < 0) {
            return false;
        }

        if (right >= arr.length) {
            return true;
        }

        if (Math.abs(arr[left] - target) != Math.abs(arr[right] - target)) {
            return Math.abs(target - arr[left]) < Math.abs(target - arr[right]);
        }

        return true;
    }

    private int binarysearch(int[] a, int from, int to, int target) {
        if (from > to) {
            return -1;
        }

        while (from + 1 < to) {
            int mid = (from + to) / 2;
            if (target > a[mid]) {
                from = mid;
            } else {
                to = mid;
            }
        }

        if (a[to] < target) {
            return to;
        }

        if (a[from] < target) {
            return from;
        }

        return -1;
    }

    // this version also works
    private int binarysearch_withEqualSigns(int[] a, int from, int to, int target) {
        if (from > to) {
            return -1;
        }

        while (from + 1 < to) {
            int mid = (from + to) / 2;
            if (target >= a[mid]) {
                from = mid;
            } else {
                to = mid;
            }
        }

        if (a[from] <= target) {
            return from;
        }

        if (a[to] <= target) {
            return to;
        }

        return -1;
    }
}
