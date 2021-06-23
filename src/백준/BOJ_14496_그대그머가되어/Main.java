package 백준.BOJ_14496_그대그머가되어;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    public static List<List<Node>> graph;
    public static int[] distance;
    public static int N;
    public static int M;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        distance = new int[N + 1];
        Arrays.fill(distance, INF);
        graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            //양방향
            graph.get(x).add(new Node(y, 1));
            graph.get(y).add(new Node(x, 1));
        }

        dijkstra(a);

        if (distance[b] == INF) System.out.println(-1);
        else System.out.println(distance[b]);
    }

    private static void dijkstra(int start) {

        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));
        pq.offer(new Node(start, distance[start]));

        while (!pq.isEmpty()) {
            int currentNode = pq.peek().node;
            int currentDistance = pq.peek().distance;
            pq.poll();

            if (currentDistance > distance[currentNode]) continue;

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int nextNode = graph.get(currentNode).get(i).node;
                int nextDistance = currentDistance + graph.get(currentNode).get(i).distance;

                if (nextDistance < distance[nextNode]) {
                    distance[nextNode] = nextDistance;
                    pq.offer(new Node(nextNode, nextDistance));
                }
            }
        }
    }

    private static class Node {
        private int node;
        private int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
