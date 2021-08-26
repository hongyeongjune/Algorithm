package 리트코드.LeetCode_329_LongestIncreasingPathInAMatrix;

public class Solution {

    public static int[] dx = {-1, 0, 1, 0};
    public static int[] dy = {0, -1, 0, 1};
    public static int answer = 1;

    public int longestIncreasingPath(int[][] matrix) {
        answer = 1;
        int[][] cache = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int max = dfs(matrix, cache, i, j);
                answer = Math.max(answer, max);
            }
        }

        return answer;
    }

    private int dfs(int[][] matrix, int[][] cache, int x, int y) {

        if (cache[x][y] != 0) return cache[x][y];

        int max = 1;

        for (int i = 0; i < 4; i++) {
            int newX = x + dx[i];
            int newY = y + dy[i];

            if (newX >= 0 && newX < matrix.length &&
                    newY >= 0 && newY < matrix[0].length &&
                    matrix[x][y] < matrix[newX][newY]) {
                int count = dfs(matrix, cache, newX, newY) + 1;
                max = Math.max(max, count);
            }
        }
        cache[x][y] = max;
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.longestIncreasingPath(new int[][]{
                {9, 9, 4}, {6, 6, 8}, {2, 1, 1}
        });
    }
}
