package 프로그래머스.Programmers_여행경로;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

    public String[] solution(String[][] tickets) {
        boolean[] visited = new boolean[tickets.length + 1];
        List<String> answer = new ArrayList<>();
        dfs(tickets, "ICN", 0, visited, "ICN", answer);
        Collections.sort(answer);
        return answer.get(0).split(" ");
    }

    private void dfs(String[][] tickets, String present, int index, boolean[] visited, String result, List<String> answer) {

        if (index == tickets.length) {
            answer.add(result);
            return;
        }

        for (int i = 0; i < tickets.length; i++) {
            if (!visited[i] && tickets[i][0].equals(present)) {
                visited[i] = true;
                dfs(tickets, tickets[i][1], index + 1, visited, result + " " + tickets[i][1], answer);
                visited[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new String[][]{
                {"ICN", "SFO"},
                {"ICN", "ATL"},
                {"SFO", "ATL"},
                {"ATL", "ICN"},
                {"ATL", "SFO"}
        });
    }
}
