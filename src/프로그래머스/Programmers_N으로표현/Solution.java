package 프로그래머스.Programmers_N으로표현;

public class Solution {
    public static int answer = -1;

    public int solution(int N, int number) {

        dfs(N, number, 0, 0);

        return answer;
    }

    private void dfs(int N, int number, int index, int result) {

        if (index > 8) return;

        if (result == number) {
            if (answer == -1 || index < answer)
                answer = index;
            return;
        }

        int NN = 0;
        for (int i = 0; i < 8; i++) {
            NN = NN * 10 + N;
            dfs(N, number, index + i + 1, result + NN);
            dfs(N, number, index + i + 1, result - NN);
            dfs(N, number, index + i + 1, result * NN);
            dfs(N, number, index + i + 1, result / NN);
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(5, 12);
    }
}
