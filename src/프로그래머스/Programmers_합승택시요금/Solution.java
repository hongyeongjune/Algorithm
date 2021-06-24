package 프로그래머스.Programmers_합승택시요금;

import java.util.Arrays;

public class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(6, 4, 6, 2, new int[][]{
                {4, 1, 10}, {3, 5, 24}, {5, 6, 2}, {3, 1, 41}, {5, 1, 24}, {4, 6, 50}, {2, 4, 66}, {2, 3, 22}, {1, 6, 25}
        });
    }

    /**
     * @param n     : 노드 개수
     * @param s     : 시작 지점
     * @param a     : A 도착 지점
     * @param b     : B 도착 지점
     * @param fares : [노드, 노드, 무게]
     * @return
     */
    public int solution(int n, int s, int a, int b, int[][] fares) {
        int answer = Integer.MAX_VALUE;

        int[][] memoization = new int[n + 1][n + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(memoization[i], n * 100000 + 1);
            memoization[i][i] = 0;
        }

        for (int[] fare : fares) {
            memoization[fare[0]][fare[1]] = memoization[fare[1]][fare[0]] = fare[2];
        }

        floydWarShall(memoization, n);

        for (int i = 1; i <= n; i++) {
            answer = Math.min(answer, memoization[s][i] + memoization[i][a] + memoization[i][b]);
        }

        return answer;
    }

    private void floydWarShall(int[][] memoization, int n) {

        for (int k = 1; k <= n; k++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 1; j <= n; j++) {
                    memoization[i][j] = Math.min(memoization[i][j], memoization[i][k] + memoization[k][j]);
                }
            }
        }
    }
}
