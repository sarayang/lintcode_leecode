package lintcode.lintcode_leecode;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;

/**
 * Created by YANGSONG on 2018-09-21.
 */
class Pair {
    Integer index;
    Integer value;
    Pair(Integer i, Integer v) {
        this.index = i;
        this.value = v;
    }

    Integer getValue() {
        return this.value;
    }

    Integer getIndex() {
        return this.index;
    }
}
class ValueComparator implements Comparator<Pair> {
    @Override
    public int compare(Pair p1, Pair p2) {
        return p1.getValue().compareTo(p2.getValue());
    }

}
public class Two_Sum {

    public int[] twoSum(int[] numbers, int target) {
        Pair[] num = new Pair[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            num[i] = new Pair(i, numbers[i]);
        }
        Arrays.sort(num, new ValueComparator());

        int left = 0;
        int right = num.length - 1;
        while (left < right) {
            if (num[left].getValue() + num[right].getValue() == target) {
                Integer l = num[left].getIndex();
                Integer r = num[right].getIndex();
                int[] result = {Math.min(l, r), Math.max(l, r)};
                return result;
            } else if (num[left].getValue() + num[right].getValue() < target) {
                left++;
            } else {
                right--;
            }
        }
        return null;
    }

    // another solution with hashmap O(n) time complexity and O(n) space
    // it is hard to use two pointers to scan it and find the result (well it is possible though)
    public int[] twoSum_hashmap(int[] numbers, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];
        map.put(numbers[0], 0);
        for (int i = 1; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]);
                result[1] = i;
                return result;
            }
            map.put(numbers[i], i);
        }

        return result;
    }
}