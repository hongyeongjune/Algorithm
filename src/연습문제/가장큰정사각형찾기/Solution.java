package 연습문제.가장큰정사각형찾기;

public class Solution {
    public static int solution(int[][] board) {
        int answer = 0;

        for (int i = 1; i < board.length; i++) {
            for (int j = 1; j < board[i].length; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(board[i - 1][j], Math.min(board[i][j - 1], board[i - 1][j - 1])) + 1;
                if (answer < board[i][j]) answer = board[i][j];
            }
        }

        if (answer == 0) {
            for (int i = 0; i < board[0].length; i++) {
                if (board[0][i] == 1) answer = 1;
            }
            for (int i = 0; i < board.length; i++) {
                if (board[i][0] == 1) answer = 1;
            }
        }

        return answer * answer;
    }

    public static void main(String[] args) {
        System.out.println(solution(new int[][]{{0, 0, 0, 0}, {1, 0, 0, 0}}));
    }
}
