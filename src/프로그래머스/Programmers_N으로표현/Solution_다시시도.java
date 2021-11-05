package 프로그래머스.Programmers_N으로표현;

public class Solution_다시시도 {

    public static int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);
        return answer == Integer.MAX_VALUE ? -1 : answer;
    }

    private void dfs(int N, int number, int count, int calculate) {
        if (count > 8) {
            return;
        }

        if (calculate == number) {
            answer = Math.min(answer, count);
            return;
        }

        int NN = 0;
        for (int i = 0; i < 8; i++) {
            NN = NN * 10 + N;
            dfs(N, number, count + 1 + i, calculate + NN);
            dfs(N, number, count + 1 + i, calculate - NN);
            dfs(N, number, count + 1 + i, calculate * NN);
            dfs(N, number, count + 1 + i, calculate / NN);
        }

    }
}
