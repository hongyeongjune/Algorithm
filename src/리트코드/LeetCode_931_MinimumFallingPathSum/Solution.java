package 리트코드.LeetCode_931_MinimumFallingPathSum;

import java.util.Arrays;

public class Solution {
    public int minFallingPathSum(int[][] matrix) {

        for (int i = matrix.length - 2; i >= 0; i--) {
            for (int j = 0; j < matrix.length; j++) {
                int current = matrix[i + 1][j];
                if (j > 0) current = Math.min(current, matrix[i + 1][j - 1]);
                if (j + 1 < matrix.length) current = Math.min(current, matrix[i + 1][j + 1]);

                matrix[i][j] += current;
            }
        }

        return Arrays.stream(matrix[0]).min().getAsInt();
    }
}
