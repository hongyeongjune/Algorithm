package 리트코드.LeetCode_997_FindTheTownJudge;

public class Solution_시간단축 {
    public int findJudge(int n, int[][] trust) {
        int[] answer = new int[n + 1];
        for (int[] t : trust) {
            answer[t[0]]--;
            answer[t[1]]++;
        }

        for (int i = 1; i < answer.length; i++) {
            if (answer[i] == n - 1) return i;
        }

        return -1;
    }
}
