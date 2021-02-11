package 프로그래머스.Programmers_가장먼노드;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Solution {
    public int solution(int n, int[][] edge) {

        int answer = 0;
        boolean[][] graph = new boolean[n + 1][n + 1];
        boolean[] visited = new boolean[n + 1];
        List<Integer> next = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();

        for (int[] e : edge) {
            graph[e[0]][e[1]] = graph[e[1]][e[0]] = true;
        }

        visited[0] = visited[1] = true;
        queue.add(1);

        while (true) {
            answer = queue.size();
            while (!queue.isEmpty()) {
                int node = queue.poll();
                for (int i = 1; i <= n; i++) {
                    if (!visited[i] && graph[node][i]) {
                        next.add(i);
                        visited[i] = true;
                    }
                }
            }
            if (next.isEmpty()) break;
            queue.addAll(next);
            next.clear();
        }

        return answer;
    }
}
