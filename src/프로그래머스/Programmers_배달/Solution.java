package 프로그래머스.Programmers_배달;

import java.util.*;

public class Solution {

    public List<List<Integer>> graph;

    public static int INF = Integer.MAX_VALUE;

    public int solution(int N, int[][] road, int K) {
        int[] distance = new int[N + 1];
        Arrays.fill(distance, INF);

        List<List<Node>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int[] r : road) {
            graph.get(r[0]).add(new Node(r[1], r[2]));
            graph.get(r[1]).add(new Node(r[0], r[2]));
        }

        dijkstra(1, distance, graph);

        int answer = 0;
        for (int i = 1; i < distance.length; i++) {
            if (distance[i] <= K) answer++;
        }
        return answer;
    }

    private void dijkstra(int start, int[] distance, List<List<Node>> graph) {
        distance[start] = 0;
        PriorityQueue<Node> pq = new PriorityQueue<>(Comparator.comparing(Node::getDistance));
        pq.offer(new Node(start, distance[start]));

        while (!pq.isEmpty()) {
            int currentNode = pq.peek().node;
            int currentDistance = pq.peek().distance;
            pq.poll();

            if (distance[currentNode] < currentDistance) continue;

            for (int i = 0; i < graph.get(currentNode).size(); i++) {
                int nextNode = graph.get(currentNode).get(i).node;
                int nextDistance = currentDistance + graph.get(currentNode).get(i).distance;

                if (distance[nextNode] > nextDistance) {
                    distance[nextNode] = nextDistance;
                    pq.offer(new Node(nextNode, nextDistance));
                }
            }
        }
    }

    public class Node {
        private int node;
        private int distance;

        public int getDistance() {
            return this.distance;
        }

        public Node(int node, int distance) {
            this.node = node;
            this.distance = distance;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, new int[][]{
                {1, 2, 1}, {2, 3, 3}, {5, 2, 2}, {1, 4, 2}, {5, 3, 1}, {5, 4, 2}
        }, 3);
    }
}
