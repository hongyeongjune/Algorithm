package 리트코드.LeetCode_1641_CountSortedVowelStrings;

import java.util.Arrays;

public class Solution {
    public int countVowelStrings(int n) {
        int[][] memo = new int[n + 1][5];

        Arrays.fill(memo[1], 1);

        for (int i = 2; i <= n; i++) {
            memo[i][0] = 1;
            for (int j = 1; j < 5; j++) {
                int sum = 0;
                for (int k = 0; k <= j; k++) sum += memo[i - 1][k];
                memo[i][j] = sum;
            }
        }

        return Arrays.stream(memo[n]).sum();
    }
}
