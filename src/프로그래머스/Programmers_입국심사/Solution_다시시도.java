package 프로그래머스.Programmers_입국심사;

import 프로그래머스.Programmers_추석트래픽.Solution_다시풀기;

import java.util.Arrays;

public class Solution_다시시도 {
    public long solution(int n, int[] times) {
        Arrays.sort(times);
        long left = 0;
        long right = (long) times[times.length-1] * (long) n;

        while(left < right) {
            long mid = (left + right) / 2;

            long temp = 0;
            for(int time : times) {
                temp += (mid / time);
            }

            if(temp >= n) right = mid;
            else left = mid + 1;
        }

        return right;
    }

    public static void main(String[] args) {
        Solution_다시시도 solution = new Solution_다시시도();
        solution.solution(6, new int[]{7,10});
    }
}
