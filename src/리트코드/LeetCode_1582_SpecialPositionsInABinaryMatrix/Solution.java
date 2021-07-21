package 리트코드.LeetCode_1582_SpecialPositionsInABinaryMatrix;

public class Solution {
    public int numSpecial(int[][] mat) {
        int answer = 0;
        for (int i = 0; i < mat.length; i++) {
            for (int j = 0; j < mat[i].length; j++) {
                if (mat[i][j] == 1 && specialCheck(mat, i, j))
                    answer++;
            }
        }

        return answer;
    }

    private boolean specialCheck(int[][] mat, int row, int col) {
        for (int i = 0; i < mat[0].length; i++) {
            if (i != col && mat[row][i] != 0) return false;
        }

        for (int i = 0; i < mat.length; i++) {
            if (i != row && mat[i][col] != 0) return false;
        }

        return true;
    }
}
