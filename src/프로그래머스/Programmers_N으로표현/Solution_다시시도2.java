package 프로그래머스.Programmers_N으로표현;

public class Solution_다시시도2 {

    public int answer = Integer.MAX_VALUE;

    public int solution(int N, int number) {
        dfs(N, number, 0, 0);

        return answer != Integer.MAX_VALUE ? answer : -1;
    }

    private void dfs(int n, int number, int index, int calculate) {
        if(index > 8) {
            return;
        }
        if (calculate == number) {
            answer = Math.min(answer, index);
            return;
        }

        int nn = 0;
        for(int i=0; i<8; i++) {
            nn = nn * 10 + n;
            dfs(n, number, index + i + 1, calculate + nn);
            dfs(n, number, index + i + 1, calculate - nn);
            dfs(n, number, index + i + 1, calculate * nn);
            dfs(n, number, index + i + 1, calculate / nn);
        }
    }
}
