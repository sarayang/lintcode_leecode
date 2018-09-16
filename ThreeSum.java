package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Arrays;
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
}
