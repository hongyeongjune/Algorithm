package 리트코드.LeetCode_40_CombinationSumll;

import java.util.*;

public class Solution_시간단축 {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> answer = new ArrayList<>();

        dfs(candidates, target, answer, 0, new ArrayList<>(), 0);

        return answer;
    }

    private void dfs(int[] candidates, int target, List<List<Integer>> answer, int sum, List<Integer> list, int index) {

        if (sum > target) return;

        if (sum == target) {
            answer.add(new ArrayList<>(list));
            return;
        }

        for (int i = index; i < candidates.length; i++) {

            if (i != index && candidates[i] == candidates[i - 1]) continue;

            list.add(candidates[i]);
            dfs(candidates, target, answer, sum + candidates[i], list, i + 1);
            list.remove(list.size() - 1);
        }

    }

    public static void main(String[] args) {
        Solution_시간단축 solution = new Solution_시간단축();
        solution.combinationSum2(new int[]{10, 1, 2, 7, 6, 1, 5}, 8);
    }
}
