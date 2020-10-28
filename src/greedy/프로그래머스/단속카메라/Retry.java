package greedy.프로그래머스.단속카메라;

import java.util.Arrays;

public class Retry {
    public static int solution(int[][] routes) {
        int answer = 0;
        int camera = -30001;
        Arrays.sort(routes, (o1, o2) -> o1[1] - o2[1]);


        for (int[] route : routes) {
            if (camera < route[0]) {
                camera = route[1];
                answer++;
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        solution(new int[][]{
                {-20, 15},
                {-14, -5},
                {-18, -13},
                {-5, -3}
        });
    }
}
