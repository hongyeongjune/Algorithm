package 프로그래머스.Programmers_N_Queen;

public class Solution {

    static int answer = 0;
    static int[] board = new int[12];

    public static int solution(int n) {

        backTracking(0, n);

        return answer;
    }

    public static void backTracking(int index, int n) {

        if (index == n) {
            answer++;
            for (int i = 0; i < n; i++) {
                System.out.print(board[i] + " ");
            }
            System.out.println("");
            return;
        }

        for (int i = 0; i < n; i++) {
            board[index] = i;
            System.out.println("[행] : " + i + " , [열] : " + index);
            if (isPossible(index)) {
                backTracking(index + 1, n);
            }
        }
    }

    public static boolean isPossible(int index) {
        for (int i = 0; i < index; i++) {

            System.out.print("행 : " + i + " , " + "열 : " + index + " , " + "행값 : " + board[i] + " , " + "열값 : " + board[index]);
            if (board[i] == board[index]) {
                System.out.println(" 세로가로");
                return false;
            }
            if (Math.abs(index - i) == Math.abs(board[index] - board[i])) {
                System.out.println(" 대각선");
                return false;
            } else System.out.println("");

        }

        return true;
    }

    public static void main(String[] args) {
        solution(4);
    }
}

