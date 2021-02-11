package 프로그래머스.Programmers_삼각달팽이;

public class Retry {
    public static int[] solution(int n) {
        int[][] triangle = new int[n][n];

        int value = 1;
        int max = 0;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) triangle[i][j] = -1;
        }
        for (int i = 1; i <= n; i++) max += i;

        int[] answer = new int[max];

        int i = 0, j = 0;
        triangle[i][j] = value;

        while (value < max) {
            while (i + 1 < n && value < max && triangle[i + 1][j] == -1) {
                triangle[++i][j] = ++value;
            }
            while (j + 1 < n && value < max && triangle[i][j + 1] == -1) {
                triangle[i][++j] = ++value;
            }
            while (i - 1 > 0 && j - 1 > 0 && value < max && triangle[i - 1][j - 1] == -1) {
                triangle[--i][--j] = ++value;
            }
        }

        int index = 0;
        for (int k = 0; k < n; k++) {
            for (int l = 0; l <= k; l++) answer[index++] = triangle[k][l];
        }

        return answer;
    }

}
