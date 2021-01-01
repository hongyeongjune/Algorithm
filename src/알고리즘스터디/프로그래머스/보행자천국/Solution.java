package 알고리즘스터디.프로그래머스.보행자천국;

public class Solution {
    static int MOD = 20170805;

    public static int solution(int m, int n, int[][] cityMap) {
        int answer = 0;

        int[][] rightDp = new int[m + 1][n + 1];
        int[][] downDp = new int[m + 1][n + 1];

        rightDp[1][1] = 1;
        downDp[1][1] = 1;

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {

                if (cityMap[i - 1][j - 1] == 0) {
                    rightDp[i][j] += (rightDp[i][j - 1] + downDp[i - 1][j]) % MOD;
                    downDp[i][j] += (rightDp[i][j - 1] + downDp[i - 1][j]) % MOD;
                } else if (cityMap[i - 1][j - 1] == 1) {
                    rightDp[i][j] = 0;
                    downDp[i][j] = 0;
                } else {
                    rightDp[i][j] = rightDp[i][j - 1];
                    downDp[i][j] = downDp[i - 1][j];
                }

            }
        }

        return rightDp[m][n];
    }

}
