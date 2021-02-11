package 우아한테크코스.프로그래밍7;

public class Solution {
    public static int[][] solution(int n, boolean horizontal) {
        int[][] answer = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) answer[i][j] = -1;
        }
        int i = 0, j = 0;

        answer[0][0] = 0;

        if (n == 1) return answer;

        if (horizontal) {
            answer[0][1] = 1;
            i = 0;
            j = 1;
        } else {
            answer[1][0] = 1;
            i = 1;
            j = 0;
        }

        while (true) {
            if (i == n - 1 && j == n - 1) break;
            if (i == 0 && j < (n - 1) && answer[i + 1][j - 1] != -1) {
                answer[i][j + 1] = answer[i][j] + 1;
                j++;
            } else if (i < (n - 1) && j > 0 && answer[i + 1][j - 1] == -1) {
                answer[i + 1][j - 1] = answer[i][j] + 2;
                i++;
                j--;
            } else if (i < (n - 1) && j == 0 && answer[i - 1][j + 1] != -1) {
                answer[i + 1][j] = answer[i][j] + 1;
                i++;
            } else if (i > 0 && j < (n - 1) && answer[i - 1][j + 1] == -1) {
                answer[i - 1][j + 1] = answer[i][j] + 2;
                i--;
                j++;
            } else if (i < (n - 1) && j == (n - 1) && answer[i + 1][j - 1] != -1) {
                answer[i + 1][j] = answer[i][j] + 1;
                i++;
            } else if (i < (n - 1) && j == (n - 1) && answer[i + 1][j - 1] == -1) {
                answer[i + 1][j - 1] = answer[i][j] + 2;
                i++;
                j--;
            } else if (i == (n - 1) && j < (n - 1) && answer[i - 1][j + 1] != -1) {
                answer[i][j + 1] = answer[i][j] + 1;
                j++;
            } else if (j < (n - 1) && answer[i - 1][j + 1] == -1) {
                answer[i - 1][j + 1] = answer[i][j] + 2;
                i--;
                j++;
            }
        }

        return answer;
    }
}
