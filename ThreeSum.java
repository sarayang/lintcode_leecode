package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-08.
 */
public class ThreeSum {

    // fix one pointer, use another two pointers to scan after the pointer index
    // be careful of the duplicated case, check if it contains duplication no matter moving which pointer
    public List<List<Integer>> threeSum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.length < 3) {
            return result;
        }
        Arrays.sort(numbers);
        final int target = 0;

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i - 1] == numbers[i]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;

            while (left < right) {
                if (numbers[i] + numbers[left] + numbers[right] < 0) {
                    left++;

                    while (numbers[left - 1] == numbers[left] && left < right) {
                        left++;
                    }
                } else if (numbers[i] + numbers[left] + numbers[right] > 0) {
                    right--;
                    while (numbers[right + 1] == numbers[right] && right > left) {
                        right--;
                    }
                } else {
                    result.add(Arrays.asList(numbers[i], numbers[left], numbers[right]));
                    left++;
                    right--;

                    while (numbers[right + 1] == numbers[right] && right > left) {
                        right--;
                    }
                    while (numbers[left - 1] == numbers[left] && left < right) {
                        left++;
                    }

                }

            }
        }
        return result;
    }

    // new version 3sum:
    // use two sum logic

    /**
     * sort numbers
     * use twosum idea
     * remove duplicated
     * @param numbers
     * @return
     */
    public List<List<Integer>> threeSum_via2sum(int[] numbers) {
        List<List<Integer>> result = new ArrayList<>();
        if (numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int start = i + 1;
            int end = numbers.length - 1;
            int target = numbers[i];
            System.out.println("iii: " + i);
            twosum(numbers, start, end, target, result);
        }
        return result;
    }

    private void twosum(int[] n, int start, int end, int target, List<List<Integer>> res) {
        if (start > end) {
            return;
        }

        while (start < end) {
            int sum = n[start] + n[end];
            if (sum + target == 0) {
                ArrayList<Integer> re = new ArrayList<>();
                re.add(n[start]);
                re.add(n[end]);
                re.add(target);
                Collections.sort(re);
                res.add(re);
                start++;
                end--;

                while (start < end && n[start] == n[start - 1]) {
                    start++;
                }

                while (start < end && n[end] == n[end + 1]) {
                    end--;
                }
            } else if (sum + target < 0) {
                start++;
            } else {
                end--;
            }
        }
    }
}
