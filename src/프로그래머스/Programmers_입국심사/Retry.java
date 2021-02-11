package 프로그래머스.Programmers_입국심사;

import java.util.Arrays;

public class Retry {
    public long solution(int n, int[] times) {
        long answer = 0;
        Arrays.sort(times);

        long start = 1, end = (long) times[times.length - 1] * (long) n;

        while (start <= end) {

            long mid = (start + end) / 2;
            long temp = 0;
            
            for (int time : times) temp += (mid / time);

            if (temp >= n) end = mid;
            else start = mid + 1;

        }

        return answer = end;
    }
}
