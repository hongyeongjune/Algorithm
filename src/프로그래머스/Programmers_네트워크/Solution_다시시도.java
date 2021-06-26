package 프로그래머스.Programmers_네트워크;

public class Solution_다시시도 {
    public int solution(int n, int[][] computers) {
        boolean[] visited = new boolean[n];
        int answer = 0;

        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(n, computers, visited, i);
                answer++;
            }
        }

        return answer;
    }

    private void dfs(int n, int[][] computers, boolean[] visited, int index) {
        visited[index] = true;
        for (int i = 0; i < computers.length; i++) {
            if (computers[index][i] == 1 && !visited[i]) {
                dfs(n, computers, visited, i);
            }
        }
    }
}
