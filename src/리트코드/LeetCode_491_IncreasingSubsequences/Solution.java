package 리트코드.LeetCode_491_IncreasingSubsequences;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Solution {

    public static Set<List<Integer>> answer;

    public List<List<Integer>> findSubsequences(int[] nums) {
        answer = new HashSet<>();
        dfs(nums, 0, new ArrayList<Integer>());

        return new ArrayList<>(answer);
    }

    private void dfs(int[] nums, int index, List<Integer> list) {

        if (list.size() > 1) answer.add(new ArrayList<>(list));

        for (int i = index; i < nums.length; i++) {
            if (list.size() == 0 || list.get(list.size() - 1) <= nums[i]) {
                list.add(nums[i]);
                dfs(nums, i + 1, list);
                list.remove(list.size() - 1);
            }
        }
    }
}
