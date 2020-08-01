package search.bfs.BackJoon.DFS와BFS_1206번;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

    private static int v;
    private static int w;
    private static int start;
    private static int[][] adjacency;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stringTokenizer = new StringTokenizer(br.readLine());
        v = Integer.parseInt(stringTokenizer.nextToken());
        w = Integer.parseInt(stringTokenizer.nextToken());
        start = Integer.parseInt(stringTokenizer.nextToken());

        adjacency = new int[v+1][v+1];
        boolean[] visited = new boolean[v+1];

        for(int i=0; i<w; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x = Integer.parseInt(st.nextToken());
            int y = Integer.parseInt(st.nextToken());

            adjacency[x][y] = adjacency[y][x] = 1;
        }

        dfs(start, visited);
        System.out.println("");
        bfs();

    }

    private static void dfs(int start, boolean[] visited) {

        visited[start] = true;
        System.out.print(start + " ");

        for(int i=1; i<=v; i++) {
            if(adjacency[start][i] == 1 && visited[i] == false) {
                dfs(i, visited);
            }
        }

    }

    private static void bfs() {

        boolean[] visited = new boolean[v+1];
        Queue<Integer> queue = new LinkedList<>();

        visited[start] = true;
        queue.add(start);

        while(!queue.isEmpty()) {
            int temp = queue.poll();

            System.out.print(temp + " ");

            for(int i=1; i<=v; i++) {
                if(adjacency[temp][i] == 1 && visited[i] == false) {
                    visited[i] = true;
                    queue.add(i);
                }
            }
        }

    }
}
