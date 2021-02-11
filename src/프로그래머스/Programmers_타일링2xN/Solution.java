package 프로그래머스.Programmers_타일링2xN;

public class Solution {

    int[] tiling = new int[60001];

    public int solution(int n) {
        int answer = 0;

        return answer = dp(n);
    }

    private int dp(int x) {
        if (x == 1) return 1;
        if (x == 2) return 2;
        if (tiling[x] != 0) return tiling[x];

        return tiling[x] = (dp(x - 1) + dp(x - 2)) % 1000000007;
    }
}
