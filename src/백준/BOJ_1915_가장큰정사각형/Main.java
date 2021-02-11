package 백준.BOJ_1915_가장큰정사각형;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] board = new int[N][M];

        for (int i = 0; i < N; i++) {
            String[] temp = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                board[i][j] = Integer.parseInt(temp[j]);
            }
        }

        int answer = 0;

        for (int i = 1; i < N; i++) {
            for (int j = 1; j < M; j++) {
                if (board[i][j] == 0) continue;
                board[i][j] = Math.min(board[i][j - 1], Math.min(board[i - 1][j], board[i - 1][j - 1])) + 1;
                answer = Math.max(board[i][j], answer);
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

        System.out.println(answer * answer);
    }
}
