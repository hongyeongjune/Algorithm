package 프로그래머스.Programmers_행렬테두리회전하기;

public class Solution {

    public static int[] answer;

    public int[] solution(int rows, int columns, int[][] queries) {
        answer = new int[queries.length];

        int[][] matrix = new int[rows][columns];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                matrix[i][j] = i * columns + j + 1;
            }
        }

        int index = 0;
        for (int[] query : queries) {
            rotate(query[0] - 1, query[2] - 1, query[1] - 1, query[3] - 1, matrix, index++);
        }

        return answer;
    }

    public void rotate(int x1, int x2, int y1, int y2, int[][] matrix, int index) {

        int temp = matrix[x1][y1];
        answer[index] = temp;

        for (int i = x1; i < x2; i++) {
            matrix[i][y1] = matrix[i + 1][y1];
            answer[index] = Math.min(answer[index], matrix[i][y1]);
        }

        for (int i = y1; i < y2; i++) {
            matrix[x2][i] = matrix[x2][i + 1];
            answer[index] = Math.min(answer[index], matrix[x2][i]);
        }

        for (int i = x2; i > x1; i--) {
            matrix[i][y2] = matrix[i - 1][y2];
            answer[index] = Math.min(answer[index], matrix[i][y2]);
        }

        for (int i = y2; i > y1; i--) {
            matrix[x1][i] = matrix[x1][i - 1];
            answer[index] = Math.min(answer[index], matrix[x1][i]);
        }

        matrix[x1][y1 + 1] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, 6, new int[][]{
                {2, 2, 5, 4}, {3, 3, 6, 6}, {5, 1, 6, 3}
        });
    }
}
