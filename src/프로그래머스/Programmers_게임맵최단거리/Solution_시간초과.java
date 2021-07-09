package 프로그래머스.Programmers_게임맵최단거리;

public class Solution_시간초과 {
    public static int answer = Integer.MAX_VALUE;
    public static boolean flag = false;

    public int solution(int[][] maps) {
        boolean[][] visited = new boolean[maps.length][maps[0].length];

        dfs(maps, visited, 0, 0, 0);

        if (!flag) return -1;

        return answer + 1;
    }

    private void dfs(int[][] maps, boolean[][] visited, int row, int column, int distance) {

        if (row < 0 || row >= maps.length || column < 0 || column >= maps[0].length) {
            return;
        } else if (visited[row][column] || maps[row][column] == 0) {
            return;
        } else if (row == maps.length - 1 && column == maps[0].length - 1) {
            answer = Math.min(answer, distance);
            flag = true;
        } else {
            visited[row][column] = true;
            dfs(maps, visited, row + 1, column, distance + 1);
            dfs(maps, visited, row - 1, column, distance + 1);
            dfs(maps, visited, row, column + 1, distance + 1);
            dfs(maps, visited, row, column - 1, distance + 1);
            visited[row][column] = false;
        }
    }

    public static void main(String[] args) {
        Solution_시간초과 solution = new Solution_시간초과();
        solution.solution(new int[][]{
                {1, 0, 1, 1, 1}, {1, 0, 1, 0, 1}, {1, 0, 1, 1, 1}, {1, 1, 1, 0, 1}, {0, 0, 0, 0, 1}
        });
    }
}
