package 프로그래머스.Programmers_전력망을둘로나누기;

public class Solution {

    public static int count;

    public int solution(int n, int[][] wires) {

        int answer = Integer.MAX_VALUE;

        int[][] graph = new int[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];

        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 1;
        }


        for (int[] wire : wires) {
            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 0;
            count = 0;
            dfs(graph, visited, 1, n);

            graph[wire[0]][wire[1]] = graph[wire[1]][wire[0]] = 1;
            visited = new boolean[n + 1];
            answer = Math.min(answer, Math.abs(n - 2 * count));
        }

        return answer;
    }

    public void dfs(int[][] graph, boolean[] visited, int index, int n) {
        visited[index] = true;
        count++;
        for (int i = 1; i <= n; i++) {
            if (graph[index][i] == 1 && !visited[i]) {
                dfs(graph, visited, i, n);
            }
        }
    }
}
