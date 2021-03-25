package 프로그래머스.Programmers_징검다리;

import java.util.Arrays;

public class Solution {
    public int solution(int distance, int[] rocks, int n) {

        Arrays.sort(rocks);

        return binarySearch(distance, rocks, n);

    }

    private int binarySearch(int distance, int[] rocks, int n) {

        long answer = 0;

        long left = 0;
        long right = distance;

        while (left <= right) {

            long mid = (left + right) / 2;
            long previous = 0;
            long count = 0;

            for (int i = 0; i < rocks.length; i++) {

                if (rocks[i] - previous < mid) {
                    count++;
                } else previous = rocks[i];
            }


            if (distance - previous < mid) count++;

            if (count <= n) {
                answer = Math.max(answer, mid);
                left = mid + 1;
            } else right = mid - 1;
        }

        return (int) answer;
    }
}
