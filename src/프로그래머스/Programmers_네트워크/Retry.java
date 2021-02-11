package 프로그래머스.Programmers_네트워크;

public class Retry {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] check = new boolean[n];

        for (int i = 0; i < n; i++) {
            if (!check[i]) {
                dfs(check, computers, i);
                answer++;
            }
        }
        return answer;
    }

    private void dfs(boolean[] check, int[][] computers, int start) {
        check[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!check[i] && computers[start][i] == 1) {
                dfs(check, computers, i);
            }
        }
    }

}
