package lintcode.lintcode_leecode;

import java.util.Arrays;

/**
 * Created by YANGSONG on 2018-09-12.
 */
public class Maximum_Subarray_Return_arrayIndex {
    // return an array containing the index of array whose value is the maximum value.
    public int[] getPrefixSumArray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int sum = 0, minSum = 0;
        int start = 0;
        int end = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - minSum);
            if (max == sum-minSum) {
                end = i;
            }
            minSum = Math.min(sum, minSum);

            if (minSum == sum) {
                start = i + 1;
            }
        }
//        System.out.println(max);
        int[] coor = new int[2];
        coor[0] = start;
        coor[1] = end;
        return coor;
    }

    public static void main(String[] args) {
        Maximum_Subarray_Return_arrayIndex m = new Maximum_Subarray_Return_arrayIndex();
        int[] input = {-2,2,-3,-1,3};
        int[] co = m.getPrefixSumArray(input);

//        System.out.println(Arrays.toString(co));

        String yang = "songya";
        int count = 0;
        for (char c : yang.toCharArray()) {
            System.out.println(c);
            int digit = c - 'A' + 1;
            count = count * 26 + digit;
            System.out.println(Integer.toString(count));
        }
    }
}
