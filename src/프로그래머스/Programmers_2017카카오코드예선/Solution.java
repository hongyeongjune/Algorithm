package 프로그래머스.Programmers_2017카카오코드예선;

public class Solution {
    public static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        boolean[][] visited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (picture[i][j] != 0 && !visited[i][j]) {
                    numberOfArea++;
                    int sum = dfs(i, j, visited, picture);
                    if (sum > maxSizeOfOneArea) maxSizeOfOneArea = sum;
                }
            }
        }

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    private static int dfs(int i, int j, boolean[][] visited, int[][] picture) {
        int sum = 1;
        visited[i][j] = true;
        if (i + 1 < picture.length && !visited[i + 1][j] && picture[i + 1][j] == picture[i][j])
            sum += dfs(i + 1, j, visited, picture);
        if (i - 1 >= 0 && !visited[i - 1][j] && picture[i - 1][j] == picture[i][j])
            sum += dfs(i - 1, j, visited, picture);
        if (j - 1 >= 0 && !visited[i][j - 1] && picture[i][j - 1] == picture[i][j])
            sum += dfs(i, j - 1, visited, picture);
        if (j + 1 < picture[i].length && !visited[i][j + 1] && picture[i][j + 1] == picture[i][j])
            sum += dfs(i, j + 1, visited, picture);

        return sum;
    }

}
