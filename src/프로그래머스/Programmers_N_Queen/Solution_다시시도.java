package 프로그래머스.Programmers_N_Queen;

public class Solution_다시시도 {
    public static int[] board = new int[12];
    public static int answer = 0;

    public int solution(int n) {
        backTracking(0, n);

        return answer;
    }

    private void backTracking(int index, int n) {

        if (index == n) {
            answer++;
            return;
        }

        for (int i = 0; i < n; i++) {
            board[index] = i;
            if (isPossible(index)) {
                backTracking(index + 1, n);
            }
        }
    }

    private boolean isPossible(int index) {
        for (int i = 0; i < index; i++) {
            if (board[i] == board[index] || Math.abs(i - index) == Math.abs(board[i] - board[index]))
                return false;
        }
        return true;
    }
}
