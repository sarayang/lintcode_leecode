package lintcode.lintcode_leecode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by YANGSONG on 2018-09-08.
 */
public class Permutation_II {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null) {
            return result;
        }

        Arrays.sort(nums);

        dfs(nums, new boolean[nums.length], new ArrayList<Integer>(), result);


        return result;
    }

    private void dfs(int[] nums,
                     boolean[] visited,
                     ArrayList<Integer> permutation,
                     List<List<Integer>> result) {
        if (permutation.size() == nums.length) {
            result.add(new ArrayList<>(permutation));
            return;
        }


        for (int i = 0; i < nums.length; i++) {
            if (visited[i]) {
                continue;
            }
            //[1, 2, 2, 3]
            if (i > 0 && nums[i-1] == nums[i] && visited[i - 1]) {
                continue;
            }
            visited[i] = true;
            permutation.add(nums[i]);
            dfs(nums, visited, permutation, result);
            visited[i] = false;
            permutation.remove(permutation.size() - 1);
        }

    }
}
