package 프로그래머스.Programmers_정수삼각형;

import java.util.Arrays;

public class Retry {
    public static int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            for (int j = 0; j < triangle[i].length; j++) {
                if (j != 0 && j != i) {
                    triangle[i][j] +=
                            Math.max(triangle[i - 1][j - 1], triangle[i - 1][j]);
                } else if (j == 0 && j != i) {
                    triangle[i][j] += triangle[i - 1][j];
                } else if (j != 0 && j == i) {
                    triangle[i][j] += triangle[i - 1][j - 1];
                }
            }
        }

        Arrays.sort(triangle[triangle.length - 1]);


        return triangle[triangle.length - 1][triangle[triangle.length - 1].length - 1];
    }

}
