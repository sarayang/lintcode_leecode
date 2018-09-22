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
}
