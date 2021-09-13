package 프로그래머스.Programmers_N개의최소공배수;

import java.util.Arrays;

public class Solution {
    public int solution(int[] arr) {
        int answer = Arrays.stream(arr).max().getAsInt();
        while (answer < Integer.MAX_VALUE) {
            if (checkLeastCommonMultiple(answer, arr))
                return answer;
            answer++;
        }
        return answer;
    }

    public boolean checkLeastCommonMultiple(int target, int[] arr) {
        for (int a : arr) {
            if (target % a != 0) return false;
        }
        return true;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.solution(new int[]{2, 6, 8, 14});
    }
}
