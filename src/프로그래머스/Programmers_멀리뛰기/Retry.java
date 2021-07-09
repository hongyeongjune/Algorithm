package 프로그래머스.Programmers_멀리뛰기;

public class Retry {
    private static int MOD = 1234567;

    public static long solution(int n) {
        long[] memoization = new long[2001];
        memoization[1] = 1;
        memoization[2] = 2;

        for (int i = 3; i <= n; i++) {
            memoization[i] = (memoization[i - 1] + memoization[i - 2]) % MOD;
        }

        return memoization[n];
    }
}
