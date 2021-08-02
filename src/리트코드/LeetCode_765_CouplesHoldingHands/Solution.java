package 리트코드.LeetCode_765_CouplesHoldingHands;

public class Solution {
    public int minSwapsCouples(int[] row) {
        int[] arr = new int[row.length];
        for (int i = 0; i < arr.length; i++) {
            arr[row[i]] = i;
        }

        int answer = 0;
        for (int i = 0; i < row.length; i += 2) {
            int pair = row[i] % 2 == 0 ? row[i] + 1 : row[i] - 1;
            if (row[i + 1] != pair) {
                swap(row, arr, i + 1, arr[pair]);
                answer++;
            }
        }

        return answer;
    }

    private void swap(int[] row, int[] arr, int i, int j) {
        int temp = row[i];
        row[i] = row[j];
        row[j] = temp;

        temp = arr[row[i]];
        arr[row[i]] = arr[row[j]];
        arr[row[j]] = temp;
    }
}
