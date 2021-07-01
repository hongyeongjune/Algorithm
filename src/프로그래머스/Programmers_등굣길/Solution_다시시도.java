package 프로그래머스.Programmers_등굣길;

public class Solution_다시시도 {
    public static int solution(int m, int n, int[][] puddles) {
        int MOD = 1000000007;
        int[][] memoization = new int[m + 1][n + 1];
        for (int[] puddle : puddles) {
            memoization[puddle[0]][puddle[1]] = -1;
        }

        memoization[1][1] = 1;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (memoization[i][j] == -1) memoization[i][j] = 0;
                else {
                    memoization[i][j] += (memoization[i - 1][j] + memoization[i][j - 1]) % MOD;
                }
            }
        }

        return memoization[m][n];
    }
}
