package 연습문제.거스름돈;


public class Solution {

    public static int solution(int n, int[] money) {
        int answer = 0;

        long[] dp = new long[n + 1];

        for (int i = 0; i <= n; i++) {
            if (i % money[0] == 0) dp[i] = 1;
            else dp[i] = 0;
        }

        for (int i = 1; i < money.length; i++) {
            for (int j = money[i]; j <= n; j++) dp[j] += dp[j - money[i]];
        }

        return answer = (int) (dp[n] % 1000000007);
    }

    public static void main(String[] args) {
        solution(5, new int[]{1, 2, 5});
    }
}
