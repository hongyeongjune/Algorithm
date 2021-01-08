package 다익스트라;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<List<Node>> graph;
    public static int[] d;
    public static int V;
    public static int E;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        d = new int[V + 1];
        Arrays.fill(d, INF);
        graph = new ArrayList<>();
        for (int i = 0; i <= V; i++) {
            graph.add(new ArrayList<>());
        }
        for (int i = 0; i < E; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            graph.get(u).add(new Node(v, w));
        }

        dijkstra(K);

        for (int i = 1; i <= V; i++) {
            if (d[i] == INF) System.out.println("INF");
            else System.out.println(d[i]);
        }

    }

    public static void dijkstra(int start) {

        d[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>((o1, o2) -> o1.distance - o2.distance);
        pq.offer(new Node(start, d[start]));

        while (!pq.isEmpty()) {

            int current = pq.peek().node;
            int distance = pq.peek().distance;
            pq.poll();

            if (d[current] < distance) continue;

            for (int i = 0; i < graph.get(current).size(); i++) {
                int next = graph.get(current).get(i).node;

                int nextDistance = distance + graph.get(current).get(i).distance;

                if (nextDistance < d[next]) {
                    d[next] = nextDistance;
                    pq.offer(new Node(next, nextDistance));
                }
            }
        }
    }

    public static class Node {
        int node;
        int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
