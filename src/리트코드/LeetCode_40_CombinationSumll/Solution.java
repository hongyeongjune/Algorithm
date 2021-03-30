package 리트코드.LeetCode_40_CombinationSumll;

import java.util.*;

public class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {


        Arrays.sort(candidates);

        Set<List<Integer>> answer = new HashSet<>();

        boolean[] visited = new boolean[candidates.length];

        dfs(candidates, target, answer, 0, new ArrayList<>(), 0, visited);

        return new ArrayList<>(answer);
    }

    private void dfs(int[] candidates, int target, Set<List<Integer>> answer, int sum, List<Integer> list, int index, boolean[] visited) {

        if (sum > target) return;

        if (sum == target) {
            if (!answer.contains(list))
                answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (!visited[i]) {
                visited[i] = true;
                list.add(candidates[i]);
                dfs(candidates, target, answer, sum + candidates[i], list, i, visited);
                list.remove(list.size() - 1);
                visited[i] = false;
            }
        }

    }
}
