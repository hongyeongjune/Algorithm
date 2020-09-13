package 이분탐색.프로그래머스.입국심사;

import java.util.Arrays;

class Solution {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);
        long start = 1, end = (long) times[times.length - 1] * (long) n;

        while (start < end) {
            long mid = (start + end) / 2;
            long t = 0;
            for (int i = 0; i < times.length; i++) {
                t += mid / times[i];
            }
            if (t >= n) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return answer = end;
    }
}