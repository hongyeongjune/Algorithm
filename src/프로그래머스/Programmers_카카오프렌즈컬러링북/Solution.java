package 프로그래머스.Programmers_카카오프렌즈컬러링북;

public class Solution {

    public static final int[] dx = {-1, 0, 1, 0};
    public static final int[] dy = {0, -1, 0, 1};
    public static int area = 0;
    public static int maxSize = 0;
    public static int areaSize;

    public int[] solution(int m, int n, int[][] picture) {

        area = 0;
        maxSize = 0;

        boolean[][] visited = new boolean[m][n];

        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(!visited[i][j] && picture[i][j] != 0) {
                    areaSize = 0;
                    dfs(i, j, picture, visited, picture[i][j]);
                    area++;
                }
            }
        }

        return new int[]{area, maxSize};
    }

    private void dfs(int row, int column, int[][] picture, boolean[][] visited, int value) {
        for(int i=0; i<4; i++) {
            int x = row + dx[i];
            int y = column + dy[i];

            if(x < 0 || x >= picture.length || y < 0 || y >= picture[0].length)
                continue;

            if(picture[x][y] == value && !visited[x][y]) {
                visited[x][y] = true;
                dfs(x, y, picture, visited, value);
                areaSize++;
                maxSize = Math.max(maxSize, areaSize);
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, 4, new int[][]{
                {1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}
        });
    }
}
