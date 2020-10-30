package greedy.프로그래머스.섬연결하기;

import java.util.*;

public class Retry {

    private static class Edge {
        int v1, v2, cost;

        public Edge(int v1, int v2, int cost) {
            this.v1 = v1;
            this.v2 = v2;
            this.cost = cost;
        }
    }

    private static int getParent(int[] parent, int x) {
        if (parent[x] == x) return x;
        return parent[x] = getParent(parent, parent[x]);
    }

    private static void unionParent(int[] parent, int v1, int v2) {
        v1 = getParent(parent, v1);
        v2 = getParent(parent, v2);
        if (v1 < v2) parent[v2] = v1;
        else parent[v1] = v2;
    }

    private static boolean findParent(int[] parent, int v1, int v2) {
        v1 = getParent(parent, v1);
        v2 = getParent(parent, v2);
        if (v1 == v2) return true;
        else return false;
    }

    public static int solution(int n, int[][] costs) {
        int answer = 0;
        List<Edge> edges = new ArrayList<>();
        int[] parent = new int[n];

        for (int[] cost : costs)
            edges.add(new Edge(cost[0], cost[1], cost[2]));

        for (int i = 0; i < n; i++)
            parent[i] = i;

        Collections.sort(edges, (o1, o2) -> o1.cost - o2.cost);

        for (int i = 0; i < edges.size(); i++) {
            Edge edge = edges.get(i);
            if (!findParent(parent, edge.v1, edge.v2)) {
                answer += edge.cost;
                unionParent(parent, edge.v1, edge.v2);
            }
        }
        return answer;
    }
}
