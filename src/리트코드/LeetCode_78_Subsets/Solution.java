package 리트코드.LeetCode_78_Subsets;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {


        List<List<Integer>> answer = new ArrayList<>();
        boolean[] visited = new boolean[nums.length];
        for (int i = 0; i <= nums.length; i++) {
            dfs(nums, answer, visited, i, 0, 0);
        }


        return answer;
    }

    public void dfs(int[] nums, List<List<Integer>> answer, boolean[] visited, int length, int index, int start) {

        // 길이가 0부터 nums.length 사이 일 때
        // 방문했던 값을 하나씩 넣어 준다.
        if (length == index) {
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < visited.length; i++) {
                if (visited[i]) temp.add(nums[i]);
            }

            answer.add(temp);

            return;
        }


        for (int i = start; i < nums.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                dfs(nums, answer, visited, length, index + 1, i);
                visited[i] = false;
            }
        }

    }
}
