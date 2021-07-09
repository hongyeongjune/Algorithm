package 프로그래머스.Programmers_게임맵최단거리;

import java.util.LinkedList;
import java.util.Queue;

public class Solution {
    public static int[] dx = {0, 1, 0, -1};
    public static int[] dy = {-1, 0, 1, 0};

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        return bfs(maps, 0, 0, visited);
    }

    private int bfs(int[][] maps, int x, int y, boolean[][] visited) {

        Queue<Point> queue = new LinkedList<>();
        visited[x][y] = true;
        queue.offer(new Point(x, y, 1));

        while (!queue.isEmpty()) {
            Point point = queue.poll();

            if (point.x == maps.length - 1 && point.y == maps[0].length - 1)
                return point.cost;

            for (int i = 0; i < 4; i++) {
                int nextX = dx[i] + point.x;
                int nextY = dy[i] + point.y;

                if (nextX < 0 || nextX >= maps.length || nextY < 0 || nextY >= maps[0].length) continue;

                if (!visited[nextX][nextY] && maps[nextX][nextY] == 1) {
                    queue.offer(new Point(nextX, nextY, point.cost + 1));
                    visited[nextX][nextY] = true;
                }
            }
        }

        return -1;
    }

    public class Point {
        private int x;
        private int y;
        private int cost;

        public Point(int x, int y, int cost) {
            this.x = x;
            this.y = y;
            this.cost = cost;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        }));
    }
}
