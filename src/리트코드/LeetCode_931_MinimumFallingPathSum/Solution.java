package 리트코드.LeetCode_931_MinimumFallingPathSum;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {

        //아래서부터 올라옴
        for (int i = matrix.length - 2; i >= 0; i--) {
            // 모든 열 검사
            for (int j = 0; j < matrix.length; j++) {
                // 같은 열 다음 행 값 뽑아내기
                int current = matrix[i + 1][j];
                // Out of Range 고려해서 조건 설정
                // 이전 열 다음 행 값과 비교
                if (j > 0) current = Math.min(current, matrix[i + 1][j - 1]);
                // 다음 열 다음 행 값과 비교
                if (j + 1 < matrix.length) current = Math.min(current, matrix[i + 1][j + 1]);

                // 현재 값에 가장 작은 값을 더해준다.
                matrix[i][j] += current;
            }
        }

        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
