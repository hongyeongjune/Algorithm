package 프로그래머스.Programmers_퀴드압축후개수세기;

public class Solution {

    private static int zero = 0;
    private static int one = 0;

    public static int[] solution(int[][] arr) {
        int[] answer = new int[2];

        dfs(arr, 0, 0, arr.length);

        answer[0] = zero;
        answer[1] = one;

        System.out.println(zero + " : " + one);
        return answer;
    }

    private static void dfs(int[][] arr, int row, int col, int length) {

        if (length == 1) {
            if (arr[row][col] == 1) one++;
            else zero++;

            return;
        }

        if (isSame(arr, row, col, length)) {
            return;
        }

        dfs(arr, row, col, length / 2);
        dfs(arr, row, col + (length / 2), length / 2);
        dfs(arr, row + (length / 2), col, length / 2);
        dfs(arr, row + (length / 2), col + (length / 2), length / 2);


    }

    private static boolean isSame(int[][] arr, int row, int col, int length) {

        int same = arr[row][col];
        for (int i = row; i < row + length; i++) {
            for (int j = col; j < col + length; j++) {
                if (same != arr[i][j]) return false;
            }
        }

        if (same == 1) one++;
        else zero++;

        return true;
    }
}
