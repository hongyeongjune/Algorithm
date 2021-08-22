package 리트코드.LeetCode_1895_LargestMagicSquare;

public class Solution {

    public int largestMagicSquare(int[][] grid) {
        int rowLength = grid.length;
        int columnLength = grid[0].length;
        int[][] rowSum = new int[rowLength][columnLength + 1];
        int[][] columnSum = new int[rowLength + 1][columnLength];

        for (int i = 0; i < rowLength; i++) {
            for (int j = 0; j < columnLength; j++) {
                rowSum[i][j + 1] = rowSum[i][j] + grid[i][j];
                columnSum[i + 1][j] = columnSum[i][j] + grid[i][j];
            }
        }

        for (int size = Math.min(rowLength, columnLength); size > 1; size--) {
            for (int i = 0; i <= rowLength - size; i++) {
                for (int j = 0; j <= columnLength - size; j++) {
                    if (isMagicSquare(grid, i, j, size, rowSum, columnSum)) {
                        return size;
                    }
                }
            }
        }

        return 0;
    }

    private boolean isMagicSquare(int[][] grid, int row, int column, int size, int[][] rowSum, int[][] columnSum) {
        int rightDiagonal = 0;
        int leftDiagonal = 0;

        int sum = rowSum[row][column + size] - rowSum[row][column];

        for (int i = 0; i < size; i++) {
            rightDiagonal += grid[row + i][column + i];
            leftDiagonal += grid[row + size - 1 - i][column + i];
            if (rowSum[row + i][column + size] - rowSum[row + i][column] != sum || columnSum[row + size][column + i] - columnSum[row][column + i] != sum)
                return false;
        }

        return rightDiagonal == sum && leftDiagonal == sum;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        solution.largestMagicSquare(new int[][]{
                {7, 1, 4, 5, 6}, {2, 5, 1, 6, 4}, {1, 5, 4, 3, 2}, {1, 2, 7, 3, 4}
        });
    }

}
