package 리트코드.LeetCode_39_CombinationSum;

import java.util.ArrayList;
import java.util.List;

public class Retry {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {

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
            if (candidates[i] < target) {
                list.add(candidates[i]);
                dfs(candidates, target, answer, sum + candidates[i], list, i);
                list.remove(list.size() - 1);
            }
        }

    }
}
