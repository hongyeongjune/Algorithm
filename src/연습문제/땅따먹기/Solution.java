package 연습문제.땅따먹기;

public class Solution {
    public static int solution(int[][] land) {

        int[][] dp = new int[land.length][4];

        for (int i = 0; i < land.length; i++) {
            for (int j = 0; j < land[i].length; j++)
                dp[i][j] = land[i][j];
        }

        for (int i = land.length - 2; i >= 0; i--) {
            dp[i][0] = land[i][0] + Math.max(dp[i + 1][1], Math.max(dp[i + 1][2], dp[i + 1][3]));
            dp[i][1] = land[i][1] + Math.max(dp[i + 1][0], Math.max(dp[i + 1][2], dp[i + 1][3]));
            dp[i][2] = land[i][2] + Math.max(dp[i + 1][0], Math.max(dp[i + 1][1], dp[i + 1][3]));
            dp[i][3] = land[i][3] + Math.max(dp[i + 1][0], Math.max(dp[i + 1][1], dp[i + 1][2]));
        }


        return Math.max(dp[0][0], Math.max(dp[0][1], Math.max(dp[0][2], dp[0][3])));
    }

}
