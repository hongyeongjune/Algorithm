package 백준.BOJ_1753_최단경로;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

    public static List<List<Node>> graph;
    public static int[] distance;
    public static int V;
    public static int E;
    public static int INF = Integer.MAX_VALUE;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(br.readLine());

        //다른 모든 정점으로부터 최단경로를 기록하기 위한 배열
        distance = new int[V + 1];
        Arrays.fill(distance, INF);
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
            if (distance[i] == INF) System.out.println("INF");
            else System.out.println(distance[i]);
        }
    }

    private static void dijkstra(int start) {

        //자기 자신으로 가는 것은 0
        distance[start] = 0;
        //가중치를 기준으로 Node 를 정렬
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o.distance));

        //시작 노드 삽입
        pq.offer(new Node(start, distance[start]));

        while (!pq.isEmpty()) {
            //큐에 삽입된 현재 노드를 찾는다.
            int currentNode = pq.peek().node;
            int currentDistance = pq.peek().distance;
            pq.poll();

            //더 크면 더 볼 필요도 없음
            if (distance[currentNode] < currentDistance) continue;

            //현재 노드와 연결된 모든 노드들의 최단 경로를 구한다.
            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                //다음 노드
                int nextNode = graph.get(currentNode).get(i).node;
                int nextDistance = currentDistance + graph.get(currentNode).get(i).distance;

                //가중치가 더 작으면 큐에 넣고 값을 바꿔준다.
                if (distance[nextNode] > nextDistance) {
                    distance[nextNode] = nextDistance;
                    pq.offer(new Node(nextNode, nextDistance));
                }
            }
        }

    }

    public static class Node {
        private int node;
        private int distance;

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }
}
