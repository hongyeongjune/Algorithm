package 리트코드.LeetCode_1034_ColoringABorder;

public class Solution {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};

    public int[][] colorBorder(int[][] grid, int row, int col, int color) {

        int originalColor = grid[row][col];
        dfs(grid, row, col, originalColor);

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] < 0) grid[i][j] = color;
            }
        }

        return grid;
    }

    private void dfs(int[][] grid, int x, int y, int originalColor) {

        if (x < 0 || y < 0 || x >= grid.length || y >= grid[0].length || grid[x][y] != originalColor) {
            return;
        }

        grid[x][y] *= -1;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            dfs(grid, nextX, nextY, originalColor);
        }

        if (x > 0 && y > 0 && x < grid.length - 1 && y < grid[0].length - 1
                && originalColor == Math.abs(grid[x + 1][y])
                && originalColor == Math.abs(grid[x][y + 1])
                && originalColor == Math.abs(grid[x - 1][y])
                && originalColor == Math.abs(grid[x][y - 1])) {
            grid[x][y] = originalColor;
        }
    }
}
