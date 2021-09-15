package 백준.BOJ_2636_치즈;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_다시풀기 {
    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int count = 0;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int width = Integer.parseInt(st.nextToken());
        int height = Integer.parseInt(st.nextToken());

        int[][] cheese = new int[width][height];

        for (int i = 0; i < width; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < height; j++) {
                cheese[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int hour = 0;
        while (isMelt(cheese)) {
            boolean[][] visited = new boolean[width][height];
            hour++;
            count = 0;
            dfs(cheese, visited, 1, 1);
        }

        System.out.println(hour);
        System.out.println(count);
    }

    private static void dfs(int[][] cheese, boolean[][] visited, int x, int y) {
        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX >= 0 && nextX < cheese.length && nextY >= 0 && nextY < cheese[0].length && !visited[nextX][nextY]) {
                visited[nextX][nextY] = true;

                if (cheese[nextX][nextY] == 1) {
                    cheese[nextX][nextY] = 2;
                    count++;
                } else dfs(cheese, visited, nextX, nextY);
            }
        }
    }

    private static boolean isMelt(int[][] cheese) {

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                if (cheese[i][j] == 2) cheese[i][j] = 0;
            }
        }

        for (int i = 0; i < cheese.length; i++) {
            for (int j = 0; j < cheese[i].length; j++) {
                if (cheese[i][j] == 1) {
                    return true;
                }
            }
        }
        return false;
    }
}
