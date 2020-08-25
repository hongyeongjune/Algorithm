package greedy.프로그래머스.단속카메라;

import java.util.Arrays;

public class Solution {
    public int solution(int[][] routes) {
        int answer = 0;
        int camera = -300001;

        Arrays.sort(routes, (a, b) -> Integer.compare(a[1], b[1]));

        for(int[] r : routes) {
            if(camera < r[0]) {
                camera = r[1];
                answer++;
            }
        }

        return answer;
    }
}
